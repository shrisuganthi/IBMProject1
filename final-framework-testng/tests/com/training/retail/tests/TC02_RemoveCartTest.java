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
import com.training.pom.Admin_LoginPOM;
import com.training.pom.CheckoutPOM;
import com.training.pom.Earing_POM;
import com.training.pom.LoginPOM;
import com.training.pom.ViewCartPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

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
          WebElement ringSelect = driver.findElement(By.xpath("//*[@id=\'BestsellerProducts_Yllc2v2l\']/div/div[1]/div/div/div[10]/div/div/div[2]/div[1]/a/span/span/img"));
	      actions.moveToElement(ringSelect).perform();
	      ringSelect.click();
	      
	      Earing_POM earing = new Earing_POM(driver);
	      earing.viewProduct();
		
	      //added the product to cart
		  WebElement addtoCart = driver.findElement(By.id("button-cart"));
		  addtoCart.click();
		  System.out.println("The Product has been added to the cart successfully");
		  
		  Thread.sleep(50);
		  //Mouse over to view the cart
		  WebElement viewCart =driver.findElement(By.xpath("//*[@id=\'cart\']/ul/li/h3/a/i"));
		  actions.moveToElement(viewCart).perform(); viewCart.click();
		  System.out.println("Mouse over to View Cart");
		  
		
		/*
		 * WebElement viewCart =
		 * driver.findElement(By.xpath("//*[@id='cart']/ul/li/div/div/div[3]/a[1]"));
		 * actions.moveToElement(viewCart).perform(); viewCart.click();
		 */
		 
		
		  WebElement movetoCart = driver.findElement(By.xpath("//*[@id='cart']/ul/li/div/div/div[3]/a[1]"));
		  actions.moveToElement(movetoCart).perform(); movetoCart.click();
		  System.out.println("Clicked on View Cart");
		 
		/*
		 * ViewCartPOM check = new ViewCartPOM(driver); check.getMessage();
		 */
		
		
		  
//		WebElement removefromCart = driver.findElement(By.cssSelector("#cart_form > div > table > tbody > tr > td.quantity > div > span > button.btn.btn-danger.tb_no_text > i"));
		//WebElement removefromCart = driver.findElement(By.xpath(""));
	//	actions.moveToElement(removefromCart).perform();
		//removefromCart.click();
		
	//	WebElement updateCart = driver.findElement(By.xpath("//*[@id='cart_form']/div/table/tbody/tr/td[4]/div/span/button[1]"));
		//actions.moveToElement(updateCart).perform();
		//updateCart.click();
	
		/*
		 * CheckoutPOM check = new CheckoutPOM(driver); check.viewProduct();
		 */
	         
	     
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		//Thread.sleep(500);
		//driver.quit();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}

}
