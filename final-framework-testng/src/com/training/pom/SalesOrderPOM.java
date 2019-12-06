package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SalesOrderPOM {

private WebDriver driver;
	
	public SalesOrderPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//SalesMenuLink  -  //span[contains(text(),'Sales')]
	@FindBy(xpath="//*[@id=\"menu-sale\"]/a")
	private WebElement salesLink;
	
	
	//OrdersLink - //ul[@class='collapse in']//a[contains(text(),'Orders')]   //*[@id="menu-sale"]/ul/li[1]/a
	@FindBy(xpath="//*[@id=\"menu-sale\"]/ul/li[1]/a")
	private WebElement ordersLink;
	
	//OrderListPanelHeading
	@FindBy(xpath="//div[@class='panel-heading']")
	private WebElement orderTitle;
	
	//#content > div.container-fluid > div > div.panel-body > div.well
	//OrderId,status,date,total panel
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/div[2]/div[1]")
	private WebElement panelBody;
	
	//FilterwithCustomerName
	@FindBy(id="input-customer")
	private WebElement inpCustomerName;
	
	//SalesOrderStatusdropdown
	@FindBy(id="input-order-status")
	private WebElement orderStatus;
	
	//FilterButton
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filterBtn;
	
	//ViewButton
	@FindBy(xpath="//*[@id=\"form-order\"]/div/table/tbody/tr[1]/td[8]/a[1]")
	private WebElement viewOrder;
	
	
	public void salesOrderviewandConfirm()
	{
		this.salesLink.click();
		
		this.ordersLink.click();
		Assert.assertEquals(true,this.orderTitle.isDisplayed());
		Assert.assertEquals(true,this.panelBody.isDisplayed());
		Select dropStatus = new Select(driver.findElement(By.id("input-order-status")));
		dropStatus.selectByVisibleText("Pending");
		this.inpCustomerName.click();
		this.inpCustomerName.sendKeys("shri suganthi");
		this.filterBtn.click();
		this.viewOrder.click();
		
	}
	
	
}
