package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	

	@Test
public void verify_account_registration()
{
	HomePage h=new HomePage(driver);
	h.clickMyAccount();
	h.clickRegister();
	
	AccountRegistration ac=new AccountRegistration(driver);
	ac.setFirstName(randomString().toUpperCase());
	ac.setLastName(randomString().toUpperCase(null));
	ac.setEmail(randomString()+"@gmail.com");
	ac.setTeleone(randomNumber());
	
	//string password=randomAlhanumeric()
	
	String password=randomAlphaNumber();
			
	ac.setPassword(password);
    ac.setCnfrmPassword(password);
    ac.setPrivacypolicy();
    ac.clickContinue();
    
String cnfrmmsg=ac.getConfirmatonMsg();
	Assert.assertEquals(cnfrmmsg, "Your Account Has Been Created! ");	
				
}
	
	
}
