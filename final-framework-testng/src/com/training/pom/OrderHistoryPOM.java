package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OrderHistoryPOM {
	
	private static WebDriver driver;
	

	public OrderHistoryPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//addIPbutton-warning mesgs to be clicked
	@FindBy(xpath="//button[@id='button-ip-add']")
	private WebElement addIpBtn;
	
	//orderstatusdropdown
	@FindBy(id="input-order-status")
	private WebElement orderStatus;
	
	//addHistoryBtn
	@FindBy(xpath="//button[@id='button-history']")
	private WebElement addHistorBtn;
	
	//WarningmsgAlert
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement warningMsg;
	
	//confirmMesg
	@FindBy(xpath="//button[contains(text(),'×')]")
	private WebElement successMsg;

	
	
	public void orderHistoryPage()
	{
		/*if(this.addIpBtn.isDisplayed())
		{
			this.addIpBtn.click();	
		}
		else
		{*/
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//this.orderStatus.click();
		
		//this.addHistorBtn.click();
		//Assert.assertEquals(true,this.warningMsg.isDisplayed());
		//System.out.println(" Warning: You do not have permission to access the API! displayed");
		//selectingdropdown
		Select dropStatus = new Select(driver.findElement(By.id("input-order-status")));
		dropStatus.selectByVisibleText("Complete");
		//addHistory
		this.addHistorBtn.click();
			
		this.successMsg.isDisplayed();
		Assert.assertEquals(true,this.successMsg.isDisplayed());
		System.out.println(" Success: You have modified orders!");
    	
	}
		
}
