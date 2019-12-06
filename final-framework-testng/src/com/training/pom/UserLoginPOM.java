package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UserLoginPOM {
	
	private WebDriver driver;
	
	public UserLoginPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//mouseovertologinuser
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement login;
	
	//myOrderlink
	@FindBy(xpath="//span[contains(text(),'MY ORDERS')]")
	private WebElement myOrders;
	
	//emailidBox
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailId;
	
	//passwordBox
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	//loginBtn
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginBtn;
	
	//HomeTab
	@FindBy(xpath="//span[contains(text(),'Home')]")
	private WebElement homeTab;
	
	public void userLogin()
	{
		
		//mouseover to UserLogin
		Actions actions = new Actions(driver);
	    //WebElement ringSelect = driver.findElement(By.xpath("//*[@id=\'BestsellerProducts_Yllc2v2l\']/div/div/div/div/div[3]/div/div/div[1]/h4/a"));
		actions.moveToElement(login).perform();
		this.login.click();
		      
		this.emailId.click();
		this.emailId.sendKeys("shrivijay2006@gmail.com");
		this.password.click();
		this.password.sendKeys("Apple@2009");
		this.loginBtn.click();
		
		this.homeTab.click();
		
	}
	
	public void accountLogin()
	{
		//mouseover to UserLogin
		Actions actions = new Actions(driver);
		//WebElement ringSelect = driver.findElement(By.xpath("//*[@id=\'BestsellerProducts_Yllc2v2l\']/div/div/div/div/div[3]/div/div/div[1]/h4/a"));
		actions.moveToElement(login).perform();
		//this.login.click();
		actions.moveToElement(myOrders).perform();
		this.myOrders.click();
		
		WebElement chkStatus = driver.findElement(By.name("Complete"));
		Assert.assertEquals(true,chkStatus.isDisplayed());
		//td[contains(text(),'Complete')]
		
		
	}
	
	
}
