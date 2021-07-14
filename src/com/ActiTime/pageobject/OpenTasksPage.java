package com.ActiTime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTime.generic.SeleniumLib;

public class OpenTasksPage 
{
	SeleniumLib slib;
	
	@FindBy(linkText="Projects & Customers")
	private WebElement projNCustLink;
	@FindBy(css="input[value='Create New Tasks']")
	private WebElement createTaskBtn;
	@FindBy(xpath="//span[@class='successmsg']")
	private WebElement successMsg;
	@FindBy(name="visiableFilterString")
	private WebElement filterTask;
	@FindBy(name="searchTasks")
	private WebElement filterTaskSubmitBtn;
	@FindBy(xpath="//input[contains(@name,'taskSelected')]")
	private WebElement taskLinkChkBx;
	@FindBy(css="input[value='Delete Selected Tasks']")
	private WebElement clickOnDelTaskBtn;
	@FindBy(css="input[value='Delete Task']")
	private WebElement clickOnDelTaskConfirmBtn;
	
	public OpenTasksPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	//steps
	public void clickOnProjNCustLink()
	{
		projNCustLink.click();
	}
	
	//Steps
	public void clickOnCreateNewTaskBtn()
	{
		slib.clickButton(createTaskBtn);
	}
	
	public void verifyCreateTask()
	{
		String expected = "1 new task was added to the customer \"GE HealthCare\", project \"Medical Software\".";
		slib.validate(expected, slib.getElementTxt(successMsg), expected);
	}
	
	public void taskFilter(String taskName)
	{
		slib.enterData(filterTask, taskName);
	}
	public void clickOnFilterBtn()
	{
		slib.clickButton(filterTaskSubmitBtn);
	}
	public void clickOnTaskLinkChkBx()
	{
		slib.clickCheckbox(taskLinkChkBx);
	}
	public void clickOnDelTask()
	{
		slib.clickButton(clickOnDelTaskBtn);
		slib.clickButton(clickOnDelTaskConfirmBtn);
	}
	public void verifyDeletedTask()
	{
		String expected = "Selected tasks have been successfully deleted.";
		slib.validate(expected, slib.getElementTxt(successMsg), expected);
	}
}





