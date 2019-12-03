package com.training.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.opc.PackageProperties;
import org.openqa.selenium.WebDriver;

import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.TestUtil;

public class BaseClassPOM {
	
	static WebDriver driver;
	static Properties prop;
	
	private static String baseURL;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenshot;
	//private Earing_POM earingPOM;
	//private String Earing_POM;
	

	public BaseClassPOM()
	{
		try
		{
			prop = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			prop.load(inStream);
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	

	public static void initialization() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		baseURL = properties.getProperty("baseURL");
		screenshot = new ScreenShot(driver);
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	}
}
