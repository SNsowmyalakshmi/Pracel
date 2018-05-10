package com.Pracelpoint.testing.PracelLibrary;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class SuperTestNG
{

	protected WebDriver driver;
	
	@BeforeSuite
	@Parameters("env")	
	public void driverSetup(String env) throws  InterruptedException 
    {			
        Reusable.Setupdriver(env); 	                
    }	
	
	
	@BeforeMethod
	@Parameters("Broswer")
	public void LaunchBrowser(String Browser) throws  InterruptedException
	{
		try
		{
			System.out.println("Before Method : In Launch Browser  :"+Browser);
			if (Browser.equalsIgnoreCase("chrome"))
			{	
				System.setProperty("webdriver.chrome.driver", String.valueOf(System.getProperty("user.dir"))+"\\chromedriver.exe");
		         ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
		         driver = new ChromeDriver(options);
		         //driver.manage().window().maximize();
				 driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
				 System.out.println("Successfully Opened " + Browser);
			}					
	}
	catch(Exception e)
	{
		System.out.println("Error " + e);
	}

	}
	
	//Open URL
	//public void OpenUrl(String Url) throws  InterruptedException 
	public static String OpenUrl(WebDriver driver,String Url) throws  InterruptedException
    {
		try
		{
			//driver.get(Reusable.getproperty(Url));
			//System.out.println("URL..... " + Url);
			driver.get(Url);
			driver.manage().timeouts().pageLoadTimeout(500,TimeUnit.SECONDS);
			System.out.println("Successfully Opened " + Url);
			//org.apache.log4j.BasicConfigurator.configure(new NullAppender());
			//Logger.getRootLogger().setLevel(Level.WARN);
		}
		catch(Exception e)
		{
			System.out.println("UnSuccessfull In Opening " + Url);
		}
		return Url;
    }
	public static void takeScreenshot(WebDriver driver) throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("E:\\Workspaces\\Pracelpoint\\Testing\\Screenshots\\"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
		 
		String filePath = screenShotName.toString();
		String path = "<br><img src="+screenShotName+"' height='400' width='400'/><br>";
		Reporter.log(path);
		 
		}
}
