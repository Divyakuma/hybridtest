package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath=".//*[@id='account_sign_in_form_email_id']") WebElement email;
	@FindBy(xpath=".//*[@id='account_sign_in_form_passwd_id']") WebElement password;
	@FindBy(xpath="//input[@value='Sign In']") WebElement loginButton;
	By signout= By.xpath("//a[@href='http://demo.avactis.com/4.8.0/sign-in.php?asc_action=customer_sign_out']"); 
 	
	public void loginApplication(String user,String pass)
	{
		email.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}
	
	public void verifysignOut()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement ele =wait.until(ExpectedConditions.presenceOfElementLocated(signout));
		String text=ele.getText();
		Assert.assertEquals(text, "Sign Out", "sign out link not verified");
	}
	
	

}
