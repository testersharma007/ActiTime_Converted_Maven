package com.ActiTime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class BaseLib 
{
	public static WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser","baseurl"})
	public static void preCondition(String browserName , String url)
	{
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver" , "./exe_files/chromedriver.exe");
		//	driver=new RemoteWebDriver(DesiredCapabilities.chrome());
			driver= new ChromeDriver();
			Reporter.log("Chrome browser  launched ", true);
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver" , "./exe_files/geckodriver.exe");
		          //driver=new RemoteWebDriver(DesiredCapabilities.firefox());
			driver= new FirefoxDriver();
			Reporter.log("Firefox browser launched ", true);
		}
		
		else if (browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver" , "./exe_files/IEDriverServer.exe");
			//driver=new RemoteWebDriver(DesiredCapabilities.internetExplorer());
			driver= new InternetExplorerDriver();
			Reporter.log("IE browser launched ", true);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(url);
		Reporter.log(url+" Url is navigated " , true);
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
		Reporter.log("Browser closed ", true);

		if (driver!=null)
		{
			driver.quit();
			Reporter.log("All session are closed ", true);
		}
		
	}

}
