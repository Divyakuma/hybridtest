package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;
import utility.Helper;

public class VerifyLoginPageWithScreenshot {
	WebDriver driver;
	
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{
		report=new ExtentReports("D:\\DivyaBackup\\workspace\\ProjectPractice2\\Reports\\test.html", true);
		
		logger=report.startTest("verify login");
		
		driver =BrowserFactory.getbrowser("firefox");
		
		driver.get(DataProviderFactory.getconfig().getURL());
		
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void TestLoginPage()
	{
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		String title=home.getTitle();
		System.out.println("App title is: "+title);
		Assert.assertTrue(title.contains("Demoxxx Store"));
		
		logger.log(LogStatus.PASS, "Home page title is verified");
		
		home.signinLink();
		
		logger.log(LogStatus.INFO, "Click on sign in link");
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		login.loginApplication(DataProviderFactory.getexcel().getdata(0, 1, 0), DataProviderFactory.getexcel().getdata(0, 1, 1));
		
		logger.log(LogStatus.INFO, "Login to application");
		
		login.verifysignOut();
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.getScreenshot(driver, "signOut screen")));
		
		logger.log(LogStatus.PASS, "sign out link is present");
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshotPath=Helper.getScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath) );
		}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
