package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.ENoteSheetPage;
import com.erp.pages.LoginPage;
import com.erp.utilities.Log;

public class TC9_NoteSheetRecommendation extends BaseClass{
	
	@Test(priority=1,enabled = true)
	public void createE_NoteSheet() throws InterruptedException, IOException {
		Log.info("========== E-Note Sheet Test New Status Page Started ==========");
		
		LoginPage lp = new LoginPage(getDriver());
		//lp.loginWith("ag3.2dsmlko", "123456");
		lp.enterUsername("rmlko");
		lp.enterPassword("123456");
		lp.clickLoginButton();
		Log.info("Login Successful");

		ENoteSheetPage notesheet = new ENoteSheetPage(getDriver());
		
		notesheet.clickOnModule();
		Log.info("click on E-Note sheet");
		
		notesheet.Action();
		notesheet.clickOnNewStatus();
		Log.info("Open on E-Note sheet Status");
		
		notesheet.clickOnView();
		Thread.sleep(10000);
		//System.out.println(getDriver().getPageSource().contains("ctl03_rdAppStatus_4"));
		//System.out.println(getDriver().getCurrentUrl());
		Log.info("click on view Notesheet");
		
		notesheet.selectApprovalAction("recommended");
		Log.info("Select on Recommendation Radio Button");
		
	    notesheet.enterComment("Recommendation  By C RM");
	    Log.info("Comment Entered by RM");
	   
		notesheet.clickOnSubmit();
	    Log.info("Submit Successfully");
	   
	    lp.clickLogoutButton();
	    Log.info("Logout Successful");
	}
}