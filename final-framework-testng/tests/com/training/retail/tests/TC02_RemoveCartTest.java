package com.training.retail.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC02_RemoveCartTest {

	private WebDriver driver;
	private String baseURL;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenshot;
		
	@BeforeClass
	public static void setUpBeforeClass() throws IOException
	{
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		baseURL = properties.getProperty("baseURL");
		screenshot = new ScreenShot(driver);
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void namsedRing() throws InterruptedException
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(5000);		  
		  
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		//Instantiate Action Class        
	      Actions actions = new Actions(driver);
        //Retrieve WebElement 'Integer Vitae Iaculis Massa product' to perform mouse hover 
	      WebElement menuOption = driver.findElement(By.xpath("//*[@id=\'BestsellerProducts_Yllc2v2l\']/div/div[1]/div/div/div[10]/div/div/div[2]/div[1]/a/span/span/img"));
	     //Mouse hover image 'Integer Vitae Iaculis Massa product'
	     actions.moveToElement(menuOption).perform();
	     menuOption.click();
	     
	     WebElement addtoCart = driver.findElement(By.xpath("//*[@id=\"button-cart\"]"));
	     addtoCart.click();	     
	     
	     WebElement shopCart = driver.findElement(By.xpath("//*[@id=\'cart\']/ul/li/h3/a/i"));
	     actions.moveToElement(shopCart).perform();
	     shopCart.click();
	     
	     
	     WebElement remove = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[3]/div[2]/div/ul/li/div/div/div[1]/table/tbody/tr/td[5]/button"));
	     actions.moveToElement(remove).perform();
	     remove.click();
	     
	    // WebElement update = driver.findElement(By.xpath("/html/body"))
	     
	     WebElement viewCart = driver.findElement(By.linkText("//*[@id=\'cart\'"));
		 actions.moveToElement(viewCart).perform(); 
		 viewCart.click();
		 
	     
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		Thread.sleep(500);
		//driver.quit();
	}

}
