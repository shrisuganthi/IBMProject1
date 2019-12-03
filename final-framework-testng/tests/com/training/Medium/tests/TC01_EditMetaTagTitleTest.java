package com.training.Medium.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Admin_LoginPOM;
import com.training.pom.CategoriesPOM;
import com.training.pom.Dashboard_HomePOM;
import com.training.pom.Earing_POM;
import com.training.pom.EditCategoryPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC01_EditMetaTagTitleTest {

	private WebDriver driver;
	private String baseURL;
	private LoginPOM loginPOM;
	private Earing_POM earingPOM;
	private static Properties properties;
	private ScreenShot screenshot;
	private Admin_LoginPOM Admin_LoginPOM;
	//private String Earing_POM;
	private String adminURL;
	
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
	public void editMetatagTest () {
		
		Admin_LoginPOM admin1 = new Admin_LoginPOM(driver);
		admin1.retailAdminlogin("admin", "admin@123");
		Dashboard_HomePOM dash = new Dashboard_HomePOM(driver);
		dash.getMessage(); 
		
		/*
		 * WebElement element=
		 * driver.findElement(By.cssSelector("#menu-catalog > a > i")); element.click();
		 * WebElement element1=
		 * driver.findElement(By.xpath("//*[@id=\'menu-catalog\']/ul/li[1]/a"));
		 * element1.click();
		 */
				
		CategoriesPOM cat = new CategoriesPOM(driver);
		cat.getcategoryScreen();
		cat.getcategoryMessage(); 
		
		EditCategoryPOM editButton = new EditCategoryPOM(driver);
		editButton.clickoneditBtn();
		
		/*
		 * WebElement editButton= driver.findElement(By.xpath(
		 * "//*[@id='form-category']/div/table/tbody/tr[3]/td[4]/a"));
		 * editButton.click();
		 */
		
		WebElement metatagTitle = driver.findElement(By.xpath("//input[@id='input-meta-title1']"));
		metatagTitle.clear();
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  
		metatagTitle.sendKeys("ORNAMENTS");
		//System.out.println("Metatag title entered");
		
		WebElement metatagDescription = driver.findElement(By.xpath("//textarea[@id='input-meta-description1']"));
		metatagDescription.clear();
		metatagDescription.sendKeys("Ornaments for Ladies");
		
		js.executeScript("window.scrollTo(10, document.body.scrollHeight)");
		Actions actions = new Actions(driver);		

		//mouseover to Data Tab
		WebElement menuHoverData = driver.findElement(By.xpath("//a[contains(text(),'Data')]"));
		Assert.assertEquals(true, menuHoverData.isDisplayed());
		actions.moveToElement(menuHoverData).perform();
		menuHoverData.click();
		System.out.println("Data Tab is displayed with default values");
		
		//mouseover to Design Tab
		WebElement menuHoverDesign = driver.findElement(By.xpath("//a[contains(text(),'Design')]"));
		Assert.assertEquals(true, menuHoverDesign.isDisplayed());
		actions.moveToElement(menuHoverDesign).perform();
		menuHoverDesign.click();
		System.out.println("Design Tab is displayed with default values");		
		
		
		//Saving 
		WebElement saveEdit = driver.findElement(By.xpath("//i[@class='fa fa-save']"));
		saveEdit.click();
		
		/*
		 * Alert alert = driver.switchTo().alert(); System.out.println(alert.getText());
		 */
		
		WebElement confirmBoxBtn = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		confirmBoxBtn.isDisplayed();
		      
			
		/*
		 * try { WebDriverWait wait = new WebDriverWait(driver, 2);
		 * wait.until(ExpectedConditions.alertIsPresent()); Alert alert =
		 * driver.switchTo().alert(); System.out.println(alert.getText());
		 * alert.accept(); Assert.assertTrue(alert.getText().contains("Success")); }
		 * catch (Exception e) { //exception handling }
		 */
		
	}
	
	
		
	
}
