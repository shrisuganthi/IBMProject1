package com.training.Simple.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.BaseClassPOM;
import com.training.pom.Dashboard_HomePOM;
import com.training.pom.Earing_POM;
import com.training.pom.LoginPOM;
import com.training.pom.ViewCartPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.TestUtil;

public class TC01_ViewCartTest {
	
	
	private WebDriver driver;
	private String baseURL;
	private LoginPOM loginPOM;
	private Earing_POM earingPOM;
	private static Properties properties;
	private ScreenShot screenshot;
	private Alert alert;
	//private String Earing_POM;
		
	
	  @BeforeClass public static void setUpBeforeClass() throws IOException
	  {
	  properties = new Properties(); FileInputStream inStream = new
	  FileInputStream("./resources/others.properties"); properties.load(inStream);
	  }
	 	
	  @BeforeMethod public void setUp() throws Exception 
	  { 
	  driver =  DriverFactory.getDriver(DriverNames.CHROME); 
	  //loginPOM = new LoginPOM(driver);
	  baseURL = properties.getProperty("baseURL"); 
	  screenshot = new  ScreenShot(driver); driver.get(baseURL);
	  driver.manage().window().maximize();
	  }
	 
	
	@Test
	public void namsedRing() throws InterruptedException
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		//Instantiate Action Class        
	      Actions actions = new Actions(driver);
       //   WebElement ringSelect = driver.findElement(By.xpath("//*[@id=\'BestsellerProducts_Yllc2v2l\']/div/div[1]/div/div/div[10]/div/div/div[2]/div[1]/a/span/span/img"));
	      WebElement ringSelect = driver.findElement(By.xpath("//*[@id=\'BestsellerProducts_Yllc2v2l\']/div/div/div/div/div[3]/div/div/div[1]/h4/a"));
	      actions.moveToElement(ringSelect).perform();
	      ringSelect.click();
	      
		 //Product added to the cart
		  WebElement addtoCart = driver.findElement(By.xpath("//button[@id='button-cart']"));
		  addtoCart.click();
		  System.out.println("The Product has been added to the cart successfully");
		  	 
		      
		  //Mouse over the cart icon and click
		 // WebElement viewCart = driver.findElement(By.xpath("//*[@id=\'cart\']/ul/li/h3/a/i"));
		/*
		 * WebElement mouseoverviewCart =
		 * driver.findElement(By.xpath("//span[@class='tb_items'][contains(text(),'1')]"
		 * )); actions.moveToElement(mouseoverviewCart).perform();
		 */  //mouseoverviewCart.click();
		  
		  //clicking on the view cart button
		
		  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		  
		  Earing_POM earingPOM = new Earing_POM(driver);
		  earingPOM.mouseovertCartImage();
		
		 // Actions  actions = new Actions(driver);
			WebElement clikViewcart = driver.findElement(By.xpath("//a[contains(text(),'View Cart')]"));
			 // actions.moveToElement(clikViewcart).perform(); 
			  clikViewcart.click();
			  System.out.println("View Cart Btn is clicked");
			  
		  ViewCartPOM viewcartPOM = new ViewCartPOM(driver); 
		//  viewcartPOM.clickonviewCartBtn();
		 viewcartPOM.viewCart();
		  
		  
				
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		Thread.sleep(500);
		//driver.quit();
		//driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}

	
}

