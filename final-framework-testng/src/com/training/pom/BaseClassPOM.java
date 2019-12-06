package com.training.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.opc.PackageProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.TestUtil;

public class BaseClassPOM {
	
	static WebDriver driver;
	static Properties prop;
	
	private static String baseURL;
	private static LoginPOM loginPOM;
	private static Admin_LoginPOM adminloginPOM;
	private static Properties properties;
	private static ScreenShot screenshot;
	//private Earing_POM earingPOM;
	//private String Earing_POM;
	public String dataSheetName;
	private String userid;
	private String pass;
	

	public BaseClassPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		public void beforeClassStartup() throws Exception
		{
			 properties = new Properties(); 
			 FileInputStream inStream = new FileInputStream("./resources/others.properties"); 
			 properties.load(inStream);
		}
		
		public void startRetailHome()
		{
		System.setProperty("webdriver.chrome.driver","C:\\IBMUpskill_Nov\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get("http://retailm1.upskills.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
	
		public void startRetailAdmin()
		{
			System.setProperty("webdriver.chrome.driver","C:\\IBMUpskill_Nov\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();	
			driver.get("http://retail.upskills.in/admin");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
			adminloginPOM.retailAdminlogin(userid, pass);
			adminloginPOM.adminLoginBtn();
		}
		
		
	public void selectProduct() {
		//Select sel=new Select(ele);
		//sel.selectByVisibleText(value);
		}

	public void productsloginLink()
	{
		WebElement catalog = driver.findElement(By.xpath("//span[contains(text(),'Catalog')]']"));
		catalog.click();
		WebElement products = driver.findElement(By.xpath("//ul[@class='collapse in']//a[contains(text(),'Products')]"));
		products.click();
	}
	
	public void addNewProducts()
	{
		WebElement addNewicon = driver.findElement(By.xpath("//i[@class='fa fa-plus']"));
		addNewicon.click();
		
		WebElement prodName = driver.findElement(By.xpath("//input[@id='input-name1']"));
		prodName.click();
		
		
		//MetaTagFileName
		WebElement metaTag = driver.findElement(By.xpath("//input[@id='input-meta-title1']"));
		metaTag.click();
				
		WebElement dataTab = driver.findElement(By.xpath("//a[contains(text(),'Data')]"));
		dataTab.click();
		
		WebElement linksTab = driver.findElement(By.xpath("//a[contains(text(),'Links')]"));
		WebElement attribTab = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(),'Attribute')]"));
		WebElement optionTab = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(),'Option')]"));
		WebElement recurTab = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(),'Recurring')]"));
		WebElement discountTab = driver.findElement(By.xpath("//a[contains(text(),'Discount')]"));
		WebElement specialTab = driver.findElement(By.xpath("//a[contains(text(),'Special')]"));
		WebElement imageTab = driver.findElement(By.xpath("//a[contains(text(),'Image')]"));
		WebElement rewardTab = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(),'Reward Points')]"));
		WebElement designTab = driver.findElement(By.xpath("//a[contains(text(),'Design')]"));
		
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.close();

	}


	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
	driver.quit();

	}

	
}
 
	
	

