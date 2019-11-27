package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_HomePOM {

private WebDriver driver;
	
	public Dashboard_HomePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="http://retailm1.upskills.in/admin/index.php?route=common/dashboard&token=dRKboduI7Khg0U6tTelw53W08HgTOLz7")
	private WebElement dashhome;
	
	
	
}
