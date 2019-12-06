package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckoutPOM {

	private WebDriver driver;
	
	public CheckoutPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * @FindBy(css = "#System_V2Exp1o9 > div.tb_text_wrap.tb_sep > p") private
	 * WebElement product;
	 */
	
	//CheckoutButton
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement chkOutBtn;
	
	//GuestLoginRadioButton
	@FindBy(xpath="//div[@id='collapse-checkout-option']//div[2]//label[1]//input[1]")
	private WebElement guestLoginbtn;
	
	//Radio-existingAddress
	@FindBy(id="payment-existing")
	private WebElement existingAddress;
	
	//RadioButtonforBillingDetails
	@FindBy(xpath="//*[@id=\"collapse-payment-address\"]/div/div[3]/label/input")
	private WebElement radioBtn;
	
	//Step1-continueBtn
	@FindBy(id="button-account")
	private WebElement logincontiBtn;
	
	//Step2-BillingDtls-FirstName
	@FindBy(id="input-payment-firstname")
	private WebElement firstName;
	
	//Step2-BillingDtls-LastName
	@FindBy(id="input-payment-lastname")
	private WebElement LastName;
	
	//Step2-BillingDtls-Email
	@FindBy(id="input-payment-email")
	private WebElement email;
	
	//Step2-BillingDtls-Telephone
	@FindBy(id="input-payment-telephone")
	private WebElement telePhone;
	
	//Step2-BillingDtls-Address1
	@FindBy(id="input-payment-address-1")
	private WebElement address1;
	
	//Step2-BillingDtls-city
	@FindBy(id="input-payment-city")
	private WebElement city;
	
	//Step2-BillingDtls-postcode
	@FindBy(id="input-payment-postcode")
	private WebElement postCode;
	
	//Step2-BillingDtls-country
	@FindBy(id="input-payment-country")
	private WebElement country;
	
	//Step2-BillingDtls-RegionState
	@FindBy(id="input-payment-zone")
	private WebElement region;
	
	//Step2-BillingDts-ContinueBtn
	@FindBy(xpath="//input[@id='button-payment-address']")
	private WebElement billContinue;
	
	//Step3-DeliveryDts-radioBtn
	@FindBy(xpath="//input[@value='existing']")
	private WebElement shipAddress;
	
	//Step3-DeliveryDts-Continue
	@FindBy(xpath = "//input[@id='button-shipping-address']")
	private WebElement shipdtsContinue;
	
	//Step4-DeliveryMethod
	@FindBy(name="shipping_method")
	private WebElement shipMethod;
	
	//Step4-DeliveryMethod
	@FindBy(xpath="//textarea[@name='comment']")
	private WebElement commentArea;
	
	//Step4-DeliveryMethodContinue
	@FindBy(xpath="//input[@id='button-shipping-method']")
	private WebElement shipContinue;
	
	//Step5-paymentMethod
	@FindBy(name="payment_method")
	private WebElement paybyCashRadio;
	
	//Step5-PaymentMethod-Termscheckbox
	@FindBy(name="agree")
	private WebElement termsChkbox;
	
	//Step5-PaymentMethodContinue
	@FindBy(xpath="//input[@id='button-payment-method']")
	private WebElement paymetodContinue;
	
	//Step6-ConfirmOrder
	//@FindBy(xpath="//input[@id='button-confirm']")
	@FindBy(id="button-confirm")
	private WebElement confirmBtn;
	
	//ConfirmationMesg
	@FindBy(xpath="//section[@id='content']")
	private WebElement confirMsg;
	
	//ConfirmMsgContinue
	//@FindBy(xpath="//a[@class='btn btn-primary']")
	//private WebElement confirContinue;
	
	//Trimmer
	//*[@id="BestsellerProducts_Yllc2v2l"]/div/div/div/div/div[3]/div/div/div[1]/h4/a
	
	/*
	 * public void viewProduct() { WebElement chek = driver.findElement(By.
	 * cssSelector("#System_V2Exp1o9 > div.tb_text_wrap.tb_sep > p"));
	 * Assert.assertEquals(true, chek.isDisplayed());
	 * System.out.println("Your shopping cart is empty!");
	 * 
	 * }
	 */
	
	
	public void clickOnchkoutBtn()	{
		this.chkOutBtn.click();
		//this.radioBtn.click();
		//this.radioBtn.isSelected();
		this.existingAddress.isSelected();
		//this.firstName.click();
		//this.firstName.sendKeys("shri");
		//this.LastName.click();
		//this.LastName.sendKeys("suganthi");
		//this.address1.click();
		//this.address1.sendKeys("BTM");
		//this.city.click();
		//this.city.sendKeys("Bangalore");
		//Select dropStatus = new Select(driver.findElement(By.id("input-payment-country")));
//		dropStatus.selectByIndex(99);
		//dropStatus.selectByVisibleText("India");
		//Select dropStatusRegion = new Select(driver.findElement(By.id("input-payment-zone")));
		//dropStatusRegion.selectByValue(1489);
		//dropStatusRegion.selectByVisibleText("Karnataka");
		
		this.billContinue.click();
		this.shipAddress.click();
		this.shipdtsContinue.click();
		this.shipMethod.isSelected();
		this.commentArea.sendKeys("This product is nice!");
		this.shipContinue.click();
		
		this.paybyCashRadio.isSelected();
		this.termsChkbox.click();
		this.paymetodContinue.click();
		
		this.confirmBtn.click();
		this.confirMsg.isDisplayed();	
		//this.confirContinue.click();
		
		
	}
	
	
	
	
}
