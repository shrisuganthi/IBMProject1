package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailMainScreenPOM {
private static WebDriver driver;
	
	public RetailMainScreenPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="site_logo") WebElement retailLogo;
	@FindBy(xpath="//img[contains(@class,'Donec suscipit')]") WebElement donecSuscipit;
	@FindBy(xpath="//img[contains(@class,' lazyloaded')]") WebElement lazyLoaded;
	
	

}
