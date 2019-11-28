package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCartPOM {

	private WebDriver driver;
	
	public ViewCartPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\'content\']")private WebElement viewcart;
	
	
	public void getMessage()
	  {
		WebElement dashScreen = driver.findElement(By.cssSelector("#content > div.page-header > div > h1"));
		System.out.println("Admin Logged in and Dashboard Screen displayed successfully");  
	  }
}
