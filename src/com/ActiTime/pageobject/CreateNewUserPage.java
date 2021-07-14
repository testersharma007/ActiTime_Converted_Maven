package com.ActiTime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTime.generic.SeleniumLib;

public class CreateNewUserPage
{
	SeleniumLib slib;
	
	@FindBy(name="username")
	private WebElement userName;
	@FindBy(name="passwordText")
	private WebElement userPass;
	@FindBy(name="passwordTextRetype")
	private WebElement userRePass;
	@FindBy(name="firstName")
	private WebElement firstName;
	@FindBy(name="lastName")
	private WebElement lastName;
	@FindBy(name="email")
	private WebElement userEmail;
	@FindBy(css="input[value*='Create User']")
	private WebElement createUserSubmitBtn;
	
	public CreateNewUserPage(WebDriver driver)
	{
		slib = new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	//steps
	public void userCredential(String newUserName, String newUserPassword)
	{
		slib.enterData(userName, newUserName);
		slib.enterData(userPass, newUserPassword);
		slib.enterData(userRePass, newUserPassword);
	}
	
	public void userDetails(String firstname, String lastname, String emailAddress)
	{
		slib.enterData(firstName, firstname);
		slib.enterData(lastName, lastname);
		slib.enterData(userEmail, emailAddress);
	}
	
	public void clickOnCreateUser()
	{
		slib.clickButton(createUserSubmitBtn);
	}
	

}
