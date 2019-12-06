package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Dashboard_HomePOM {

private WebDriver driver;
	
	public Dashboard_HomePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
	private WebElement dashhome;
	
	
	public void getMessage()
	  {
		//WebElement dashScreen = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]"));
		//WebElement dashScreen = driver.findElement(By.cssSelector("#content > div.page-header > div > h1"));
		Assert.assertEquals(true, this.dashhome.isDisplayed());
		System.out.println("Admin Logged in and Dashboard Screen displayed successfully");  
	  }
	
	  
				 
				
	
}
