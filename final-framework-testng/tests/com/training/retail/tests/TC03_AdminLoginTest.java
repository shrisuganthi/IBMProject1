package com.training.retail.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Admin_LoginPOM;
import com.training.pom.Dashboard_HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC03_AdminLoginTest {

	private WebDriver driver;
	private String adminURL;
	private Admin_LoginPOM adminloginPOM;
	private Dashboard_HomePOM dashhomePOM;
	
	private static Properties properties;
	private ScreenShot screenShot;
	private Admin_LoginPOM Admin_LoginPOM;
	

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);	
		Admin_LoginPOM = new Admin_LoginPOM(driver);
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		driver.get(adminURL);
		driver.manage().window().maximize();
			
			
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void validAdminLoginTest() {
			
		Admin_LoginPOM admin1 = new Admin_LoginPOM(driver);
		
		admin1.retailAdminlogin("admin", "admin@123");
			
		Dashboard_HomePOM dash = new Dashboard_HomePOM(driver);
		dash.getMessage(); 
				
		}
		
}
