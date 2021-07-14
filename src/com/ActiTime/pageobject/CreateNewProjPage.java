package com.ActiTime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTime.generic.SeleniumLib;

public class CreateNewProjPage 
{
	SeleniumLib slib;
	@FindBy(name="customerId")
	private WebElement custDrpDwn;
	@FindBy(name="name")
	private WebElement projNameTxtBx;
	@FindBy(name="createProjectSubmit")
	private WebElement createProjSubmitBtn;
	
	public CreateNewProjPage(WebDriver driver)
	{
		 slib=	new SeleniumLib(driver);
	      PageFactory.initElements(driver, this);
	}
	
	//Features
	public void selectCust(String customerName)
	{
		slib.selectOptionByText(custDrpDwn, customerName);
	}
	
	public void createProj(String projName)
	{
		slib.enterData(projNameTxtBx, projName);
		slib.clickButton(createProjSubmitBtn);
	}
}
