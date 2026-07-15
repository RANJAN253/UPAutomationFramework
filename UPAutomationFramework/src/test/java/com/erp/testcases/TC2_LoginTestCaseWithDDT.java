package com.erp.testcases;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.utilities.BReadExcelNew;
import com.erp.utilities.ScreenshotUtility;

public class TC2_LoginTestCaseWithDDT extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd,String status) throws InterruptedException, IOException
	{
		LoginPage login = new LoginPage(driver);
		
		login.enterUsername(user);
		logger.info("username provided");
		
		login.enterPassword(pwd);
		logger.info("password  provided");
		
		login.clickLoginButton();
		Thread.sleep(5000);
			
		String exp_title="Forest Corporation";
		String act_title= driver.getTitle();
		
		if(status.equals("Valid")) {
			if(exp_title.equals(act_title))	{
				Assert.assertTrue(true);
			    login.clickLogoutButton();  // old Server
		     }
			else{
					ScreenshotUtility.captureScreenshot(driver,"loginTestWithDDT");
					Assert.assertTrue(false);
				}
		}
		if(status.equals("Invalid")) {
			if(exp_title.equals(act_title))	{
				//login.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
				Thread.sleep(3000);
			}
		}
		
		
		
		/*
		 * if(isAlertPresent()==true) { driver.switchTo().alert().accept();
		 * driver.switchTo().defaultContent(); Assert.assertTrue(false);
		 * logger.warn("Login Failed"); }
		 * 		 * 
		 * else { Assert.assertTrue(true); logger.info("Login passed");
		 * Thread.sleep(3000); login.clickLogout(); driver.switchTo().alert().accept();
		 * driver.switchTo().defaultContent(); }
		 */
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
	   String path = System.getProperty("user.dir")+ "/src/main/resources/ForestDetails.xlsx";
		
		
		int rownum=BReadExcelNew.getRowCount(path, "login");
		int colcount=BReadExcelNew.getCellCount(path, "login", 1);
		
		String logindata[][]= new String[rownum][colcount];
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0;j<colcount; j++)
			{
				logindata[i-1][j]= BReadExcelNew.getCellData(path, "login", i, j);
			}
		}
		return logindata;
	}
}