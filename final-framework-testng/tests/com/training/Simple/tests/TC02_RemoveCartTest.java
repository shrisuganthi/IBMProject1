package com.training.Simple.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Admin_LoginPOM;
import com.training.pom.CheckoutPOM;
import com.training.pom.Earing_POM;
import com.training.pom.LoginPOM;
import com.training.pom.ViewCartPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.TestUtil;

public class TC02_RemoveCartTest {

	private WebDriver driver;
	private String baseURL;
	private LoginPOM loginPOM;
	private Earing_POM earingPOM;
	private CheckoutPOM checkoutPOM;
	private ViewCartPOM viewcartPOM;
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
	  
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
				//Instantiate Action Class        
	      Actions actions = new Actions(driver);
          WebElement ringSelect = driver.findElement(By.xpath("//*[@id=\'BestsellerProducts_Yllc2v2l\']/div/div/div/div/div[3]/div/div/div[1]/h4/a"));
	      actions.moveToElement(ringSelect).perform();
	      ringSelect.click();
	      
			 //Product added to the cart
		  WebElement addtoCart = driver.findElement(By.xpath("//button[@id='button-cart']"));
		  addtoCart.click();
		  System.out.println("The Product has been added to the cart successfully");

	      
		/*
		 * Earing_POM earing = new Earing_POM(driver); earing.viewProduct();
		 * 
		 * //added the product to cart WebElement addtoCart =
		 * driver.findElement(By.id("button-cart")); addtoCart.click();
		 * System.out.println("The Product has been added to the cart successfully");
		 */		  
		 // Thread.sleep(50);
		  //Mouse over to view the cart
		  
		/*
		 * WebElement viewCart
		 * =driver.findElement(By.xpath("//*[@id=\'cart\']/ul/li/h3/a/i"));
		 * actions.moveToElement(viewCart).perform(); viewCart.click();
		 * System.out.println("Mouse over to View Cart");
		 */
		
		/*
		 * WebElement viewCart =
		 * driver.findElement(By.xpath("//*[@id='cart']/ul/li/div/div/div[3]/a[1]"));
		 * actions.moveToElement(viewCart).perform(); viewCart.click();
		 */
		 
		  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		  
		  Earing_POM earingPOM = new Earing_POM(driver);
		  earingPOM.mouseovertCartImage();
		 
		  ViewCartPOM viewcartPOM = new ViewCartPOM(driver); 

		 viewcartPOM.viewCart();
		 	 
		 
		  WebElement removefromCart = driver.findElement(By.xpath("//i[@class='fa fa-times-circle']"));
		  removefromCart.click();
		  System.out.println("Remove from Cart clicked");
		  
		  WebElement updatCart1 = driver.findElement(By.xpath("//i[@class='fa fa-refresh']"));
		  updatCart1.click();
		  System.out.println("Update Button clicked");
		  
		  WebElement chkoutBtn = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		  chkoutBtn.click();
		  System.out.println("Checkout Button is clicked");
		  
		  WebElement verifyMesg = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div"));
		 // verifyMesg.getText();
		  Assert.assertEquals(true, verifyMesg.isDisplayed());
		  
		         
	     
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		//Thread.sleep(500);
		//driver.quit();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}

}
