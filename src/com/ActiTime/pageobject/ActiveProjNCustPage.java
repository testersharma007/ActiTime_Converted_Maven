package com.ActiTime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTime.generic.SeleniumLib;

public class ActiveProjNCustPage  extends BasePage
{
	SeleniumLib slib;
	@FindBy(css="input[value='Create New Customer']")
	private WebElement createNewCustBtn;
	@FindBy(className="successmsg")
	private WebElement successMsg;
	@FindBy(name="selectedCustomer")
	private WebElement custDrpDwn;
	@FindBy(css="input[value*='Show']")
	private WebElement custShowBtn;
	@FindBy(xpath="//td[starts-with(@id,'customerNameCell')]//a[contains(@href,'customerId')]")
	private WebElement customerNameLink;
	@FindBy(css="input[value='Create New Project']")
	private WebElement createNewProjBtn;
	/*@FindBy(xpath="//td[starts-with(@id,'projectNameCell')]//a[contains(@href,'projectId')]")
	private WebElement projNameLink;*/ //Delete Project
	
	public ActiveProjNCustPage(WebDriver driver)
	{
		super(driver);
		slib= new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
		}
	
	//steps
	
	public void clickOnCreateNewCustBtn()
	{
		slib.clickButton(createNewCustBtn);
	}
	
	public void verifyCreateCustomer(String customerName)
	{
		slib.validateElementDisplayed(successMsg, "Create customer message is displayed ");
		slib.validateDataContains(successMsg, customerName, successMsg.getText());
	}
	
	public void verifyCreateProject(String projName) 
	{
		slib.validateElementDisplayed(successMsg, "Create project message is displayed ");
		slib.validateDataContains(successMsg, projName, successMsg.getText());
	}
	
	//Features
	public void showCustomer(String customerName)
	{
		slib.selectOptionByText(custDrpDwn, customerName);
		slib.clickButton(custShowBtn);
		customerNameLink.click();
	}
	/*	//Features
	public void  showCustProj(String cu)
	{
		//delete project
	}
	*/
	public void verifyDeleteCustomer()
	{
		String expected="Customer has been successfully deleted.";
		slib.validate(expected, slib.getElementTxt(successMsg), expected);
	}
	
	public void verifyDeleteProject()
	{
		String expected ="Project has been successfully deleted.";
		slib.validate(expected, slib.getElementTxt(successMsg), expected);
	}
	
	
	//Steps 
	
	public void clickOnCreateNewProjBtn()
	{
		slib.clickButton(createNewProjBtn);
	}


}
