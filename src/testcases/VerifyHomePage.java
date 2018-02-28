package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;

public class VerifyHomePage {
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
		Assert.assertTrue(title.contains("Demo Store"));
		System.out.println("App title is: "+title);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}
