package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CategoriesPOM {

private WebDriver driver;
	
	public CategoriesPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[1]/a")
	private WebElement categories;
	
	public void getcategoryMessage()
	{
		WebElement categorybutton = driver.findElement(By.cssSelector("#content > div.page-header > div > h1"));
		WebElement categoryList = driver.findElement(By.cssSelector("#content > div.container-fluid > div > div.panel-heading > h3"));
		WebElement categoryName = driver.findElement(By.xpath("//*[@id=\"form-category\"]/div/table/thead/tr/td[2]/a"));
		WebElement sortOrder = driver.findElement(By.xpath("//*[@id=\"form-category\"]/div/table/thead/tr/td[3]/a"));
		WebElement action1 = driver.findElement(By.cssSelector("#form-category > div > table > thead > tr > td:nth-child(4)"));
		
		Assert.assertEquals(true, categorybutton.isDisplayed());
		System.out.println("Categories page displayed successfully");
		
		Assert.assertEquals(true, categoryList.isDisplayed());
		System.out.println("CategoriesList displayed successfully");
		
		Assert.assertEquals(true, categoryName.isDisplayed());
		System.out.println("CategoriesName displayed successfully");
		
		Assert.assertEquals(true, sortOrder.isDisplayed());
		System.out.println("Sort Order is displayed successfully");
		
		Assert.assertEquals(true, action1.isDisplayed());
		System.out.println("Action button is displayed successfully");
		
		
	}
		
}
