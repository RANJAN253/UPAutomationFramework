package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erp.baseclass.BaseClass;
import com.erp.pages.ServicePage;
import com.erp.utilities.BReadExcelNew;

public class ServiceTestCase extends BaseClass {
	@Test(dataProvider="LoginData")
	public void loginDDT(String token, String po_Id) throws InterruptedException, IOException
	{
		ServicePage login = new ServicePage(driver);
		
		login.enterUserName(token);
		logger.info("username provided");
		Thread.sleep(500);
		
		login.enterPassword(po_Id);
		Thread.sleep(500);
		logger.info("password  provided");
		
		//login.clickOnLoginBtn();
		Thread.sleep(4000);
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path= "C:/Users/ranjantiplin/AutomationFramework/UPERPAutomationWithPawan/ReadFromExcel/ForestDetails.xlsx";
		int rownum=BReadExcelNew.getRowCount(path, "Sheet2");
		int colcount=BReadExcelNew.getCellCount(path, "Sheet2", 1);
		
		String logindata[][]= new String[rownum][colcount];
		for(int i=1; i<rownum; i++)
		{
			for(int j=0;j<colcount; j++)
			{
				logindata[i-1][j]= BReadExcelNew.getCellData(path, "Sheet2", i, j);
			}
		}
		return logindata;
	}

}
