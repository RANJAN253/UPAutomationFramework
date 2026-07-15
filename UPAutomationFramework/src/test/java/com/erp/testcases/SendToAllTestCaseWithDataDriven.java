package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erp.baseclass.BaseClass;
import com.erp.pages.SendToAllPage;
import com.erp.utilities.BReadExcelNew;

public class SendToAllTestCaseWithDataDriven extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws Exception 
	{
		SendToAllPage obj = new SendToAllPage(driver);
		
		obj.setUserName(user);
		Thread.sleep(500);
		logger.info("user name provided");
		
		obj.setPassword(pwd);
		Thread.sleep(500);
		logger.info("password  provided");
		
		obj.clickSubmit();
		Thread.sleep(500);
		
		obj.clickTenduLeaf();
     	Thread.sleep(500);
		
		obj.clickOnTenduCollection();
     	Thread.sleep(500);
     			
		obj.clickOnCalender();
     	Thread.sleep(1000);
     	
     	obj.selectDateM();
     	Thread.sleep(1500);
		
		obj.clickOnPending();
		Thread.sleep(1000);
     	
     
		//obj.Action(); Thread.sleep(1000);
		  
	    //obj.clickOnLogout(); Thread.sleep(1000);
		 
	}
		

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path= "H:/AutomationFramework/UPERPAutomationWithPawan/ReadFromExcel/ForestDetails.xlsx";
		int rownum=BReadExcelNew.getRowCount(path, "Sheet1");
		int colcount=BReadExcelNew.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]= new String[rownum][colcount];
		for(int i=1; i<rownum; i++)
		{
			for(int j=0;j<colcount; j++)
			{
				logindata[i-1][j]= BReadExcelNew.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}