package com.erp.utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	private String excelPath ="D:/AutomationFramework/UPAutomationFramework/src/main/resources/ForestDetails.xlsx";
	
	public ReadFromExcel(String excelPath) {
		this.excelPath = excelPath;
	}
		
	// Get Row Count
	public int getRowCount(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(excelPath);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheet(sheetName);
	    int rows = sheet.getLastRowNum();
	    workbook.close();
	    fis.close();
	    return rows;
	}
	
	// Get Column Count
	public int getColumnCount(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(excelPath);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheet(sheetName);
	    int cols = sheet.getRow(0).getLastCellNum();
	    workbook.close();
	    fis.close();
	    return cols;
	}
	
	// Read Single Cell
	public String getCellData(String sheetName,int rowNum,int colNum) throws IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(colNum);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(cell);
		workbook.close();
		fis.close();
		return data;
	}
	
	// Write Cell
	public void setCellData(String sheetName,  int rowNum, int colNum, String value) throws IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		if (row == null) {
			row = sheet.createRow(rowNum);
		}
		XSSFCell cell = row.getCell(colNum);
		if (cell == null) {
			cell = row.createCell(colNum);
		}
		cell.setCellValue(value);
		fis.close();
		
		FileOutputStream fos = new FileOutputStream(excelPath);
		workbook.write(fos);
		workbook.close();
		fos.close();
	}
	
	// DataProvider Method
	public Object[][] getExcelData(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][cols];
		DataFormatter formatter = new DataFormatter();
		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < cols; j++) {
				data[i - 1][j] =formatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		workbook.close();
        fis.close();
        return data;
	}
	
	
}