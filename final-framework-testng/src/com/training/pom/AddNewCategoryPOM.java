package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCategoryPOM {

private static WebDriver driver;
	
	public AddNewCategoryPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Add (+) button
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement editCategoriespage;
	
	//CategoryName Field
	@FindBy(id = "input-name1")
	private WebElement addcatName;
	
	//Meta Tag Title field
	@FindBy(xpath = "//input[@id='input-meta-title1']")
	private WebElement metaTagtitle;

	//Data Tab
	@FindBy(xpath = "//a[contains(text(),'Data')]")
	private WebElement dataTab;
	
	@FindBy(xpath = "//input[@id='input-parent']")
	private WebElement parentName;
	
	//Design Tab
	@FindBy(xpath = "//a[contains(text(),'Design')]")
	private WebElement designTab;
	
	//SaveButton
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement saveCategory;
	

	public void addnewCategory()
	{
		this.editCategoriespage.click();
		this.addcatName.sendKeys("SHRI");
		this.metaTagtitle.sendKeys("MANIPAL");
		this.dataTab.click();
		this.parentName.sendKeys("PROJECT");
		this.designTab.click();
		this.saveCategory.click();
		
	}
	
	
	/*
	 * public void addnewCategoryName() { this.addcatName.sendKeys("SHRI");
	 * this.metaTagtitle.sendKeys("MANIPAL"); this.dataTab.click();
	 * this.parentName.sendKeys("PROJECT"); this.designTab.click();
	 * this.saveCategory.click();
	 * 
	 * }
	 */
	/*
	 * public void addmetatagName(String metaTagtitle) {
	 * this.metaTagtitle.sendKeys(metaTagtitle); }
	 */
	
	/*
	 * public void dataTabentry() { this.dataTab.click();
	 * this.parentName.sendKeys(); }
	 * 
	 * public void getdesignTab() { this.designTab.click(); }
	 * 
	 * public void saveNewcategory() { this.saveCategory.click(); }
	 */}
