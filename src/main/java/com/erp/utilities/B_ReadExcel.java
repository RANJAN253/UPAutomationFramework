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
		String filepath = System.getProperty("user.dir") + "/src/main/resources/ForestDetails.xlsx";
		FileInputStream  fis = new FileInputStream("filePath");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		if (sheet == null) {
			workbook.close();
			fis.close();
			
			throw new IllegalArgumentException("Sheet not found: " + sheetName);
		}
		
		// ======================================================
		// ROW & COLUMN COUNT 
		// ======================================================
			
		int rowcount = sheet.getLastRowNum();     
	    System.out.println("Total Rows : " + rowcount);
		     
		int colcount = sheet.getRow(0).getLastCellNum();  
		System.out.println("Total Rows : " + colcount);
		
		// ======================================================
		// DATA ARRAY
		// ======================================================
						
		String [][] data = new String[ rowcount][colcount];
		
		// IMPORTANT
        DataFormatter formatter = new DataFormatter();
        
        // ======================================================
        // READ EXCEL DATA 
        // ======================================================
		
		for(int i=0; i<rowcount; i++)
		{
			for(int j=0; j<colcount; j++)
			{
			   data[i][j] = formatter.formatCellValue(sheet.getRow(i+1).getCell(j)).trim();
			   System.out.println("Row" + (i+1) + " Column" + j + " = " + data[i][j]);
			}
		}
		
		// ====================================================== 
		// CLOSE 
		// ======================================================
		
		workbook.close();
		fis.close();
		return data;
	}
}