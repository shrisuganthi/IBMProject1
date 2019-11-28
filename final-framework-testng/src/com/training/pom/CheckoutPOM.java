package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPOM {

	private WebDriver driver;
	
	public CheckoutPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#System_V2Exp1o9 > div.tb_text_wrap.tb_sep > p")private WebElement product;
	
	
	public void viewProduct()
	{
		WebElement chek = driver.findElement(By.cssSelector("#System_V2Exp1o9 > div.tb_text_wrap.tb_sep > p"));
		Assert.assertEquals(true, chek.isDisplayed());
		System.out.println("Your shopping cart is empty!");
			
				
	}
}
