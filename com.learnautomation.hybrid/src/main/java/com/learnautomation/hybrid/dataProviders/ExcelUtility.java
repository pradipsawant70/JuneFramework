package com.learnautomation.hybrid.dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static XSSFWorkbook wb;
	
	public static Object[][] getDataFromExcel(String sheetName)
	{
		System.out.println("LOG:INFO- Loading excel");
		
		try 
		{	
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/ApplicationData.xlsx")));
			
		} catch (FileNotFoundException e) {
			
			System.out.println("File does not exists "+e.getMessage());
			
		} catch (IOException e) {
			
			System.out.println("Could not load file "+e.getMessage());
			
		}
		
		int row=wb.getSheet(sheetName).getPhysicalNumberOfRows();
		int column=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
		
		Object[][] arr=new Object[row][column];
		
		for(int i=0; i<row; i++)
		{
			for(int j=0; j<column; j++)
			{
				//arr[i][j]=wb.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
				arr[i][j]=getCellData(sheetName, i, j);
			}
		}
		
		return arr;
	}
	
	public static String getCellData(String sheetName, int row, int col)
	{
		String data = null;
		
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(col);
		
		//sendKeys() accepts only string so we have to convert other datatypes into string
		if(cell.getCellType()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			data=String.valueOf(cell.getNumericCellValue());
		}
		
		else if(cell.getCellType()==CellType.BLANK)
		{
			data="";
		}
		
		return data;
	}
	
}
