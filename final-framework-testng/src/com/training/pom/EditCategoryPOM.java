package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditCategoryPOM {

	private WebDriver driver;

	public EditCategoryPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id=\'content\']/div[1]/div/h1")
	private WebElement editCategoriespage;
	
	public void geteditcategoryPage()
	{
		WebElement editcatTitle = driver.findElement(By.xpath("//h3[@class='panel-title']"));
		WebElement generalTab = driver.findElement(By.xpath("//a[contains(text(),'General')]"));
		
		WebElement dataTab = driver.findElement(By.xpath("//a[contains(text(),'Data')]"));
		WebElement designTab = driver.findElement(By.xpath("//a[contains(text(),'Design')]"));
		
		Assert.assertEquals(true, editcatTitle.isDisplayed());
		System.out.println("Edit Categories page displayed successfully");
	}
	
	public void clickoneditBtn()
	{
		WebElement editButton= driver.findElement(By.xpath("//*[@id='form-category']/div/table/tbody/tr[3]/td[4]/a"));
		editButton.click();
		System.out.println("Edit button is clicked");
	}
	
		
}
