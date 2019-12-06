package com.training.High.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Admin_LoginPOM;
import com.training.pom.CheckoutPOM;
import com.training.pom.Dashboard_HomePOM;
import com.training.pom.Earing_POM;
import com.training.pom.LoginPOM;
import com.training.pom.OrderHistoryPOM;
import com.training.pom.SalesOrderPOM;
import com.training.pom.UserLoginPOM;
import com.training.pom.ViewCartPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.TestUtil;

public class TC02_PlacingOrderandChangeOrderstatus {
	
	private WebDriver driver;
	private String baseURL;
	private LoginPOM loginPOM;
	private Earing_POM earingPOM;
	private ViewCartPOM viewcartPOM;
	private CheckoutPOM checkoutPOM;
	private UserLoginPOM userloginPOM;
	private static Properties properties;
	private ScreenShot screenshot;
	private Alert alert;
	private FluentWait<WebDriver> wait;
	private Object explicitwait1;
	
	private String adminURL;
	private Admin_LoginPOM adminloginPOM;
	private Dashboard_HomePOM dashhomePOM;
	
	private ScreenShot screenShot;
	
	
	  @BeforeClass public static void setUpBeforeClass() throws IOException
	  {
	  properties = new Properties(); FileInputStream inStream = new
	  FileInputStream("./resources/others.properties"); properties.load(inStream);
	  }
	 	
	
	  //@BeforeMethod 
	  //public void setUp() throws Exception 
	  //{ 
		//  driver =	  DriverFactory.getDriver(DriverNames.CHROME); //loginPOM = new
	  //LoginPOM(driver); 
	  //baseURL = properties.getProperty("baseURL");
	  //screenshot =  new ScreenShot(driver); 
	  //driver.get(baseURL);
	  //driver.manage().window().maximize(); }
	 
	 
	
	@Test(priority=1)
	
	public void userLoginTest()
	{
		driver =  DriverFactory.getDriver(DriverNames.CHROME); 
		  //loginPOM = new LoginPOM(driver);
		  baseURL = properties.getProperty("baseURL");
		  driver.get(baseURL);
		  screenshot = new  ScreenShot(driver); 
		  driver.get(baseURL);
		  driver.manage().window().maximize();
		  
		UserLoginPOM userloginPOM = new UserLoginPOM(driver);
			
		userloginPOM.userLogin();
	
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	  	//WebElement ringSelect=driver.findElement(By.partialLinkText("Trimmer"));
	  	WebElement ringSelect=driver.findElement(By.xpath("//*[@id='BestsellerProducts_Yllc2v2l']/div/div/div/div/div[3]/div/div/div[1]/h4/a"));
	    ringSelect.click();
	      
	    	
	      //Product added to the cart
		  WebElement addtoCart = driver.findElement(By.id("button-cart"));
		  addtoCart.click();
		  System.out.println("The Product has been added to the cart successfully");
		  
		   WebDriverWait wait1=new WebDriverWait(driver,30);
		  explicitwait1 = wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("noty_cont noty_layout_topRight")));
		  
	  
		  Earing_POM earingPOM = new Earing_POM(driver);
		  earingPOM.mouseovertCartImage();
		
		 Actions  actions = new Actions(driver);
			WebElement clikViewcart = driver.findElement(By.xpath("//a[contains(text(),'View Cart')]"));
			actions.moveToElement(clikViewcart).perform(); 
			  clikViewcart.click();
			  System.out.println("View Cart Btn is clicked");
			  
		  ViewCartPOM viewcartPOM = new ViewCartPOM(driver); 
		//  viewcartPOM.clickonviewCartBtn();
		 viewcartPOM.viewCart();
		   	  		  
		  	
		 //click on chekout button and enter the Billing & Delivery Details
	  
	  CheckoutPOM checkoutPOM = new CheckoutPOM(driver);
	  
	  checkoutPOM.clickOnchkoutBtn();

	  driver.close(); 
		  //to get the success message once the product is checkedout
		  //"Your order has been successfully processed!"
		 //String element = driver.findElement(By.xpath("//div[@class='alert alert-count']/p/b")).getText();
		 //System.out.println(element);
			 		
	}
	
	
@Test(priority=2)
	
	public void switchtoadminUserlogin()
      {
	//Switchto AdminURL window 
	//ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	//switches to new tab
	//driver.switchTo().window(tabs.get(1));
	driver = DriverFactory.getDriver(DriverNames.CHROME);
	adminURL = properties.getProperty("adminURL");
	screenShot = new ScreenShot(driver); 
	driver.get(adminURL);
	driver.manage().window().maximize();
		
	Admin_LoginPOM admin1 = new Admin_LoginPOM(driver);
	//UserLoginPOM userloginPOM = new UserLoginPOM(driver); 
	admin1.retailAdminlogin("admin", "admin@123");
		   
	Dashboard_HomePOM dash = new Dashboard_HomePOM(driver); 
	dash.getMessage();
	System.out.println("Dashboard screen displayed");
	
	SalesOrderPOM salesorderPOM = new SalesOrderPOM(driver);
	salesorderPOM.salesOrderviewandConfirm();
	System.out.println("Sales Order screen displayed");
	
	OrderHistoryPOM orderhistoryPOM = new OrderHistoryPOM(driver);
	orderhistoryPOM.orderHistoryPage();		
	System.out.println("Order History Page Displayed"); 
	
	driver.close();
	
	  //SwitchbacktoRetailUserLoginScreen 
	 // driver.switchTo().window(tabs.get(0));
		 
	}
	

@Test(priority=3)

public void retailuserConfirmorderstatus()
{
	  //  switch back to main screen user
		
	driver =  DriverFactory.getDriver(DriverNames.CHROME); 
	 baseURL = properties.getProperty("baseURL"); 
	 driver.get(baseURL);
	 
	UserLoginPOM userloginPOM = new UserLoginPOM(driver);  
	userloginPOM.userLogin();
	userloginPOM.accountLogin();	
	System.out.println("Success....The Order has been confirmed for the User");
	driver.close();
	
}
	
	
	@AfterMethod
	public void tearDown() throws Exception{
		//Thread.sleep(500);
		driver.quit();
		//driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}


}
