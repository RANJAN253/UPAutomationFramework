package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.ENoteSheetPage;
import com.erp.pages.LoginPage;
import com.erp.utilities.Log;

public class TC06_NoteSheetCreation extends BaseClass {

	@Test
	public void createE_NoteSheet() throws InterruptedException, IOException {
		Log.info("========== E-Note Sheet Created ==========");
		
		LoginPage lp = new LoginPage(getDriver());
		lp.enterUsername("dsmluc");
		lp.enterPassword("123456");
		lp.clickLoginButton();
		Log.info("Login Successful");

		ENoteSheetPage notesheet = new ENoteSheetPage(getDriver());
		
		notesheet.clickOnModule();
		Log.info("click on E-Note sheet");
		
		notesheet.Action();
		notesheet.clickOnEnoteSheetNew();
		Log.info("Open on E-Note sheet");
		
		notesheet.selectNoteSheetCategory("Sales");
		Log.info("Select Category");
		Thread.sleep(1000);
		
		notesheet.selectNoteSheetSubCatagory("GST1");
		Log.info("Select Sub Category");
		Thread.sleep(1000);
		
		notesheet.enterDocNumber("Doc-05082026");
		Log.info("Enter Document Number");
		Thread.sleep(1000);
		
		notesheet.enterSubject("Subject the application ");
		Log.info("Enter the Subject");
		Thread.sleep(1000);
		
		notesheet.enterDetails("The quick brown fox jumps right over the lazy dog.");
		Log.info("Enter Note Sheet Details");
		Thread.sleep(1000);
		
		notesheet.enterComment("Initiated By DSM");
		Log.info("Enter Commit");
		Thread.sleep(2000);
		
		String filePath = System.getProperty("user.dir") + "\\TestData\\Train_Ticket(Ajay).pdf";
		notesheet.uploadFile(filePath);
		Log.info("File Upload Successfully");
		Thread.sleep(2000);
		
		notesheet.clickAddButton();
		Log.info("File Add Successfully");
		Thread.sleep(5000);
			
		notesheet.clickOnSubmit();
		Thread.sleep(5000);
		Log.info("Note Sheet Submit Successfully");
	}
}
