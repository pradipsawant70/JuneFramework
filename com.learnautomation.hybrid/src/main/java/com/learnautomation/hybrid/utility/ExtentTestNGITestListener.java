package com.learnautomation.hybrid.utility;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ExtentTestNGITestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.getInstance();
	ExtentTest child;
	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

	public synchronized void onStart(ITestContext context) {

	}

	public synchronized void onFinish(ITestContext context) {
		
		System.out.println("********************** Writing result to report ***********************");

		extent.flush();
		
		System.out.println("********************** Report completed ***********************");

	}

	public synchronized void onTestStart(ITestResult result) {

		ExtentTest parent = extent.createTest(result.getMethod().getMethodName());
		parentTest.set(parent);

		/*
		 * extent.createTest(result.getHost())
		 * extent.createTest(result.getInstanceName())
		 * extent.createTest(result.getName()) extent.createTest(result.getTestName())
		 * extent.createTest(result.getAttribute(null))
		 * extent.createTest(result.getAttributeNames())
		 * extent.createTest(result.getEndMillis())
		 * extent.createTest(result.getMethod())
		 * extent.createTest(result.getStartMillis())
		 * extent.createTest(result.getStatus())
		 * extent.createTest(result.getParameters())
		 */

	}

	public synchronized void onTestSuccess(ITestResult result) {

		System.out.println("********************** Test Passed ***********************");

		parentTest.get().pass("Test Passed");
	}

	public synchronized void onTestFailure(ITestResult result) {

		System.out.println("********************** Test Failed **********************");
		
		WebDriver driver =null ;
		
		try 
		{
			Field f=result.getTestClass().getRealClass().getDeclaredField("driver");
			Object obj=f.get(result.getInstance());
			driver=(WebDriver)obj;
			
			//driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
		}
		catch (Exception e) 
		{
			System.out.println("Can not access runtime class "+e.getMessage());
		} 

				
		parentTest.get().fail("Test Failed" + result.getThrowable().getMessage(),
				MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.getScreenshotInBase64(driver )).build());
		
		/*MediaEntityBuilder.createScreenCaptureFromBase64String(base64)
		MediaEntityBuilder.createScreenCaptureFromBase64String(base64, title)
		MediaEntityBuilder.createScreenCaptureFromPath(path)
		MediaEntityBuilder.createScreenCaptureFromPath(path, title)*/

	}

	public synchronized void onTestSkipped(ITestResult result) {

		System.out.println("********************** Test Skipped ***********************");

		parentTest.get().skip("Test Skipped");
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

}
