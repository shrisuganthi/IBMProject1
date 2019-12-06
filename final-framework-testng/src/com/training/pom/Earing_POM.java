package com.training.pom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.trianing.waits.TestUtil;

public class Earing_POM {

	private WebDriver driver;


	public Earing_POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//ProductImage
	/*
	 * @FindBy(xpath=
	 * "//*[@id=\"BestsellerProducts_Yllc2v2l\"]/div/div/div/div/div[3]/div/div/div[1]/h4/a")
	 * private WebElement product;
	 */
		
	//notifyalertBox
	@FindBy(xpath="//ul[@class='noty_cont noty_layout_topRight']")
	private WebElement alertMsg;
	
	//mouseovertoEcommerceBag
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement mouseoverCart;
	
	//EcommerceBagViewCartLink
	@FindBy(xpath="//a[contains(text(),'View Cart')]")
	private WebElement viewCartBtn;
	
	//EcommerceBagCheckOutBt
	@FindBy(xpath="//a[contains(text(),'Checkout')]")
	private WebElement chkoutBtn;
	
	
	public void viewProduct()
	{
	//	this.product.isDisplayed();
		System.out.println("Selected Product page displayed successfully");
	}
	
	public void closeNotifymsg()
	{
		/*
		 * Actions actions = new Actions(driver); WebElement closePopup =
		 * driver.findElement(By.id("close")); //body[@class='product-product-843
		 * tb_width_1200 tb_lang_ltr tb_page_product_product
		 * head_glob_intro_glob_cont_glob_foot_glob_ar_head_glob_ar_intro_sys_prod_prod__def_ar_cont_prod_glob_ar_col_l_glob_ar_foot_glob_en
		 * -gb_fe9fd no_touch']/ul[@class='noty_cont
		 * noty_layout_topRight']/li/div[@id='noty_alert_1575443111588']/div[@class='
		 * noty_message']/div[@class='noty_close btn btn-default btn-sm
		 * tb_no_text']/*[1] ///div[@class='noty_close btn btn-default btn-sm
		 * tb_no_text' actions.moveToElement(closePopup).perform(); closePopup.click();
		 */
		this.alertMsg.getText();
		
	}
	
	public void mouseovertCartImage()
	{
		Assert.assertEquals(true, this.mouseoverCart.isDisplayed());
		Actions actions = new Actions(driver);
		WebElement ecomBag = driver.findElement(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']"));
		actions.moveToElement(ecomBag).perform(); 
		System.out.println("Mouse Over to the Ecommerce Bag");
		
		
	}
	
	
	
	
}
