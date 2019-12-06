package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_LoginPOM {

	private static WebDriver driver;

	public Admin_LoginPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

 
		//By username = By.id("input-username");
		//By password = By.id("input-password");
		//By loginid = By.xpath("//*[@id=\'content\']/div/div/div/div/div[2]/form/div[3]/button");
		
		@FindBy(id="input-username")
		private WebElement username;
		
		@FindBy(id="input-password")
		private WebElement password;
		
		@FindBy(xpath="//*[@id=\'content\']/div/div/div/div/div[2]/form/div[3]/button")
		private WebElement loginid;

				
		public void retailAdminlogin(String username,String password)
		  {
			 		
			this.username.clear();
			this.username.sendKeys(username);
			this.password.clear();
			this.password.sendKeys(password);
			
		  }
	
		public void adminLoginBtn()
		{
			this.loginid.click();
		}
	
	
}
