package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataProvider.ExcelDataProvider;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver =BrowserFactory.getbrowser("firefox");
		driver.get(DataProviderFactory.getconfig().getURL());
	}
	
	@Test
	public void TestHomePage()
	{
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		String title=home.getTitle();
		System.out.println("App title is: "+title);
		Assert.assertTrue(title.contains("Demo Store"));
		home.signinLink();
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		login.loginApplication(DataProviderFactory.getexcel().getdata(0, 1, 0), DataProviderFactory.getexcel().getdata(0, 1, 1));
		login.verifysignOut();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}
