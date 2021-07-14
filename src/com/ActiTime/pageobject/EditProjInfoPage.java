package com.ActiTime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTime.generic.SeleniumLib;

public class EditProjInfoPage 
{
	SeleniumLib slib;
	 
	@FindBy(css="input[value='Delete This Project']")
	private WebElement delProjBtn;
	@FindBy(id="deleteButton")
	private WebElement delProjConfirmBtn;

	
	public EditProjInfoPage(WebDriver driver)
	{
		slib= new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void deleteProject()
	{
		slib.clickButton(delProjBtn);
		slib.clickButton(delProjConfirmBtn);
	}
}
