package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.ENoteSheetPage;
import com.erp.pages.LoginPage;
import com.erp.utilities.Log;

public class TC06_NoteSheetCreation extends BaseClass {

	@Test(priority=1)
	public void createE_NoteSheet() throws InterruptedException, IOException {
		
		Log.info("========== E-Note Sheet Created ==========");
		
		LoginPage lp = new LoginPage(getDriver());
		lp.enterUsername("dsmluc");
		lp.enterPassword("123456");
		lp.clickLoginButton();
		Log.info("Login Successful");

		ENoteSheetPage notesheet = new ENoteSheetPage(getDriver());
		notesheet.clickOnModule();
		Log.info("click on E-Note sheet Module");
		
		notesheet.Action();
		notesheet.clickOnEnoteSheetNew();
		Log.info("Open on E-Note sheet New");
		
		notesheet.selectNoteSheetCategory("Sales");
		Thread.sleep(1500);
		Log.info("Select Category");
				
		notesheet.selectNoteSheetSubCatagory("GST1");
		Thread.sleep(1500);
		Log.info("Select Sub Category");
				
		notesheet.enterDocNumber("Doc-05082026");
		Log.info("Enter Document Number");
		Thread.sleep(1500);
		
		notesheet.enterSubject("Subject the application ");
		Thread.sleep(1500);
		Log.info("Enter the Subject");
				
		notesheet.enterDetails("The quick brown fox jumps right over the lazy dog.The quick brown fox jumps right over the lazy dog.The quick brown fox jumps right over the lazy dog.");
		Thread.sleep(1500);
		Log.info("Enter Note Sheet Details");
		
		notesheet.enterComment("Initiated By DSM");
		Thread.sleep(2000);
		Log.info("Enter Commit");
		
		String filePath = System.getProperty("user.dir") + "\\TestData\\Train_Ticket(Ajay).pdf";
		notesheet.uploadFile(filePath);
		Thread.sleep(2000);
		Log.info("File Upload Successfully");
				
		notesheet.clickAddButton();
		Thread.sleep(5000);
		Log.info("File Add Successfully");
					
		notesheet.clickOnSubmit();
		Thread.sleep(5000);
		Log.info("Note Sheet Submit Successfully");
		
		lp.clickLogoutButton();
		Log.info("Note Sheet Logout Successfully");
	}
	
	@Test(priority=2)
    public void recommendedE_NoteSheet() throws InterruptedException, IOException {
		Log.info("========== E- Note Sheet Recommendation By Accountant ==========");
		
		LoginPage lp = new LoginPage(getDriver());
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
		Thread.sleep(3000);
		Log.info("click on view Notesheet");
			
		notesheet.selectApprovalAction("recommended");
		Thread.sleep(5000);
		Log.info("Recommended Selected");
		
		notesheet.enterComment("Recommended By AG");
		Thread.sleep(5000);
		Log.info("Comment Entered");
		
		notesheet.clickOnSubmit();
		Thread.sleep(5000);
		Log.info("Recommendation Successful");
		
		lp.clickLogoutButton();
		Log.info("Logout Successful");
	}
}