package com.infosys.testing.ebayRegression_Suite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.infosys.testing.ebayPageObject.PageObject;
import com.infosys.testing.ebayLibrary.Implementation;
import com.infosys.testing.ebayLibrary.Reusable;
import com.infosys.testing.ebayLibrary.SuperTestNG;

public class TestExecution extends com.infosys.testing.ebayLibrary.SuperTestNG
{
	@SuppressWarnings("static-access")
	@Test
	public void ebayLaunch_Verify() throws Exception
	{	
		
		Reporter.log("==========#ebay Test Case========");
		//Step 01 - Launch Browser & Open Test Client   
		SuperTestNG.OpenUrl(driver,Reusable.getproperty("ebayUrl"));
				
		//Step 02 - Search Text - Sony Tv
		PageObject pageobject = new PageObject(driver);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);		
		Implementation.ClickObject(driver, pageobject.GlobalSearch());		
		Implementation.AddText(driver, pageobject.GlobalSearch(), Reusable.getproperty("TvName"));
		
		//Step 03 - Click on Search Button
		Implementation.ClickObject(driver, pageobject.SearchButton());
		
		//Step 04 - Verify The List And Verify TV And Sony In It
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);		
		Reusable reuse = new Reusable();		
		
		//Step 04 - Select Screen Size 50-60 Inches
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='srp-carousel']//button[2]")).click();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//ul//li[5]/a/div[contains(text(), '50')]")).click(); //ul/li[5][@aria-hidden='true']/a/div
		
		//Step 05 - Verify The List And Verify TV 50-60 Inches
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		List<WebElement> allElements = driver.findElements(By.xpath("//ul//li/h3/a[text()]")); 		
		int k=50;
	    Boolean TvInchSize;
	    Boolean  TvInchSize1 =true;
		for (WebElement list: allElements)
		{ 
			int j = k;
		    String TvInch =  list.getText(); 		  
		    while (j <= 60)
	        {
	            if(TvInch.contains(Integer.toString(j)))
	            {	            	
	            	TvInchSize = true;
	            	break;
	            }
	            else
	            {
	            	TvInchSize = false;
	            }
	            k=j++;
	        }			
		}
		 if (TvInchSize1=true)
		    {		    	
		    	Reporter.log("List is filtered for the Screen size 50 to 60 inches");
		    }
		 else
		 	{			
		    	Reporter.log("List is not filtered for the Screen size 50 to 60 inches");
		 	}
		    		
		//Step 06 - Select Any Product	
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//ul//li[1]/h3/a[text()]")).click();
						
		//Step 07 - Verify ItemQty Is Not Empty
		int Qty = driver.findElements(By.id("qtyTextBox")).size();
		System.out.println(Qty);
		if(driver.findElements(By.id("qtyTextBox")) != null && driver.findElements(By.id("qtyTextBox")).size()>0)
		{
			System.out.println("Yes More");
		}
				
		
		//Step 08 - Verify TIme Left out 
		//N/A
		//Unable to see timeleft out in the ebay for any products
		
		
		//Step 9 & 10 - Store Product Name, Price & Seller Name.
		String ProdName = driver.findElement(By.xpath("//h1[@id='itemTitle'][text()]")).getText();
		System.out.println("Product Name :"+ProdName);		
		String Price = driver.findElement(By.xpath("//span[@id='prcIsum'][text()]")).getText();
		System.out.println("Price :"+Price);	
		String SellerName = driver.findElement(By.xpath("//div[@class='si-inner']/div/div/div/a/span[text()]")).getText();
		System.out.println("SellerName : "+SellerName);		
					
		//Step 11 - Click on Add TO Cart
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(), 'Add to cart')]")).click();
		
		//Step 12 - Verify Shopping Cart Is Displayed
		if(driver.findElement(By.xpath("//h1[@class='mb15 nowrap'][text()]")).isDisplayed())
		{
			System.out.println("Shopping Cart Is Displayed");
			 Reporter.log("Shopping Cart Is Displayed");
		}
				
		//Step 13 - Verify Information in Shopping Cart [Product Name, Price & Seller Name Should Match with Step 10]
		System.out.println("Product ....");
		reuse.VerifyExactText(driver.findElement(By.xpath("//span[@id='192508527643_title']/a")), ProdName,driver);
		//Price
		System.out.println("Price ....");
		reuse.VerifyContainsText(driver.findElement(By.xpath("//div[@class='fw-b'][text()]")), Price,driver);
		//Seller Name
		System.out.println("Seller ....");
		reuse.VerifyExactText(driver.findElement(By.xpath("//a[@class='mbg-id'][text()]")), SellerName,driver);		
		
		//Step 14 - Verify Total Price Is Equals to Single Unit Price
		System.out.println("Total ....");
		reuse.VerifyContainsText(driver.findElement(By.id("asyncTotal")), Price,driver);
		
		//Step 15 - Click On Proceed to Check Out Button
		Implementation.ClickObject(driver, driver.findElement(By.id("ptcBtnBottom")));
		
		//Step 16 - Proceed Check out as Guest & Verify Ebay LogIn is showed And Click Continue As Guest
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		if(driver.findElement(By.id("gtChk")).isDisplayed())
		{
			System.out.println("Guest Sign In Is Displayed");
			Reporter.log("Guest Sign In Is Displayed");
		}
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		Implementation.ClickObject(driver, driver.findElement(By.id("gtChk")));
		
		//Step 17 - Verify Guest Check out Screen with Product Name, Price as per Step 10.
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		reuse.VerifyExactText(driver.findElement(By.xpath("//div[@class='seller-item-group']//div[@class='col-xs-9 item-title'][text()]")), ProdName,driver);		
		reuse.VerifyContainsText(driver.findElement(By.xpath("//div[@class='item-price']/span")), Price,driver);		
		reuse.VerifyContainsText(driver.findElement(By.xpath("//td[@class='bold nowrap']/span")), Price,driver);		
		
		//Step 18 - Verify Order Total as Single Unit Price.
		reuse.VerifyContainsText(driver.findElement(By.xpath("//td[@class='bold nowrap']/span")), Price,driver);		
	}
}
