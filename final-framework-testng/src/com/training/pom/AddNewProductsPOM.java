package com.training.pom;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.trianing.waits.TestUtil;

public class AddNewProductsPOM {

	private static WebDriver driver;
	
	public AddNewProductsPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Add (+) button
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addnewProductlink;
	
	//AddProductsImage
	@FindBy(xpath="//h3[@class='panel-title']")
	private WebElement addProdImage;
	
	//DataTab
	//String dataTab = driver.findElement(By.linkText("tab")).findElement(By.xpath("//a[contains(text(),'Data')]")).getAttribute("Data");
	//DataTabLink
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement dataTab;
	
	//LinksTab
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement linksTab;
	
	//LinksTab
	//@FindBy(xpath="//a[contains(text(),'Links')]")
	//@FindBy(css="#form-product > ul > li.active > a")
	//@FindBy(xpath = "//*[@id=\'form-product\']/ul/li[3]/a")
	//private WebElement linksTab;
	
	//AttributeTab
	//@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Attribute')]")
	//private WebElement attribTab;
	
	//OptionTab
	//@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Option')]")
	//private WebElement optionTab;
	
	//RecurringTab
	//@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Recurring')]")
	//private WebElement recurTab;

	//DiscountTab
	
	  @FindBy(xpath="//a[contains(text(),'Discount')]") 
	  private WebElement discountTab;
	  
	  @FindBy(xpath="//table[@id='discount']//i[@class='fa fa-plus-circle']")
	  private WebElement discountAdd;
	  
	  @FindBy(xpath="//td[@class='text-right']//input[@placeholder='Quantity']")
	  private WebElement disquantity;
	  
	  @FindBy(xpath="//td[@class='text-right']//input[@placeholder='Price']")
	  private WebElement disPrice;
	  
	  @FindBy(xpath="//*[@id=\"discount-row0\"]/td[5]/div/span/button/i")
	  private WebElement disStartDate;
	  
	  @FindBy(xpath="//*[@id=\"discount-row0\"]/td[6]/div/span/button/i")
	  private WebElement disEndDate;
	  
	  
	  
	  
	  
	  //SpecialTab
	  
	  @FindBy(xpath="//a[contains(text(),'Special')]") private WebElement
	  specialTab;
	  
	  //ImageTab
	  
	  @FindBy(xpath="//a[contains(text(),'Image')]") private WebElement imageTab;
	  
	  //RewardPointstab
	  
	  @FindBy(
	  xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Reward Points')]")
	  private WebElement rewardTab;
	  
	  //Designtab
	  
	  @FindBy(xpath="//a[contains(text(),'Design')]") private WebElement designTab;
	 
	//MandatoryFields
	//ProductNameField
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement prodName;
	
	//MetaTagFileName
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement metaTag;
	
	//ModelTextBox
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement modelBox;
	
	//PriceBox
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement priceBox;
	
	//QuantityBox
	@FindBy(xpath = "//input[@id='input-quantity']")
	private WebElement quantityBox;
	
	//CategoriesBox
	@FindBy(xpath="//input[@id='input-category']")
	private WebElement categoryBox;
	
	//saveButton
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement saveBtn;
	
	//alertSuccessMessage
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successMsg;
	
	
	public void assertAddProduct()
	{
		Assert.assertEquals(true, this.addProdImage.isDisplayed());
		//Assert.assertEquals(true, this.dataTab.isDisplayed());
		//Assert.assertEquals(true, this.linksTab.isDisplayed());
		//Assert.assertEquals(true, this.attribTab.isDisplayed());
		//Assert.assertEquals(true, this.optionTab.isDisplayed());
		//Assert.assertEquals(true, this.recurTab.isDisplayed());
		//Assert.assertEquals(true, this.discountTab.isDisplayed());
		//Assert.assertEquals(true, this.specialTab.isDisplayed());
		//Assert.assertEquals(true, this.imageTab.isDisplayed());
		//Assert.assertEquals(true, this.rewardTab.isDisplayed());
		//Assert.assertEquals(true, this.designTab.isDisplayed());
		System.out.println("Add New Products Page displayed");
	}
	
	
	public void addnewProducts()
	{
		this.addnewProductlink.click();
		this.prodName.sendKeys("Finger Ring");
		this.metaTag.sendKeys("Finger Ring for Ladies");
		WebElement dataTab = driver.findElement(By.xpath("//a[contains(text(),'Data')]"));
		dataTab.click();
		WebElement linksTab = driver.findElement(By.xpath("//a[contains(text(),'Links')]"));
		WebElement attribTab = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(),'Attribute')]"));
		WebElement optionTab = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(),'Option')]"));
		WebElement recurTab = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(),'Recurring')]"));
		WebElement discountTab = driver.findElement(By.xpath("//a[contains(text(),'Discount')]"));
		WebElement specialTab = driver.findElement(By.xpath("//a[contains(text(),'Special')]"));
		WebElement imageTab = driver.findElement(By.xpath("//a[contains(text(),'Image')]"));
		WebElement rewardTab = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(),'Reward Points')]"));
		WebElement designTab = driver.findElement(By.xpath("//a[contains(text(),'Design')]"));
		this.modelBox.sendKeys("SKU-012");
		this.priceBox.sendKeys("500");
		this.quantityBox.sendKeys("50");
		linksTab.click();
		
		this.categoryBox.click();
		//input[@id='input-category']
		this.categoryBox.sendKeys("INDIAN");
		this.categoryBox.getText();
		
		//Select dropStatus = new Select(driver.findElement(By.xpath("//a[contains(text(),'INDIAN')]")));
        //dropStatus.selectByVisibleText("INDIAN");
        		
		attribTab.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		optionTab.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		recurTab.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		discountTab.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		specialTab.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		imageTab.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		rewardTab.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		designTab.click();
		
		this.saveBtn.click();
		
		Assert.assertEquals(true, this.successMsg.isDisplayed());
		System.out.println("Successfully Added the Product");
	}
	
	
	public void addNewProdLinktoclick()
	{
		this.addnewProductlink.click();
	}
	
	
	
	public void generalTabentry(String prodName,String metaTag)
	{
		this.prodName.clear();
		this.prodName.sendKeys(prodName);
		this.metaTag.clear();
		this.metaTag.sendKeys(metaTag);
	}
	
	public void dataTabentryclick()
	{
		this.dataTab.click();
	}
	
	public void dataTabentry(String modelBox,String priceBox,String quantityBox)
	{
		this.modelBox.clear();
		this.modelBox.sendKeys(modelBox);
		this.priceBox.clear();
		this.priceBox.sendKeys(priceBox);
		this.quantityBox.clear();
		this.quantityBox.sendKeys(quantityBox);
	}
	
	public void linksTabentryClick()
	{
		this.linksTab.click();
	}
	
	public void linksTabentry(String categoryBox)
	{
		this.categoryBox.clear();
		this.categoryBox.sendKeys(categoryBox);
	}
	
	public void clickSave()
	{
		this.saveBtn.click();	
	}
	
	public void discountTabclick()
	{
		this.discountTab.click();
	}
	
	public void discountAddlink()
	{
		this.discountAdd.click();
	}
	
	public void discountAddDetails(String disquantity,String disPrice)
	{
		this.disquantity.click();
		this.disquantity.sendKeys(disquantity);
		this.disPrice.click();
		this.disPrice.sendKeys(disPrice);
	}
	
	public void disStartDate(String disStartDate)
	{ 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		this.disStartDate.sendKeys(dtf.format(localDate));
	}
	
	public void disEndDate(String disEndDate)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(dt);
		cl.add(Calendar.DAY_OF_YEAR,1);
		dt=cl.getTime();
		String str = df.format(dt);
		this.disEndDate.sendKeys(str);
				
	}
	
	public void rewardTabClick()
	{
		this.rewardTab.click();
	}


	
	
	
}
