package com.infosys.testing.ebayPageObject;

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
	@FindBy(xpath="//input[@id='gh-ac']")
	private WebElement GlobalSearch;
	
	//SearchButton
	@FindBy(id="gh-btn")
	private WebElement SearchButton;
		
	
		
	//<<Methods>>
	
	//GlobalSearch	
	public WebElement GlobalSearch()
	{
	   return this.GlobalSearch;
	}
	
	//SearchButton	
	public WebElement SearchButton()
	{
	   return this.SearchButton;
	}
	
	
	
		
}