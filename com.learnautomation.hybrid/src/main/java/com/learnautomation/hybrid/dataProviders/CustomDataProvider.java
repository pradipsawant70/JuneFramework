package com.learnautomation.hybrid.dataProviders;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
	
	@DataProvider(name="Login")
	public static Object[][] getData()
	{
		System.out.println("LOG:INFO- Loading test data from data provider");
		return ExcelUtility.getDataFromExcel("login");
	}

	@DataProvider(name="Account")
	public static Object[][] getAccountUsersData()
	{
		return ExcelUtility.getDataFromExcel("account");
	}
	
}
