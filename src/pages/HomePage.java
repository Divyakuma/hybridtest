package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign In')]") WebElement signinLink;
	
	@FindBy(xpath="//a[contains(text(),'My Account')]") WebElement AccountLink;
	
	@FindBy(xpath="//a[contains(text(),'My cart')]") WebElement MycartLink;
	
	@FindBy(xpath="//a[contains(text(),'Checkout')]") WebElement CheckoutLink;

	
	public void signinLink()
	{
		signinLink.click();
	}
	
	public void AccountLink()
	{
		AccountLink.click();
	}
	
	public void MycartLink()
	{
		MycartLink.click();;
	}
	
	public void CheckoutLink()
	{
		CheckoutLink.click();;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	

}
