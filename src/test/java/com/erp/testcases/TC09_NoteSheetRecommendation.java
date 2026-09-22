package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.driver.DriverFactory;
import com.erp.pages.ENoteSheetPage;
import com.erp.pages.LoginPage;
import com.erp.utilities.Log;
public class TC09_NoteSheetRecommendation extends BaseClass{
	@Test
	public void recommended_E_NoteSheet() throws InterruptedException, IOException {
		Log.info("========== E-Note Sheet Test New Status Page Started ==========");
		
		LoginPage lp = new LoginPage(DriverFactory.getDriver());
		//lp.loginWith("ag3.2dsmlko", "123456");
		lp.enterUsername("rmlko");
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
		Thread.sleep(10000);
		Log.info("click on view Notesheet");
		
		notesheet.selectApprovalAction("recommended");
		Thread.sleep(2000);	
		Log.info("Select on Recommendation Radio Button");
		
	    notesheet.enterComment("Recommendation  By  RM");
	    Thread.sleep(1000);
	    Log.info("Comment Entered by RM");
	   
		notesheet.clickOnSubmit();
	    Log.info("Submit Successfully");
	   
	    lp.clickLogoutButton();
	    Log.info("Logout Successful");
	}
}