package com.ActiTime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTime.generic.SeleniumLib;

public class EditCustInfoPage
{
	
	SeleniumLib slib;
	
	@FindBy(css="input[value='Delete This Customer']")
	private WebElement deleteThisCustBtn;
	
	@FindBy(id="deleteButton")
	private WebElement deleteCustConfirmBtn;
	
	public EditCustInfoPage(WebDriver driver)
	{
		slib= new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	//features
	public void deleteCustomer() {
		slib.clickButton(deleteThisCustBtn);
		slib.clickButton(deleteCustConfirmBtn);
	}
	

}
