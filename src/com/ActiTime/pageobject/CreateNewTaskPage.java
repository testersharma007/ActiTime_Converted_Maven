package com.ActiTime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTime.generic.SeleniumLib;

public class CreateNewTaskPage 
{
	SeleniumLib slib;
	
	@FindBy(name="customerId")
	private WebElement custDrpDwn;
	@FindBy(name="projectId")
	private WebElement projDrpDwn;
	@FindBy(name="task[0].name")
	private WebElement taskNameTxtField;
	@FindBy(css="input[name='task[0].deadline']")
	private WebElement deadLineDateTxtField;
	@FindBy(name="task[1].billingType")
	private WebElement billingTypeDrpDwn;
	@FindBy(name="task[0].markedToBeAddedToUserTasks")
	private WebElement myTimeTrackChkBx;
	@FindBy(css="input[value='Create Tasks']")
	private WebElement createTaskBtn;
	
	
	public CreateNewTaskPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selCustomer(String customerName )
	{
		slib.selectOptionByText(custDrpDwn, customerName);
	}
	public void selProject(String projectName)
	{
		slib.selectOptionByText(projDrpDwn, projectName);
	}
	public void fillInTask(String taskName , String billType)
	{
		slib.enterData(taskNameTxtField, taskName);
		slib.selectOptionByText(billingTypeDrpDwn, billType);
		slib.clickCheckbox(myTimeTrackChkBx);
	}
	
	public void clickOnCreateTaskBtn()
	{
		slib.clickButton(createTaskBtn);
	}
	
}
