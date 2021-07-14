package com.ActiTime.scripts;

import org.testng.annotations.Test;

import com.ActiTime.generic.BaseLib;
import com.ActiTime.generic.ExcelUtilities;
import com.ActiTime.pageobject.EnterTimeTrackPage;
import com.ActiTime.pageobject.LoginPage;

public class LoginTest extends BaseLib
{
	@Test (priority=1, description="verify valid login and home page")
	public void validLogin()
	{
		String file="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 1, 1);	
		String password=ExcelUtilities.readData(file, "Sheet1", 1, 2);		
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.verifyHomePage();
	
		}
	
	@Test(priority=2, description ="verify Invalid login")
	public void invalidLogin()
	{
		String file="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 2, 1);	
		String password=ExcelUtilities.readData(file, "Sheet1", 2, 2);	
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		lp.verifyInvalidLogin();
	}
	
}
