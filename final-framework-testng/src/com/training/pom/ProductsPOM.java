package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.trianing.waits.TestUtil;

public class ProductsPOM {
	
private WebDriver driver;
	
	public ProductsPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//productsLogo
	@FindBy(xpath="//h1[contains(text(),'Products')]")
	private WebElement productsLogo;
	
	//Catalog Link
	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement catalogLink;
	
	//statusBox
	@FindBy(xpath = "//select[@id='input-status']")
	private WebElement statusBox;
	
	//modelBox
	@FindBy(xpath = "//input[@id='input-model']")
	private WebElement modelBox;
	
	//QuantityBox
	@FindBy(xpath = "//input[@id='input-quantity']")
	private WebElement quantityBox;
	
	//ImageBox
	@FindBy(xpath = "//select[@id='input-image']")
	private WebElement imageBox;
	
	//ProductsLink
	@FindBy(xpath="//*[@id=\'menu-catalog\']/ul/li[2]/a")
	private WebElement productsLink;
	
	//ProductName
	@FindBy(xpath = "//input[@id='input-name']")
	private WebElement prodName;
	
	//PriceBox
	@FindBy(xpath = "//input[@id='input-price']")
	private WebElement priceBox;
	
	//FilterButton
	@FindBy(xpath = "//button[@id='button-filter']")
	private WebElement filterBtn;
	
	//ImageListinTable
	@FindBy(xpath = "//td[contains(text(),'Image')]")
	private WebElement imageList;
	
	//ProductNameinTable
	@FindBy(xpath = "//*[@id='form-product']/div/table/thead/tr/td[3]/a")
	private WebElement prodNameList;
	
	//ModelinTable
	@FindBy(xpath = "//a[contains(text(),'Model')]")
	private WebElement modelList; 
	
	//PriceinTable
	@FindBy(xpath = "//a[contains(text(),'Price')]")
	private WebElement priceList;
	
	//QuantityinTable
	@FindBy(xpath = "//a[contains(text(),'Quantity')]")
	private WebElement quantityList;
	
	//StatusinTable
	@FindBy(xpath = "//td[@class='text-left']//a[contains(text(),'Status')]")
	private WebElement statusList;
	
	//ActionButtoninTable
	@FindBy(xpath = "//td[contains(text(),'Action')]")
	private WebElement actionBtnList;
	
	public void getProductslink()
	{
		this.catalogLink.click();
		this.productsLink.click();
			
	}
	
	public void filterProdname()
	{
		this.prodName.sendKeys("Integer vitae");
		this.filterBtn.click();
		//System.out.println("Products displayed after the Product Name filter ");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	}
	
	public void filterPrice()
	{
		this.prodName.clear();
		this.prodName.sendKeys("Integer vitae");
		this.priceBox.sendKeys("515");
		this.filterBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	}
	
	public void filterStatus()
	{
		this.prodName.clear();
		this.priceBox.clear();
		this.prodName.sendKeys("Integer vitae");
		this.priceList.sendKeys("515");
		Select dropStatus = new Select(driver.findElement(By.name("filter_status")));
		dropStatus.selectByVisibleText("Enabled");
		this.filterBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	}
	
	public void filterModel()
	{
		this.prodName.clear();
		this.priceBox.clear();
		//this.statusBox.clear();
		//Select dropStatus = new Select(driver.findElement(By.xpath("//select[@id='input-status']//option[1]")));
		Select dropStatus = new Select(driver.findElement(By.name("filter_status")));
		dropStatus.selectByIndex(0);
		//dropStatus.getFirstSelectedOption();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		this.prodName.sendKeys("Integer vitae");
		this.modelBox.sendKeys("SMU-004");
		this.filterBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		//return;
	}
	
	public void filterQuantity()
	{
		this.prodName.clear();
		this.priceBox.clear();
		this.modelBox.clear();
		this.prodName.sendKeys("Integer vitae");
		this.quantityBox.sendKeys("49");
		this.filterBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	//	return;
	}
	
	public void filterImage()
	{
		this.prodName.clear();
		this.priceBox.clear();
		//this.statusBox.clear();
		this.modelBox.clear();
		this.quantityBox.clear();
		this.prodName.sendKeys("Integer vitae");
		Select dropStatus1 = new Select(driver.findElement(By.name("filter_image")));
		dropStatus1.selectByVisibleText("Enabled");
		this.filterBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		return;	
		
		
	}
	
	public void getproductsScreen()
	{
		//Assert.assertEquals(true, this.productsLink.isDisplayed());
		Assert.assertEquals(true, this.imageList.isDisplayed());
		Assert.assertEquals(true, this.prodNameList.isDisplayed());
		Assert.assertEquals(true, this.modelList.isDisplayed());
		Assert.assertEquals(true, this.quantityList.isDisplayed());
		Assert.assertEquals(true, this.statusList.isDisplayed());
		Assert.assertEquals(true, this.actionBtnList.isDisplayed());
		//Assert.assertEquals(true, this.filterBtn.isDisplayed());
		System.out.println("Products page displayed successfully");
		
	}
	
	
}