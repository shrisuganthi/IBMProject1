package com.training.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.trianing.waits.TestUtil;

public class CategoriesPOM {

private WebDriver driver;
	
	public CategoriesPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\'menu-catalog\']/ul/li[1]/a")
	private WebElement categories;
	
	
	public void getcategoryScreen()
	{
		//WebElement element= driver.findElement(By.cssSelector("#menu-catalog > a > i"));
		WebElement element= driver.findElement(By.xpath("//i[@class='fa fa-tags fw']"));
		element.click();
		WebElement element1= driver.findElement(By.xpath("//a[contains(text(),'Categories')]"));
		//*[@id=\'menu-catalog\']/ul/li[1]/a
		element1.click();
		
	}
		
	public void getcategoryMessage()
	{
		WebElement categorybutton = driver.findElement(By.xpath("//h3[@class='panel-title']"));
		WebElement categoryList = driver.findElement(By.xpath("//h3[@class='panel-title']"));
		WebElement categoryName = driver.findElement(By.xpath("//*[@id=\"form-category\"]/div/table/thead/tr/td[2]/a"));
		WebElement sortOrder = driver.findElement(By.xpath("//*[@id=\"form-category\"]/div/table/thead/tr/td[3]/a"));
		//WebElement action1 = driver.findElement(By.cssSelector("#form-category > div > table > thead > tr > td:nth-child(4)"));
		WebElement action1 = driver.findElement(By.xpath("//td[contains(text(),'Action')]"));
		
		Assert.assertEquals(true, categorybutton.isDisplayed());
		//System.out.println("Categories page displayed successfully");
		
		Assert.assertEquals(true, categoryList.isDisplayed());
	//	System.out.println("CategoriesList displayed successfully");
		
		Assert.assertEquals(true, categoryName.isDisplayed());
		//System.out.println("CategoriesName displayed successfully");
		
		Assert.assertEquals(true, sortOrder.isDisplayed());
	//	System.out.println("Sort Order is displayed successfully");
		
		Assert.assertEquals(true, action1.isDisplayed());
		//System.out.println("Action button is displayed successfully");
		System.out.println("Categories page displayed successfully");
		
	}
	
	public void chkboxtoDelete()
	{
			
		//WebElement chkBox = driver.findElement(By.name("selected[]"));
		
		  WebElement chkBox = driver.findElement(By.xpath("//*[@id=\'form-category\']/div/table/tbody/tr[2]/td[1]/input"));
		  chkBox.click();
		
		 // new Select(driver.findElement(By.id("INDIAN"))).selectByVisibleText("SHRI");
		
		/*
		 * List<WebElement> chkbox = driver.findElements(By.name("ADD")); for(int
		 * i=0;i<chkbox.size();i++) { WebElement ele = chkbox.get(i); String id =
		 * ele.getAttribute("AD");
		 * 
		 * if(id.contentEquals("ADD")) { ele.click(); break; } }
		 */
		 
	}
	
	public void clickonDeletebutton()
	{
		//scroll down to select the second page list
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  	//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		//Instantiate Action Class        
	      Actions actions = new Actions(driver);
	      WebElement selectfromList = driver.findElement(By.xpath("//*[@id=\'content\']/div[2]/div[2]/div[2]/div/div[1]/ul/li[2]/a"));
	      actions.moveToElement(selectfromList).perform();
	      selectfromList.click();
	    		
		//selecting the product SHRI
		//WebElement selectProd = driver.findElement(By.className("//img[contains(@class,'SHRI')]"));
	      js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		String selectProd = driver.findElement(By.xpath("//*[@id='form-category']/div/table/tbody/tr[23]/td[2]")).getText();
		selectProd.startsWith("SH");
		
		
		//Click on delete button
		WebElement delete = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		System.out.println("Delete button is clicked");
		delete.click();
	}
	
	public void clickonConfirmdelete()
	{
		//confirm by clicking on ok button
		
		WebElement delete = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		
		//*[@id="content"]/div[1]/div/div/button
		Assert.assertEquals(true, delete.isDisplayed());
		
		System.out.println("Delete button is clicked");
		delete.click();
	}
	
	
}
