package com.ActiTime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTime.generic.SeleniumLib;

public class LoginPage 
{
	SeleniumLib slib;
	@FindBy(name="username")
	private WebElement unTxtBx;
	@FindBy(name="pwd")
	private WebElement pwdTxtBx;
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	@FindBy(xpath="//div[@id='ServerSideErrorMessage']//span[@class='errormsg']")
	private WebElement invalidLoginMsg;
	
	public LoginPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Features
	public void login(String username ,String password)
	{
		slib.enterData(unTxtBx, username);
		slib.enterData(pwdTxtBx, password);
		loginBtn.click();
		
	}
	
	//Feature
	public void verifyInvalidLogin()
	{
		String expected="Username or Password is invalid. Please try again.";
		String actual= slib.getElementTxt(invalidLoginMsg);
		slib.validate(expected, actual, "Invalid login is varified");
	}
	


}
