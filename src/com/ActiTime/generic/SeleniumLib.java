package com.ActiTime.generic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SeleniumLib 
{
	WebDriver driver;
	/*****************************Constructor******************************************/
	public SeleniumLib(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/*****************************Enter DAta ******************************************/
	
	public void enterData(WebElement txtBx, String input)
	{
		/*	txtBx.clear();
		txtBx.sendKeys(input);*/
		
		//OR customiziation
		if (txtBx.getAttribute("value")!=null)
		{
			txtBx.clear();
			txtBx.sendKeys(input); //we can write this also.
		}
		else
		{
			txtBx.sendKeys(input);
		}

	}
	
	/**************************click button*********************************************/
	
	public void clickButton(WebElement button)
	{
		if (button.getAttribute("type").equals("button"))
		{
			button.click();
		}
	else if (button.getAttribute("type").equals("submit"))
	{
		button.submit();
	}	
	}
	/***********************click Check box********************************************/
	
	public void clickCheckbox(WebElement checkbox)
	{
		if (checkbox.isSelected())   //true
		{
			System.out.println("Check box is already selected ");
		}
		else
		{
			checkbox.click();
		}
	}
	/************************ select option by text ************************************/
	
	public void selectOptionByText(WebElement dropDown, String text)
	{
		Select sel= new Select(dropDown);
		sel.selectByVisibleText(text);
	}
	
	/**************************mouse over*****************************************/
	
	public void mouseOver(WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/************************** hard code wait***************************************/
	
	public void iSleep(int secs)
	{
		try
		{
			Thread.sleep(secs*1000);
		}
		catch (InterruptedException e )
		{
			e.printStackTrace();
		}
	}
	
	/*************************Explicit Wait******************************************/
	
	public void eWaitForVisible(WebElement element, int secs)
	{
		WebDriverWait wait=new WebDriverWait( driver,   secs);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/************************Varify expected and actual Results****************************************/
	
	public void validate(String expected, String actual, String passedMsg)
	{
		Assert.assertEquals(actual, expected);
		Reporter.log(passedMsg, true);
	}
	
	/********************************get Element text*******************************************/
	
	public String getElementTxt(WebElement element)
	{
		String text = element.getText();
		
		return text;
	}

	/*******************************Get Page Title****************************************/
	
	public String getPageTitle()
	{
		String title=driver.getTitle();
        
		return title;
	}
	/**************************validate Element displayed ************************************/
	
	public void validateElementDisplayed(WebElement element, String passedMsg)
	{
		Assert.assertTrue(element.isDisplayed());
		Reporter.log(passedMsg, true);
	}
	
	/***************************validate data contains*************************************/
	
	public void validateDataContains(WebElement element, String data, String passedMsg)
	{
		Assert.assertTrue(element.getText().contains(data));
		Reporter.log(passedMsg, true);
	}
	
	/*************************************Current Date*************************************/
	
	public void currentDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date= new Date();
		String date1= dateFormat.format(date);
		System.out.println(date1);		 
	}
	/************************************alert *************************************/
	
	public void alertAccept()
	{
		driver.switchTo().alert().accept();
	}

	public void alertDismiss()
	{
		driver.switchTo().alert().dismiss();
	}
	
}

