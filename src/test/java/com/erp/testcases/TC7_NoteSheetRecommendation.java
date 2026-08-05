package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.ENoteSheetPage;
import com.erp.pages.LoginPage;
import com.erp.utilities.Log;

public class TC7_NoteSheetRecommendation extends BaseClass{
	
	@Test(priority=1,enabled = true)
	public void createE_NoteSheet() throws InterruptedException, IOException {
		Log.info("========== E- Note Sheet Recommendation Started ==========");
		
		LoginPage lp = new LoginPage(getDriver());
		//lp.loginWith("ag3.2dsmlko", "123456");
		lp.enterUsername("ag3.2dsmlko");
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
		Log.info("click on view Notesheet");
		Thread.sleep(3000);
		
		notesheet.selectApprovalAction("recommended");
		Log.info("Recommended Selected");
		Thread.sleep(5000);

	    notesheet.enterComment("Recommended By AG");
	    Log.info("Comment Entered");
	    Thread.sleep(5000);

		notesheet.clickOnSubmit();
	    Log.info("Recommendation Successful");
	    Thread.sleep(10000);

	    lp.clickLogoutButton();
	    Log.info("Logout Successful");
		
		
		
	}
}
