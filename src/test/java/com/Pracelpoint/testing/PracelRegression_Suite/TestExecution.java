package com.Pracelpoint.testing.PracelRegression_Suite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Pracelpoint.testing.PracelLibrary.Implementation;
import com.Pracelpoint.testing.PracelLibrary.Reusable;
import com.Pracelpoint.testing.PracelLibrary.SuperTestNG;
import com.Pracelpoint.testing.PracelPageObject.PageObject;

public class TestExecution extends com.Pracelpoint.testing.PracelLibrary.SuperTestNG
{
	@SuppressWarnings("static-access")
	@Test
	public void PracelpointLaunch_Verify() throws Exception
	{	
		
		Reporter.log("==========#ebay Test Case========");
		//Step 01 - Launch Browser & Open Test Client   
		SuperTestNG.OpenUrl(driver,Reusable.getproperty("PracelpointUrl"));
				
		//Step 02 - Search Text - Sony Tv
		Reusable reuse = new Reusable();
		PageObject pageobject = new PageObject(driver);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);		
		Implementation.ClickObject(driver, pageobject.ShopandClick());		
		Implementation.AddText(driver, pageobject.ParcelPostal(), Reusable.getproperty("Postalcode"));
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		Implementation.ClickObject(driver, pageobject.FindParcelPostal());
		Implementation.ClickObject(driver, pageobject.SelectParcelPoint());
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		//System.out.println("Text "+pageobject.SelectParcelPoint().getText());
		reuse.VerifyActualTextExpected(pageobject.SelectParcelPoint(), pageobject.ParcelPointname(), driver);
		
		Implementation.AddText(driver, pageobject.Onlinestroename(), Reusable.getproperty("OnlineStore"));
		Implementation.AddText(driver, pageobject.Ordernumber(), Reusable.getproperty("OrderNumber"));
		Implementation.AddText(driver, pageobject.Contactname(), Reusable.getproperty("ContactName"));
		Implementation.AddText(driver, pageobject.Contactemail(), Reusable.getproperty("Email"));
		Implementation.AddText(driver, pageobject.ContactMobile(), Reusable.getproperty("Mobile"));
		Implementation.AddText(driver, pageobject.PaymentName(), Reusable.getproperty("PayName"));
		Implementation.AddText(driver, pageobject.PaymentCreditcardNumber(), Reusable.getproperty("CCNum")); 
		Implementation.SelectValue(driver, pageobject.PaymentDateMonth(), Reusable.getproperty("ExpMonth"));
	System.out.println("Date "+pageobject.PaymentDateMonth().getText()+"Hello");
		Implementation.SelectValue(driver, pageobject.PaymentDateYear(), Reusable.getproperty("Expyear"));
		//Implementation.AddText(driver, pageobject.PaymentDateMonth(), Reusable.getproperty("ExpMonth")); 
		//Implementation.AddText(driver, pageobject.PaymentDateYear(), Reusable.getproperty("Expyear")); 
		Implementation.AddText(driver, pageobject.PaymentCVV(), Reusable.getproperty("Cvv")); 
		
		Implementation.ClickObject(driver, pageobject.RegisterNewPracel());
			}
}
