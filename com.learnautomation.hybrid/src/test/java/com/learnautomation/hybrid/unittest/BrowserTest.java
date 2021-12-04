package com.learnautomation.hybrid.unittest;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.hybrid.factory.BrowserFactory;

public class BrowserTest {
	
	@Test
	public void testBrowser()
	{
		WebDriver driver=BrowserFactory.startBrowser("chrome", "http://www.facebook.com");
		Assert.assertNotNull(driver);
		driver.quit();
		
	}

}
