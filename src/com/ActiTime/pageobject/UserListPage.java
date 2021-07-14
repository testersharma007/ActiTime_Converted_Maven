package com.ActiTime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTime.generic.SeleniumLib;

public class UserListPage 
{
	SeleniumLib slib;
	
	@FindBy(xpath="//span[text()='Create New User']")
	private WebElement createNewUserBtn;
	@FindBy(className="successmsg")
	private WebElement successMsg;
	@FindBy(id="userCombo")
	private WebElement editUser;
	@FindBy(css="div[class*='x-combo-selected']")
	private WebElement selectUser;
	
	public UserListPage(WebDriver driver)
	
		{
			slib = new SeleniumLib(driver);
			PageFactory.initElements(driver, this);
		}
	
	
	
	public void clickOnCreateNewUser()
	{
		createNewUserBtn.click();
	}

	public void verifyUserCreation()
	{
		slib.validateElementDisplayed(successMsg, "user create  message is displayed ");
		String expected = "User account has been successfully created.";
		slib.validate(expected, slib.getElementTxt(successMsg), expected);
	}
	
	public void editUserProfile(String newUserName)
	{
		slib.enterData(editUser, newUserName);
		selectUser.click();
	}
	public void verifyDelUser()
	{
		String expected = "User account has been successfully deleted.";
		slib.validate(expected, slib.getElementTxt(successMsg), expected);
	}
}
