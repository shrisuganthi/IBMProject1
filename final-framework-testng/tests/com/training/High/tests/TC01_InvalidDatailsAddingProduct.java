package com.training.High.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewProductsPOM;
import com.training.pom.Admin_LoginPOM;
import com.training.pom.BaseClassPOM;
import com.training.pom.CategoriesPOM;
import com.training.pom.CatelogPOM;
import com.training.pom.CheckoutPOM;
import com.training.pom.Dashboard_HomePOM;
import com.training.pom.Earing_POM;
import com.training.pom.EditCategoryPOM;
import com.training.pom.LoginPOM;
import com.training.pom.OrderHistoryPOM;
import com.training.pom.ProductsPOM;
import com.training.pom.SalesOrderPOM;
import com.training.pom.TestData;
import com.training.pom.UserLoginPOM;
import com.training.pom.ViewCartPOM;
import com.training.readexcel.ReadExcel;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.TestUtil;

public class TC01_InvalidDatailsAddingProduct  {
	

	private WebDriver driver;
	private String adminURL;
	private Admin_LoginPOM admin1;
	private static Properties properties;
	private ScreenShot screenShot;
	private Admin_LoginPOM Admin_LoginPOM;
	private Dashboard_HomePOM dashboardPOM;
	private CategoriesPOM categoriesPOM;
	private CatelogPOM catelogPOM;
	private AddNewProductsPOM addnewproductsPOM;
	private String[] args;
	private String data;
	private String[] testdata1;
	
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
	

	
	@Test(priority=1)
	public void catalogLoginTest() {
			
		admin1 = new Admin_LoginPOM(driver);
		admin1.retailAdminlogin("admin", "admin@123");
	 	 admin1.adminLoginBtn();
	 	 
		dashboardPOM = new Dashboard_HomePOM(driver);
		dashboardPOM.getMessage();
		
		CatelogPOM catelogPOM = new CatelogPOM(driver);
		catelogPOM.clickonCatelog();
		catelogPOM.selectProductslink();
		
		addnewproductsPOM = new AddNewProductsPOM(driver);
		addnewproductsPOM.addNewProdLinktoclick();
			
	}
	
	  @DataProvider(name="getdata")
	  
	public Object[][] giveData() throws Exception{
			//return TestData.provideData(data);
			//return ReadExcel.main(testdata1,data);
			//ReadExcel.this.getExcelData(testdata1, data);
			ReadExcel.main(testdata1);
			return null;
	  }
	  
	  
	  
	@Test(dataProvider="getData")
	public void addaproductusinginvaliddetails (String prodName, String metaTag, String modelBox, String priceBox, String quantityBox, String categoryBox) throws InterruptedException 
	{
				
		addnewproductsPOM.generalTabentry(prodName, metaTag);
		addnewproductsPOM.dataTabentryclick();
		addnewproductsPOM.dataTabentry(modelBox, priceBox, quantityBox);
		addnewproductsPOM.linksTabentryClick();
		addnewproductsPOM.linksTabentry(categoryBox);
		
		//addnewproductsPOM.parameteraddnewProducts(prodName, metaTag, modelBox, priceBox, quantityBox, categoryBox);
		addnewproductsPOM.clickSave();
		
		
	}	
	
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}





}