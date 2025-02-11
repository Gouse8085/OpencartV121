package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
 public void verify_loginDDT(String email,String pwd,String exp) {
	 
 }
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLoginr();
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(p.getProperty();
	lp.setPassword();
	lp.clickLogin();
	
	MyAccountPage mac=new MyAccountPage(driver);
	boolean targetPage=mac.isMyAccountPageExists();
	
	if(exp.equalsIgnoreCase("Valid"))
	{
		
		if(targetPage==true) {
			Assert.assertTrue(true);
			mac.clickLogout();
		}
		else
		{
			Assert.assertTrue(false);

		}
	}
	
	if(exp.equalsIgnoreCase("InValid"))
	{
		
		if(targetPage==true) {
			mac.clickLogout();
			Assert.assertTrue(false);
			
		}
		else
		{
			assert.assertTrue(true);
			}
		}
	}
}  
