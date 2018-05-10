package com.Pracelpoint.testing.PracelPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageObject 
{
	public PageObject(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
		
	//<<Variables>>
	//GlobalSearch
	@FindBy(xpath="//*[@id='header']/div[2]/div[1]/div[2]/div[2]/button[1]")
	private WebElement ShopandClick;
	
	@FindBy(xpath="//*[@id='collectInput']")
	private WebElement ParcelPostal;
	
	@FindBy(xpath="//*[@id='header']/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/button[1]")
	private WebElement FindParcelPostal;
	
	@FindBy(xpath="//*[@id='store-2145-02']/div[1]")
	private WebElement SelectParcelPoint;
	
	@FindBy(xpath="//*[@id='newDeliveryForm']/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")
	private WebElement ParcelPointname;
	
	
	
	@FindBy(xpath="//*[@id='delivery-online-store']")
	private WebElement Onlinestroename;
	
	@FindBy(xpath="//*[@id='delivery-online-information']")
	private WebElement Ordernumber;
	
	@FindBy(xpath="//*[@id='delivery-name-createAccount']")
	private WebElement Contactname;
	
	@FindBy(xpath="//*[@id='delivery-email-createAccount']")
	private WebElement Contactemail;
	
	@FindBy(xpath="//*[@id='delivery-mobile-createAccount']")
	private WebElement ContactMobile;
	
	@FindBy(xpath="//*[@id='customerName']")
	private WebElement PaymentName;
	
	@FindBy(xpath="//*[@id='creditCard']")
	private WebElement PaymentCreditcardNumber;
	
	@FindBy(xpath="//*[@id='expirationMonth']")
	private WebElement PaymentDateMonth;
	
	@FindBy(xpath="//*[@id='expirationYear']")
	private WebElement PaymentDateYear;
	
	@FindBy(xpath="//*[@id='cvv']")
	private WebElement PaymentCVV;
	
	@FindBy(xpath="//*[@id='newDeliveryForm']/div[12]/div[1]/button[1]")
	private WebElement RegisterNewPracel;
	
	//SearchButton
	@FindBy(id="gh-btn")
	private WebElement SearchButton;
		
	
		
	//<<Methods>>
	
	//GlobalSearch	
	public WebElement ShopandClick()
	{
	   return this.ShopandClick;
	}
	
	public WebElement ParcelPostal()
	{
		return this.ParcelPostal;
	}
	public WebElement FindParcelPostal()
	{
		return this.FindParcelPostal;
	}
	public WebElement SelectParcelPoint()
	{
		return this.SelectParcelPoint;
	}
	public WebElement RegisterNewPracel()
	{
		return this.RegisterNewPracel;
	}
	
	
	public WebElement Onlinestroename()
	{
		return this.Onlinestroename;
	}
	public WebElement Ordernumber()
	{
		return this.Ordernumber;
	}
	public WebElement Contactname()
	{
		return this.Contactname;
	}
	public WebElement Contactemail()
	{
		return this.Contactemail;
	}
	public WebElement ContactMobile()
	{
		return this.ContactMobile;
	}
	public WebElement PaymentName()
	{
		return this.PaymentName;
	}
	public WebElement PaymentCreditcardNumber()
	{
		return this.PaymentCreditcardNumber;
	}
	public WebElement PaymentDateMonth()
	{
		return this.PaymentDateMonth;
	}
	public WebElement PaymentDateYear()
	{
		return this.PaymentDateYear;
	}
	public WebElement PaymentCVV()
	{
		return this.PaymentCVV;
	}
	public WebElement ParcelPointname()
	{
		return this.ParcelPointname;
	}

	
	
		
}