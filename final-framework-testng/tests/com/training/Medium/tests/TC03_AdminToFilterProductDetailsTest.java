package com.training.Medium.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.training.generics.ScreenShot;
import com.training.pom.Admin_LoginPOM;
import com.training.pom.CategoriesPOM;
import com.training.pom.Dashboard_HomePOM;
import com.training.pom.Earing_POM;
import com.training.pom.EditCategoryPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ProductsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.TestUtil;

public class TC03_AdminToFilterProductDetailsTest {
	
	private WebDriver driver;
	private String baseURL;
	private LoginPOM loginPOM;
	private ProductsPOM productsPOM;
	private static Properties properties;
	private ScreenShot screenshot;
	private Admin_LoginPOM Admin_LoginPOM;
	private Dashboard_HomePOM dashboardPOM;
	private EditCategoryPOM editcategoryPOM;
	private CategoriesPOM categoriesPOM;
	private String addnewcategoryPOM;
	//private String Earing_POM;
	private String adminURL;
	private FluentWait<WebDriver> wait;
	
	SoftAssert softAssert = new SoftAssert();
	private Object categoryName;
	private String name;

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
		Admin_LoginPOM = new Admin_LoginPOM(driver);
		adminURL = properties.getProperty("adminURL");
		screenshot = new ScreenShot(driver); 
		driver.get(adminURL);
		driver.manage().window().maximize();
	}
	
	@Test	
	public void filterProductTest () throws InterruptedException {
		
		Admin_LoginPOM admin1 = new Admin_LoginPOM(driver);
		admin1.retailAdminlogin("admin", "admin@123");
		
		Dashboard_HomePOM dash = new Dashboard_HomePOM(driver);
		dash.getMessage();
		
		ProductsPOM productsPOM = new ProductsPOM(driver);
		productsPOM.getProductslink();
		productsPOM.filterProdname();
		System.out.println("Products displayed after the Product Name filter ");
		//productsPOM.getproductsScreen();
		productsPOM.filterPrice();
		System.out.println("Products displayed after the Price filter ");
		//productsPOM.getproductsScreen();
		productsPOM.filterStatus();
		System.out.println("Products displayed after the Status filter ");
		//productsPOM.getproductsScreen();
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		productsPOM.filterModel();
		System.out.println("Products displayed after the Model filter ");
		//productsPOM.getproductsScreen();
		
		productsPOM.filterQuantity();
		System.out.println("Products displayed after the Quantity filter ");
		//productsPOM.getproductsScreen();
		
		productsPOM.filterImage();
		System.out.println("Products displayed after the Image filter ");
		productsPOM.getproductsScreen();
		
		
		//to display the no.of rows & columns after the filter is applied
		//int rowcount = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//thead//tr")).size();
		//System.out.println("Rows present are ......"+rowcount);
		
		
	}

}
