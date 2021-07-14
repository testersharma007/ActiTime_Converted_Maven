package com.ActiTime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTime.generic.SeleniumLib;

public class EditUserPage 
{
	SeleniumLib slib;
	
	@FindBy(css="input[value='Delete This User']")
	private WebElement delUserBtn;
	
	public EditUserPage(WebDriver driver)
	{
		slib= new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDeleteUserBtn()
	{
		delUserBtn.click();
		slib.alertAccept();

	}
	

}
