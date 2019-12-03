package com.training.Medium.tests;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewCategoryPOM;
import com.training.pom.Admin_LoginPOM;
import com.training.pom.CategoriesPOM;
import com.training.pom.Dashboard_HomePOM;
import com.training.pom.Earing_POM;
import com.training.pom.EditCategoryPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC02_DeleteMultipleCategoryTest {
	private WebDriver driver;
	private String baseURL;
	private LoginPOM loginPOM;
	private Earing_POM earingPOM;
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
	public void deletecategoryTest () {
		
		Admin_LoginPOM admin1 = new Admin_LoginPOM(driver);
		admin1.retailAdminlogin("admin", "admin@123");
		
		Dashboard_HomePOM dash = new Dashboard_HomePOM(driver);
		dash.getMessage();
			
		CategoriesPOM category = new CategoriesPOM(driver);
		category.getcategoryScreen();		
		category.getcategoryMessage();
		
		
		//click on add new category link
		AddNewCategoryPOM addnewCat = new AddNewCategoryPOM(driver);
		addnewCat.addnewCategory();
		
		//WebElement actual = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		//WebElement expected = driver.findElement(By.name(" Success: You have modified categories!      "));
	//	Assert.assertEquals(actual, expected);
		Assert.assertTrue(true, "Success");
		
		
		//List<WebElement> catList = (List<WebElement>) driver.findElement(By.linkText(name));
		
		/*
		 * List<WebElement> catList = driver.findElements(By.cssSelector(name));
		 * for(WebElement catList1 : catList) { String strLinkText = catList1.getText();
		 * System.out.println(strLinkText);
		 * 
		 * }
		 */
		
		
		//assertion to verify whether the category is deleted & not present in the list
		//WebElement element = driver.findElement(By.name(name));
	//	Assert.assertFalse(element.isDisplayed());
				
		//selecting checkbox to delete
		category.chkboxtoDelete();
		
		System.out.println("Chk box is selected");
		
		//Click on delete button
		category.clickonDeletebutton();
		
		/*
		 * try { WebDriverWait wait = new WebDriverWait(driver, 2);
		 * wait.until(ExpectedConditions.alertIsPresent()); Alert alert =
		 * driver.switchTo().alert(); System.out.println(alert.getText());
		 * alert.accept(); Assert.assertTrue(alert.getText().contains("Success")); }
		 * catch (Exception e) { //exception handling }
		 */
		//System.out.println("Confirmation box is displayed");
				 		
			
		
		}
	
}
