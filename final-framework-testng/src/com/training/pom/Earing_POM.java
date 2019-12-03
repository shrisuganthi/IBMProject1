package com.training.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Earing_POM {

	private WebDriver driver;


	public Earing_POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#product_images > div.tb_slides.horizontal.mightySlider > span > img")private WebElement product;
	
	
	public void viewProduct()
	{
		System.out.println("Selected Product page displayed successfully");
	}

	
	
}
