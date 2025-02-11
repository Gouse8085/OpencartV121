package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		
		super(driver);
	}
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement linMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement RegLink;
	
	@FindBy(linkText="Login")
	WebElement linkLogin;
	
	
	public void clickMyAccount()
	{
		linMyAccount.click();
		
	}
	public void clickRegister()
	{
		RegLink.click();
		
	}
	public void clickLoginr()
	{
		linkLogin.click();
		
	}
	
}


