package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
public Logger logger;
public Properties p ;//log4j

	 @BeforeClass
	 @Parameters({"os","browser"})
		public void setup(String os, String br) throws IOException
		{
		 
		 //loading config.prop file
		 
		 FileReader file=new FileReader(".src//test//resources//config.properties");
		 p.load(file);
		 
			logger=LogManager.getLogger(this.getClass());
			
			switch(br.toLowerCase())
			
			{
			
			case "chrome":driver=new ChromeDriver(); break;

			case "edge":driver=new	EdgeDriver(); break;
			case "firefox":driver=new FirefoxDriver(); break;
			default:System.out.println("Invalid browser name..."); return;

			
			}

			driver=new EdgeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			driver.get(p.getProperty("appurl"));  //reading url from prop file
			driver.manage().window().maximize();
			
		}
		@AfterClass
	public void tearDown()
	{
		driver.quit();
	 }
		public String randomString()
		{
			
			String generatedstring= RandomStringUtils.randomAlphabetic(5);
			return generatedstring;
		}
		public String randomNumber()
		{
			
			String generatednumber= RandomStringUtils.randomNumeric(10);
			return generatednumber;
		}
		public String randomAlphaNumber()
		{
			
			@SuppressWarnings("deprecation")
			String generatedstring= RandomStringUtils.randomAlphabetic(3);
			String generatednumber= RandomStringUtils.randomNumeric(3);
			return(generatedstring+generatednumber);
		}
}
