package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.driver.DriverFactory;
import com.erp.pages.ENoteSheetPage;
import com.erp.pages.LoginPage;
import com.erp.utilities.Log;

public class TC08_NoteSheetConsent extends BaseClass{
	
	@Test(priority=1,enabled = true)
	public void consentE_NoteSheet() throws InterruptedException, IOException {
		Log.info("========== E-Note Sheet Test Consent ==========");
		
		LoginPage lp = new LoginPage(DriverFactory.getDriver());
		
		lp.enterUsername("cao");
		lp.enterPassword("123456");
		lp.clickLoginButton();
		Log.info("Login Successful");

		ENoteSheetPage notesheet = new ENoteSheetPage(DriverFactory.getDriver());
		
		notesheet.clickOnModule();
		Log.info("click on E-Note sheet");
		
		notesheet.Action();
		notesheet.clickOnNewStatus();
		Log.info("Open on E-Note sheet Status");
		
		notesheet.clickOnView();
		Thread.sleep(5000);
		//System.out.println(getDriver().getPageSource().contains("ctl03_rdAppStatus_4"));
		//System.out.println(getDriver().getCurrentUrl());
		Log.info("click on view Notesheet");
		
		notesheet.selectApprovalAction("consent");
		Log.info("Click on Consent Radio Button");
		
	    notesheet.enterComment("Consent By CAO");
	    Log.info("Comment Entered by CAO");
	   
		notesheet.clickOnSubmit();
	    Log.info("Submit Successfully");
	   
	    lp.clickLogoutButton();
	    Log.info("Logout Successful");
	}
}