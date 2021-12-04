package com.learnautomation.hybrid.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.learnautomation.hybrid.dataProviders.ConfigUtility;
import com.learnautomation.hybrid.factory.BrowserFactory;

public class BaseClass {
	
	public WebDriver driver;
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	//Pass parameters while building or while running test cases
	
	@Parameters({"Browser","URL"})
	@BeforeClass
	public void setup(String browserName, String applicationURL)
	{
		System.out.println("LOG:INFO- Staring browser");
		
		driver=BrowserFactory.startBrowser(browserName, applicationURL);
		System.out.println("LOG:INFO- Browser started");
	}
	
	
	//gets the data from config file
	/*
	@BeforeClass
	public void setup()
	{
		System.out.println("LOG:INFO- Staring browser");
		
		driver=BrowserFactory.startBrowser(ConfigUtility.getProperty("browser"), ConfigUtility.getProperty("appURL"));
		System.out.println("LOG:INFO- Browser started");
	}*/
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("LOG:INFO- Closing browser");
		driver.quit();
		System.out.println("LOG:INFO- Browser closed");
	}

}
