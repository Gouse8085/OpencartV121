package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage {
	
	WebDriver driver;

	public AccountRegistration(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(id="input-firstname")
	WebElement txtFirstName;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastName;

@FindBy(xpath="//input[@id='input-email']']")
WebElement txtEmail;

@FindBy(name="telephone")
WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@id='input-confirm']]")
WebElement txtConfirmPw;

@FindBy(xpath="//input[@name='agree']")
WebElement ckdPoicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;



public void setFirstName(String fname) {
	txtFirstName.sendKeys("fname");
	
}


public void setLastName(String lname) {
	txtLastName.sendKeys("lname");
	
}
public void setEmail(String email) {
	txtEmail.sendKeys("email");
	
}
public void setTeleone(String tel) {
	txtTelephone.sendKeys("tel");
	
}
public void setPassword(String pwd) {
	txtPassword.sendKeys("pwd");
	
}
public void setCnfrmPassword(String pwd) {
	txtConfirmPw.sendKeys("pwd");
	
}
public void setPrivacypolicy() {
	ckdPoicy.click();
	
}
public void clickContinue() {
	btnContinue.click();
	
}
public String getConfirmatonMsg()
{
	try {
		
		return (msgConfirmation.getText());
	}
	
	catch(Exception e)
	{
		
		return (e.getMessage());
	}
}
}
