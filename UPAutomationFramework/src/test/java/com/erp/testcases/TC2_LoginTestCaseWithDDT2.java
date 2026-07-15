package com.erp.testcases;
import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.utilities.BReadExcelNew;

import org.testng.Assert;

public class TC2_LoginTestCaseWithDDT2 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void verifyloginWithDDT(String user, String pwd,String exp) throws InterruptedException, IOException
	{
		LoginPage login = new LoginPage(driver);
		
		login.enterUsername(user);
		logger.info("username provided");
		
		login.enterPassword(pwd);
		
		logger.info("password  provided");
		login.clickLoginButton();
		Thread.sleep(3000);
		
		boolean status = login.isDashboardVisible(); // create this method

	    if(exp.equals("valid")) {
	        if(status) {
	            Assert.assertTrue(true);
	            login.clickLogoutButton();;
	        } else {
	            Assert.fail();
	        }
	    }
	    else if(exp.equals("invalid")) {
	        if(!status) {
	            Assert.assertTrue(true);
	        } else {
	            //login.clickOnddlLogoutBtn();
	            Assert.fail();
	        }
	    }
	}
	
	public boolean isAlertPresent()
	{
		try	{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path= "D:\\AutomationFramework\\UPERPAutomationWithPawan\\ReadFromExcel\\ForestDetails.xlsx";
		int rownum=BReadExcelNew.getRowCount(path, "login2");
		int colcount=BReadExcelNew.getCellCount(path, "login2", 1);
		
		String logindata[][]= new String[rownum][colcount];
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0;j<colcount; j++)
			{
				logindata[i-1][j]= BReadExcelNew.getCellData(path, "login2", i, j);
			}
		}
		return logindata;
	}
}