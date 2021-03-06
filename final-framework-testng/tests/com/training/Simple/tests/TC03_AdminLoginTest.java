package com.training.Simple.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Admin_LoginPOM;
import com.training.pom.CategoriesPOM;
import com.training.pom.Dashboard_HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC03_AdminLoginTest {

	private WebDriver driver;
	private String adminURL;
	private Admin_LoginPOM admin1;
	private static Properties properties;
	private ScreenShot screenShot;
	private Admin_LoginPOM Admin_LoginPOM;
	private Dashboard_HomePOM dashhomePOM;
	private CategoriesPOM categoriesPOM;
	
	  @BeforeClass 
	  public void setUp() throws Exception {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		
	  }
	  @BeforeMethod
	  public void beforeMethod()
	  {
		  driver = DriverFactory.getDriver(DriverNames.CHROME);	
		  adminURL = properties.getProperty("adminURL");
		  driver.get(adminURL);
		  screenShot = new ScreenShot(driver);
		  driver.manage().window().maximize();
		  // Admin_LoginPOM = new Admin_LoginPOM(driver);
		   
			
	  }
	 
	
	  @Test		
	public void adminuserLogintest() throws InterruptedException
	{
		  Admin_LoginPOM Admin_LoginPOM = new Admin_LoginPOM(driver);
		  Admin_LoginPOM.retailAdminlogin("admin", "admin@123");
			Admin_LoginPOM.adminLoginBtn();
		//Dashboard_HomePOM dash = new Dashboard_HomePOM(driver);
		//dash.getMessage(); 
	
	}
	
		@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	
		
}
