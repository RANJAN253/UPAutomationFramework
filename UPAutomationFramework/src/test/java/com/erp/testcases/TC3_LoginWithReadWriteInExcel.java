package com.erp.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.utilities.Log;
import com.erp.utilities.ReadFromExcel;
import com.erp.utilities.RetryAnalyzer;
import com.erp.utilities.WaitHelper;
public class TC3_LoginWithReadWriteInExcel extends BaseClass {
	
	LoginPage loginPage;
	WaitHelper wait;
	String path = System.getProperty("user.dir") + "/src/main/resources/ForestDetails.xlsx";
	
	@Test(dataProvider = "LoginData", retryAnalyzer = RetryAnalyzer.class)
	public void verifyLoginDDT(String username, String password, String status, int rowNo) throws Exception {
		loginPage = new LoginPage(getDriver());
	    wait = new WaitHelper(getDriver());
        Log.info("Executing Row : " + rowNo);
        loginPage.loginWith(username, password);
        boolean loginSuccess = false;
        try {
        	wait.waitForTitle("Forest Corporation");
        	if(getDriver().getTitle().contains("Forest Corporation")) {
        		loginSuccess = true;
        	}
        }catch(Exception e) {
        	loginSuccess = false;
        }
        
        ReadFromExcel excel = new ReadFromExcel(path);
        // VALID USER
	    if(status.equalsIgnoreCase("Valid"))
	    	{
	    	if(loginSuccess) {
	    		excel.setCellData("login2", rowNo, 3, "Pass");
	    		Log.info("Valid Login Passed");
	    		loginPage.clickLogoutButton();
	    		Assert.assertTrue(true);
	    		}
	            else
	            {
	            	excel.setCellData("login2", rowNo, 3, "Failed");
	            	Assert.fail("Valid Login Failed");
	            }
	    	}
	    // INVALID USER
	    else if(status.equalsIgnoreCase("Invalid"))
	    	{
	    	if(loginSuccess)
	    		{
	    		excel.setCellData("login2", rowNo, 3, "Failed");
	    		loginPage.clickLogoutButton();
	    		Assert.fail("Invalid Login Passed");
	    		}
	            else
	            {
	            	excel.setCellData("login2", rowNo, 3, "Pass");
	            	Log.info("Invalid Login Passed");
	            	Assert.assertTrue(true);
	            }
	    	}
	}
	
	@DataProvider(name="LoginData")
	public Object[][] getData() throws IOException {
		ReadFromExcel excel = new ReadFromExcel(path);
        Object[][] data = excel.getExcelData("login2");
        Object[][] finalData = new Object[data.length][4];
        for(int i=0;i<data.length;i++)
        	{
        	finalData[i][0]=data[i][0];
	        finalData[i][1]=data[i][1];
	        finalData[i][2]=data[i][2];
	        finalData[i][3]=i+1;      // Excel Row Number
        	}
        return finalData;
	}
}
