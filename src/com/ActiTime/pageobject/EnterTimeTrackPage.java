package com.ActiTime.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTime.generic.SeleniumLib;

public class EnterTimeTrackPage  extends BasePage      //dekh lena
{
	SeleniumLib slib;

	@FindBy(xpath="//td[@class='pagetitle']")
	private List<WebElement> pageTitle;
	
	
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);                       //dekh lena
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);   //check null pointer exception
	}
	
	//features 
	public void verifyHomePage()
	{
	     String expected="Enter Time-Track";
	     String actual = slib.getElementTxt(pageTitle.get(1));
	     slib.validate(expected, actual, "Home Page Is Varified");
	     
	     slib.validate("actiTIME - Enter Time-Track", slib.getPageTitle(), "Home page title is verified ");
	}
	
	
}
