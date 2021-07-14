package com.ActiTime.scripts;

import org.testng.annotations.Test;

import com.ActiTime.generic.BaseLib;
import com.ActiTime.generic.ExcelUtilities;
import com.ActiTime.pageobject.ActiveProjNCustPage;
import com.ActiTime.pageobject.CreateNewUserPage;
import com.ActiTime.pageobject.EditUserPage;
import com.ActiTime.pageobject.EnterTimeTrackPage;
import com.ActiTime.pageobject.LoginPage;
import com.ActiTime.pageobject.UserListPage;

public class UserTest extends BaseLib
{
	@Test(description="verify create new user"/*, enabled=false*/)
	public void createNewUser()
	{
		String file="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 8, 1);	
		String password=ExcelUtilities.readData(file, "Sheet1", 8, 2);	
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnUsers();
		
		UserListPage ulp= new UserListPage(driver);
		ulp.clickOnCreateNewUser();
		
		String newUserName = ExcelUtilities.readData(file,"Sheet1", 8, 3);
		String newUserPassword = ExcelUtilities.readData(file, "Sheet1", 8, 4);
		CreateNewUserPage cnup= new CreateNewUserPage(driver);
		cnup.userCredential(newUserName, newUserPassword);
		
		String firstname = ExcelUtilities.readData(file, "Sheet1", 8, 5);
		String lastname = ExcelUtilities.readData(file,"Sheet1", 8, 6);
		String emailAddress = ExcelUtilities.readData(file, "Sheet1", 8, 7);
		cnup.userDetails(firstname, lastname, emailAddress);
		
		cnup.clickOnCreateUser();
		
		ulp.verifyUserCreation();
		
	}
	
	@Test(dependsOnMethods= {"createNewUser"}, description="varifying login user"/*, enabled=false*/)
	public void loginNewUser()
	{
		String file="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 9, 1);	
		String password=ExcelUtilities.readData(file, "Sheet1", 9, 2);	
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
	EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
	ettp.verifyHomePage();
		
		
	}
	
	@Test (dependsOnMethods= {"loginNewUser"}, description="varifying delete user"/*, enabled=false*/)
	public void deleteUser()
	{
		String file="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 10, 1);	
		String password=ExcelUtilities.readData(file, "Sheet1", 10, 2);	
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnUsers();
		
		String newUserName = ExcelUtilities.readData(file, "Sheet1", 10, 3);	
		UserListPage ulp= new UserListPage(driver);
		ulp.editUserProfile(newUserName);
		
		EditUserPage eup= new EditUserPage(driver);
		eup.clickOnDeleteUserBtn();
				
		ulp.verifyDelUser();
		
	}
	
}
