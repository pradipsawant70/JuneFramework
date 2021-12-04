package com.learnautomation.hybrid.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	
	public static String getScreenshotInBase64(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		return ts.getScreenshotAs(OutputType.BASE64);
		
	}
	
	//wait for element
	public static WebElement waitForWebElement(WebDriver driver, By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		return wait.until(ExpectedConditions.elementToBeClickable(locator));	
	}
	
	
	//click
	public static void click(WebDriver driver,By locator)
	{
		waitForWebElement(driver, locator).click();
	}
	
	
	//type
	public static void type(WebDriver driver,By locator, String textToType)
	{
		waitForWebElement(driver, locator).sendKeys(textToType);
		
	}
	
	//frame
	public static void switchToFrame(WebDriver driver, String nameOrId)
	{
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
	}
	
	public static void switchToFrame(WebDriver driver, String nameOrId, int time)
	{
		new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
	}
	
	public static void switchToFrame(WebDriver driver, int index)
	
	{
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	
	public static void switchToFrame(WebDriver driver, By locator)
	{
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
		
	//alert
	public static void acceptAlert(WebDriver driver)
	{
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent()).accept();
	}
	
	public static void dismissAlert(WebDriver driver)
	{
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public static String getAlertText(WebDriver driver)
	{
		return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent()).getText();
	}
	
	public static String getAlertText(WebDriver driver, int second)
	{
		return new WebDriverWait(driver, Duration.ofSeconds(second)).until(ExpectedConditions.alertIsPresent()).getText();
	}
	
	public static void sleep(int second)
	{
		try
		{
			Thread.sleep(second*1000);			
		}
		catch (InterruptedException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public static String getText(WebDriver driver,By locator)
	{
		return waitForWebElement(driver, locator).getText();
	}
	
}
