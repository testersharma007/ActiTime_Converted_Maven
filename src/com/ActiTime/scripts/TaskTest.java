package com.ActiTime.scripts;

import org.testng.annotations.Test;

import com.ActiTime.generic.BaseLib;
import com.ActiTime.generic.ExcelUtilities;
import com.ActiTime.pageobject.ActiveProjNCustPage;
import com.ActiTime.pageobject.CreateNewCustPage;
import com.ActiTime.pageobject.CreateNewProjPage;
import com.ActiTime.pageobject.CreateNewTaskPage;
import com.ActiTime.pageobject.EditCustInfoPage;
import com.ActiTime.pageobject.EditProjInfoPage;
import com.ActiTime.pageobject.EnterTimeTrackPage;
import com.ActiTime.pageobject.LoginPage;
import com.ActiTime.pageobject.OpenTasksPage;

public class TaskTest extends BaseLib
{

	@Test(description="verify create customer"/*,enabled=false*/)
	public void createCustomer()
	{
		String file="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 3, 1);	
		String password=ExcelUtilities.readData(file, "Sheet1", 3, 2);	
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTasksPage otp= new OpenTasksPage(driver);
		otp.clickOnProjNCustLink();
		
		ActiveProjNCustPage apcp= new ActiveProjNCustPage(driver);
		apcp.clickOnCreateNewCustBtn();
		
		String customerName= ExcelUtilities.readData(file, "sheet1", 3, 3);
		CreateNewCustPage cncp=new CreateNewCustPage(driver);
		cncp.createCustomer(customerName);
		
		apcp.verifyCreateCustomer(customerName);
		
		apcp.clickOnLogout();	
	}
	
	@Test(dependsOnMethods= {"createCustomer"}, description="varifying delete customer",enabled=false)
	public void deleteCustomer()
	{
	
		String file="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 4, 1);	
		String password=ExcelUtilities.readData(file, "Sheet1", 4, 2);	
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTasksPage otp= new OpenTasksPage(driver);
		otp.clickOnProjNCustLink();
		
		String customerName=ExcelUtilities.readData(file, "Sheet1", 4, 3);	
		ActiveProjNCustPage apcp=new ActiveProjNCustPage(driver);
				apcp.showCustomer(customerName);
				
				EditCustInfoPage ecip= new EditCustInfoPage(driver);
				ecip.deleteCustomer();
				
				apcp.verifyDeleteCustomer();
				apcp.clickOnLogout();
	}
	
	  @Test(dependsOnMethods= {"createCustomer"}, description="Create project verify"/*,enabled=false*/)
	public void createProject()
	{
		String file="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 5, 1);	
		String password=ExcelUtilities.readData(file, "Sheet1", 5, 2);	
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTasksPage otp= new OpenTasksPage(driver);
		otp.clickOnProjNCustLink();
		
		ActiveProjNCustPage apcp= new ActiveProjNCustPage(driver);
		apcp.clickOnCreateNewProjBtn();
		
		String customerName=ExcelUtilities.readData(file, "Sheet1", 5, 3);	
		String projName=ExcelUtilities.readData(file, "Sheet1", 5, 4);	
		CreateNewProjPage cnpp= new CreateNewProjPage(driver);
		cnpp.selectCust(customerName);
		cnpp.createProj(projName);
		
		apcp.verifyCreateProject(projName);
		
		apcp.clickOnLogout();
	}
	
	  @Test(enabled=false)
	  public void deleteProject()
	  {
			String file="./testdata/testdata.xlsx";
			String username=ExcelUtilities.readData(file, "Sheet1", 5, 1);	
			String password=ExcelUtilities.readData(file, "Sheet1", 5, 2);	
			LoginPage lp=new LoginPage(driver);
			lp.login(username, password);
			
			EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
			ettp.clickOnTasks();
			
			OpenTasksPage otp= new OpenTasksPage(driver);
			otp.clickOnProjNCustLink();
			
			ActiveProjNCustPage apcp= new ActiveProjNCustPage(driver);  //for click  
			
		//	 * Write code for click on project link from Active Proj and Customer
			 
			
			EditProjInfoPage epip=new EditProjInfoPage(driver);
			epip.deleteProject();
	
			apcp.verifyDeleteProject();
			
			apcp.clickOnLogout();
			
	  }
	  
	  @Test(dependsOnMethods= {"createProject"},description="verify create task"/*,enabled=false*/)
	  public void createTask()
	  {
		  String file="./testdata/testdata.xlsx";
			String username=ExcelUtilities.readData(file, "Sheet1", 7, 1);	
			String password=ExcelUtilities.readData(file, "Sheet1", 7, 2);	
			LoginPage lp=new LoginPage(driver);
			lp.login(username, password);
			
			EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
			ettp.clickOnTasks();
			
			OpenTasksPage otp= new OpenTasksPage(driver);
			otp.clickOnCreateNewTaskBtn();
			
			
			String customerName =ExcelUtilities.readData(file, "Sheet1", 7, 3);
			String projectName=ExcelUtilities.readData(file, "Sheet1", 7, 4);
			String taskName=ExcelUtilities.readData(file, "Sheet1", 7, 5);
			String billType=ExcelUtilities.readData(file, "Sheet1", 7, 6);
			CreateNewTaskPage cntp= new CreateNewTaskPage(driver);
			cntp.selCustomer(customerName);
			cntp.selProject(projectName);
			cntp.fillInTask(taskName, billType);
			cntp.clickOnCreateTaskBtn();
			
			//String createTaskName=ExcelUtilities.readData(file, "Sheet1", 7, 5);
			otp.verifyCreateTask();
			
			ActiveProjNCustPage apcp= new ActiveProjNCustPage(driver);
			apcp.clickOnLogout();
	  }
	  
	  @Test(dependsOnMethods= {"createTask"}, description="verify delete task",enabled=false)
	  public void deleteTask()
	  {
		    String file="./testdata/testdata.xlsx";
			String username=ExcelUtilities.readData(file, "Sheet1", 7, 1);	
			String password=ExcelUtilities.readData(file, "Sheet1", 7, 2);	
			LoginPage lp=new LoginPage(driver);
			lp.login(username, password);
			
			EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
			ettp.clickOnTasks();
			
			String taskName=ExcelUtilities.readData(file, "Sheet1", 7, 5);
			OpenTasksPage otp= new OpenTasksPage(driver);
			otp.taskFilter(taskName);
			
			otp.clickOnFilterBtn();
			
			otp.clickOnTaskLinkChkBx();
			
			otp.clickOnDelTask();
	
			otp.verifyDeletedTask();
	  }
}
