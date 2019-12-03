package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_LoginPOM {
	
	private static WebDriver driver;
	
	public Admin_LoginPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/*
	 * @FindBy(id="input-username") private static WebElement username;
	 * 
	 * @FindBy(id="input-password") private static WebElement password;
	 * @CacheLookup
	 * 
	 * @FindBy(xpath="//button[contains(text(),'Login'") private WebElement
	 * loginBtn;
	 */	
	 
	By username = By.id("input-username");
	By password = By.id("input-password");
	By loginid = By.xpath("//*[@id=\'content\']/div/div/div/div/div[2]/form/div[3]/button");
	
	
	public void retailAdminlogin(String userid,String pass)
	  {
		  driver.findElement(username).sendKeys(userid);
		  driver.findElement(password).sendKeys(pass);
		  driver.findElement(loginid).click();
	  }
				

}
