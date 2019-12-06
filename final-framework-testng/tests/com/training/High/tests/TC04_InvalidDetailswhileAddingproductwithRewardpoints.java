package com.training.High.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewProductsPOM;
import com.training.pom.Admin_LoginPOM;
import com.training.pom.CategoriesPOM;
import com.training.pom.CatelogPOM;
import com.training.pom.Dashboard_HomePOM;
import com.training.readexcel.ReadExcel;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC04_InvalidDetailswhileAddingproductwithRewardpoints {


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
	private String disquantity;
	private String disPrice;
	private String disStartDate;
	private String disEndDate;
	
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
	public void adminaddMultipleProd (String prodName, String metaTag, String modelBox, String priceBox, String quantityBox, String categoryBox) throws InterruptedException 
	{
				
		addnewproductsPOM.generalTabentry(prodName, metaTag);
		addnewproductsPOM.dataTabentryclick();
		addnewproductsPOM.dataTabentry(modelBox, priceBox, quantityBox);
		addnewproductsPOM.linksTabentryClick();
		addnewproductsPOM.linksTabentry(categoryBox);
		
		addnewproductsPOM.discountTabclick();
		addnewproductsPOM.discountAddlink();
		
		addnewproductsPOM.discountAddDetails(disquantity,disPrice);
		
		addnewproductsPOM.disStartDate(disStartDate);
		addnewproductsPOM.disEndDate(disEndDate);
		
		addnewproductsPOM.rewardTabClick();
		
		//addnewproductsPOM.parameteraddnewProducts(prodName, metaTag, modelBox, priceBox, quantityBox, categoryBox);
		addnewproductsPOM.clickSave();
		
		
	}	
	
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	
}

