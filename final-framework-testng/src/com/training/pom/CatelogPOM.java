package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatelogPOM {
private static WebDriver driver;
	
	public CatelogPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/a")
	private WebElement catelog;
	
	@FindBy(xpath="//ul[@class='collapse in']//a[contains(text(),'Products')]")
	private WebElement products;
	
	
	public void clickonCatelog()
	{
		this.catelog.click();
	}

	public void selectProductslink()
	{
		Actions actions = new Actions(driver);
		      WebElement prodSelect = driver.findElement(By.xpath("//*[@id=\"menu-catalog\"]/ul/li[2]/a"));
		      actions.moveToElement(prodSelect).perform();
		      prodSelect.click();
		
	}
	
}
