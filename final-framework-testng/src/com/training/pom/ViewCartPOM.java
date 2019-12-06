package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ViewCartPOM {

	private WebDriver driver;
	
	public ViewCartPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//*[@id=\'content\']")private WebElement viewcart;
	/*
	 * @FindBy(xpath
	 * ="//div[@class='cart-info tb_min_w_500']//a[contains(text(),'Lorem ipsum dolor sit amet')]"
	 * ) private WebElement viewcart;
	 */
	@FindBy(xpath="//a[contains(text(),'View Cart')]")
	private WebElement viewcartBtn;
	
		
	public void getMessage()
	  {
		WebElement dashScreen = driver.findElement(By.cssSelector("#content > div.page-header > div > h1"));
		System.out.println("Admin Logged in and Dashboard Screen displayed successfully");  
	  }
	
	
	/*
	 * public void clickonviewCartBtn() { this.viewcartBtn.click(); }
	 */
	 
	
	public void viewCart()
	{
		WebElement viewcartscreen = driver.findElement(By.xpath("//td[contains(text(),'Product Name')]"));
		//WebElement viewCartImag = driver.findElement(By.xpath("//td[contains(text(),'Image')]"));
		WebElement prodName = driver.findElement(By.xpath("//td[contains(text(),'Product Name')]"));
		WebElement  model = driver.findElement(By.xpath("//td[contains(text(),'Model')]"));
		WebElement prodQuantity = driver.findElement(By.xpath("//td[contains(text(),'Quantity')]"));
		WebElement unitPrice = driver.findElement(By.xpath("//td[contains(text(),'Unit Price')]"));
		WebElement totalPrice = driver.findElement(By.xpath("//td[contains(text(),'Unit Price')]"));
		
		
		//Assert.assertEquals(true, viewCartImag.isDisplayed());
		Assert.assertEquals(true, prodName.isDisplayed());
		Assert.assertEquals(true, model.isDisplayed());
		Assert.assertEquals(true, prodQuantity.isDisplayed());
		Assert.assertEquals(true, unitPrice.isDisplayed());
		Assert.assertEquals(true, totalPrice.isDisplayed());
		System.out.println("View Cart page displayed successfully");
		}
	
	
	
}
