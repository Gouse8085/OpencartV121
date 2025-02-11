package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test
	public void  verify_login()
	{
		logger.info("****starting TC_002_LoginTest****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginr();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage mac=new MyAccountPage(driver);
		boolean targetPage=mac.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true,"Login Failed");
		}
		catch(Exception e) {
		Assert.fail();	
		}
		
		logger.info("****finished TC_002_LoginTest****");

	}

}
