package com.erp.utilities;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class B_ReadExcel 
{
	public static Object[][] testData(String sheetName) throws IOException
	
	{
		FileInputStream  fis = new FileInputStream("D:\\AutomationFramework\\UPERPAutomationWithPawan\\ReadFromExcel\\ForestDetails.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//XSSFSheet sheet = wb.getSheetAt(0);   // for index sheet  case
			
		int rowcount = sheet.getLastRowNum();     //System.out.println(sheet.getLastRowNum());
	    System.out.println(rowcount);
		     
		int colcount = sheet.getRow(0).getLastCellNum();   //System.out.println(sheet.getRow(0).getLastCellNum());
		System.out.println(colcount);
						
		String [][] data = new String[ rowcount][colcount];
		
		 // IMPORTANT
        DataFormatter formatter = new DataFormatter();
		
		for(int i=0; i<rowcount; i++)
		{
			for(int j=0; j<colcount; j++)
			{
			   // data [i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			   // System.out.println(data[i][j]);
			    
			    data[i][j] = formatter.formatCellValue(sheet.getRow(i+1).getCell(j));
			    System.out.println(data[i][j]);
			}
		}
		
		workbook.close();
		fis.close();
		
		return data;
			
		
	}
	

}
