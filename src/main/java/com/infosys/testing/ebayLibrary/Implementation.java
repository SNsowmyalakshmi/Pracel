package com.infosys.testing.ebayLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

/**
 * The Class Implementation.
 */
public class Implementation 
{	
	/** Global Variables */
	/** The element. */
	static WebElement element;
	
	/**
	 * Method - Click object.
	 *
	 * @param driver the driver
	 * @param element the element
	 * @return the web element
	 */
	public static WebElement ClickObject(WebDriver driver, WebElement element)
	{
	 try
	 { 
		// System.out.println("Element Name : "+element.getText());
		// Reporter.log("Element Name : "+element.getText());
		 Reusable.ElementDisplayed(driver,element);
		 Reusable.ElementToBeClickable(driver,element);
		 Reusable.Click(element);
	 }
	 catch (Exception e)
	 {
		 e.printStackTrace();
	 }
		return element;
	 }
	
	/**
	 * Method - Add Text
	 *
	 * @param driver the driver
	 * @param element the element
	 * @param Text the text
	 * @return the web element
	 */
	public static WebElement AddText(WebDriver driver, WebElement element, String Text)
	{
	 try
	 { 
		 Reusable.ElementDisplayed(driver,element);
		 System.out.println("ElementDisplayed 1");
		 Reusable.IsEnabled(element);
		 System.out.println("ElementDisplayed 2");
		 element.clear();
		 System.out.println("ElementDisplayed 3");
		 Reusable.Sendkeys(element,Text);
	 }
	 catch (Exception e)
	 {
		 e.printStackTrace();
		 
	 }
		return element;
	 }
	

	
	
	
}
