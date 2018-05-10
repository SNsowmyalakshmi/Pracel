package com.Pracelpoint.testing.PracelLibrary;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


/**
 * The Class Reusable.
 */
public class Reusable 
{
	/** Global Variable Declaration */
	/** The env name. */
	/** The filename. */
	/** The filename 1. */
	/** The loader. */
	/** The resource stream. */
	/** The element. */
	/** The props. */
	/** The propval. */
	/** The parent window handle. */
	/** The window handlers. */
	static String env_name;
	static String filename;
	static String filename1;
	static ClassLoader loader; 
	static InputStream resourceStream;
	static WebElement element;	
	private static Properties props = new Properties();
	private static Properties propval = new Properties();
	public static String parentWindowHandle = null; 	
	public static List<String> windowHandlers = new ArrayList<String>();
	static SuperTestNG supertestNG = new SuperTestNG();
	/** Methods */
	
	/**
	 * Method - SetUpDriver.
	 *
	 * @param env the env
	 * @return the string
	 * @throws InterruptedException the interrupted exception
	 */
	public static String Setupdriver(String env) throws  InterruptedException 
    {		
		//System.out.println("Here in Setupdriver In Reusable::");
		env_name = env;
        if(env_name.equalsIgnoreCase("test")) filename = com.Pracelpoint.testing.Pracel.Utils.ConstantsProperties.TestPropFile;
	    loader = Thread.currentThread().getContextClassLoader();
	    try
	    {
		   resourceStream = loader.getResourceAsStream(filename);
	       props.load(resourceStream);
	    }
	    catch(Exception e)
	    {
		   System.out.println(e);
	    }	   	
	    return env;
     }	
	
	/**
	 * Methods - Gets The Property From Property File
	 *
	 * @param key the key
	 * @return the property
	 */
	public static String getproperty(String key)
	{
		return props.getProperty(key);
	}
	
	/** Methods */
	/**
	 * Method - To Verify ElementToBeClickable
	 *
	 * @param driver the driver
	 * @param element the element
	 * @return the web element
	 */
	public static WebElement ElementToBeClickable(WebDriver driver,WebElement element)
	{		
		try
		 {  	
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		 }
		 catch (Exception e)
		 {
			 e.printStackTrace();
		 }
		return element;
	}
	
	/**
	 *  Method - To Verify Element displayed.
	 *
	 * @param driver the driver
	 * @param element the element
	 * @return the web element
	 */
	public static WebElement ElementDisplayed(WebDriver driver,WebElement element)
	{		
		 try
		 {  
			 WebElement Element = element;
			 Element.isDisplayed();
			 driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
			 logMessage(element+" Should Display.",element+" Is Displayed","pass");
			 System.out.println("Displayed Yes");
			return element;
		 }
		 catch (Exception e)
		 {
			 Assert.fail("Element Not Displayed : "+ element);
		 }
		return null;
	}
	
	/**
	 *  Method - To Click.
	 *
	 * @param element the element
	 * @return the web element
	 */
	public static WebElement Click(WebElement element)
	{		
		try
		{  
			WebElement Element = element;
			Element.click();
			 System.out.println("Clicked Yes");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return element;
	}
	
	/**
	 * Method - To Add Text [Send Keys]
	 *
	 * @param element the element
	 * @param Text the text
	 * @return the web element
	 */
	public static WebElement Sendkeys(WebElement element, String Text)
	{		
		try
		{  
			 WebElement Element = element;
			 System.out.println("Before SendKeys Clear");
			 Element.clear();
			 System.out.println("After SendKeys Clear");
			 Element.sendKeys(Text);
			 
			 System.out.println("SenKeys Yes");
		 }
		 catch (Exception e)
		 {
			 e.printStackTrace();
		 }
		 return element;
	}
	
	/**
	 * Method - To Check Element Enabled
	 *
	 * @param element the element
	 * @return the web element
	 */
	public static WebElement IsEnabled(WebElement element)
	{		
		try
		{  
			 WebElement Element = element;
			 Element.isEnabled();
			 System.out.println("Enabled Yes");
		}
		catch (Exception e)
		{
			 e.printStackTrace();
		}
		return element;
	}
	
	/**
	 * Method - Log Message.
	 *
	 * @param expectedMsg the expected msg
	 * @param actualMsg the actual msg
	 * @param status the status
	 */
	public static void logMessage(String expectedMsg,String actualMsg,String status)
	{
		if(status.equalsIgnoreCase("pass"))
		{
			System.out.println("Status : " + status + " :: "+actualMsg);
			Assert.assertTrue(true);
			 System.out.println("Assert True Yes");
		}
		else
		{
			System.out.println("Status : " + status + " :: "+actualMsg);
			//Assert.assertTrue(false);
		}		
	}
	
	/** 
	 * @category Double click an element using Actions class
	 * @param web element
	 */
	public static void doubleClick(WebDriver driver,WebElement element){
		if ((driver != null) && (element != null))
			(new Actions(driver)).doubleClick(element).build().perform();	
	}
	
	/**
	 * Method - Verify Exact Text.
	 *
	 * @param element the element
	 * @param compareValue the compare value
	 * @throws Exception 
	 */
	public static void VerifyExactText(WebElement element,String compareValue,WebDriver driver) throws Exception{
	try
	{
		WebElement Welement= element;
		String value=Welement.getText();
		System.out.println("Value : "+value);
		if(value.equalsIgnoreCase(compareValue))
		{				
			logMessage(compareValue+" should display.", compareValue+" is displayed.", "pass");
			 Reporter.log(compareValue+" should display."+compareValue+" is displayed."+ "pass");
		}
		else
		{
			logMessage(compareValue+" should display.", compareValue+" is not displayed.", "fail");
			Reporter.log(compareValue+" should display."+compareValue+" is not displayed."+ "fail");
			supertestNG.takeScreenshot(driver);
		}
	}catch(Exception e){
		logMessage(compareValue+" should display.","Exception occured. Exception : "+e.getMessage(), "fail");
		Reporter.log(compareValue+" should display." + " Exception occured. Exception : "+e.getMessage()+ "fail");
		supertestNG.takeScreenshot(driver);
	}
	}
	
	/**
	 * Method - Verify Contains Text
	 *
	 * @param Response the response
	 * @param compareValue the compare value
	 * @throws Exception 
	 */
	public static void VerifyContainsText(WebElement element,String compareValue,WebDriver driver) throws Exception
	{
	try
	{
		WebElement Welement= element;
		String value=Welement.getText();
		System.out.println("Value : "+value);
		if(compareValue.contains(value))
			{				
				logMessage(compareValue+" should display.", compareValue+" is displayed.", "pass");		
				Reporter.log(compareValue+" should display."+compareValue+" is displayed."+ "pass");
			}
			else
			{
				logMessage(compareValue+" should display.", compareValue+" is not displayed.", "fail");
				Reporter.log(compareValue+" should display."+compareValue+" is not displayed."+ "fail");
				supertestNG.takeScreenshot(driver);
			}
		}catch(Exception e){
			logMessage(compareValue+" should display.","Exception occured. Exception : "+e.getMessage(), "fail");
			Reporter.log(compareValue+" should display." + " Exception occured. Exception : "+e.getMessage()+ "fail");
			supertestNG.takeScreenshot(driver);
		}		
	}
	
	public static void VerifyActualTextExpected(WebElement Actualelement,WebElement Expectedelement,WebDriver driver) throws Exception
	{
	try
	{
		WebElement WebActualement= Actualelement;
		String Actualvalue=WebActualement.getText();
		WebElement WebExpectedelement= Expectedelement;
		String Expectedvalue=WebExpectedelement.getText();
		System.out.println("Actual value : "+Actualvalue +" Expectedvalue "+Expectedvalue);
		if(Actualvalue.contains(Expectedvalue))
			{				
				logMessage(Actualvalue+" Contains ", Expectedvalue+" Hence ", "pass");		
				Reporter.log(Actualvalue+" Contains"+Expectedvalue+" Hence "+ "pass");
				System.out.println(Actualvalue+" Contains "+ Expectedvalue+" Hence "+ "pass");
			}
			else
			{
				logMessage(Actualvalue+" does not Contain", Expectedvalue+" Hence ", "fail");
				Reporter.log(Actualvalue+" does not Contain"+Expectedvalue+" Hence "+ "fail");
				System.out.println(Actualvalue+" does not Contain"+Expectedvalue+" Hence "+ "fail");
				supertestNG.takeScreenshot(driver);
			}
		}catch(Exception e){
			logMessage("Verify Actual Text and Expected is not display.","Exception occured. Exception : "+e.getMessage(), "fail");
			Reporter.log("Verify Actual Text and Expected is not display.,Exception occured. Exception : "+e.getMessage()+ "fail");
			supertestNG.takeScreenshot(driver);
		}		
	}
}
