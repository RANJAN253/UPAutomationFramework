package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.Test;

import com.erp.baseclass.BaseClass;
import com.erp.pages.ENoteSheetPage;
import com.erp.pages.LoginPage;

public class TC6_E_NoteSheetTestCase extends BaseClass {

	@Test(priority=1,enabled = true)
		public void createENoteSheet() throws InterruptedException, IOException {
			LoginPage lp = new LoginPage(driver);
			lp.enterUsername("dsmluc");
			lp.enterPassword("123456");
			lp.clickLoginButton();

			ENoteSheetPage notesheet = new ENoteSheetPage(driver);
			notesheet.clickOnModule();
			notesheet.Action();
			notesheet.clickOnEnoteSheetNew();
			notesheet.selectNoteSheetCategory("Sales");
			Thread.sleep(1000);
			notesheet.selectNoteSheetSubCatagory("GST1");
			Thread.sleep(1000);
			notesheet.enterDocNumber("Doc-17062025");
			Thread.sleep(1000);
			notesheet.enterSubject("Subject ");
			Thread.sleep(1000);
			notesheet.enterDetails("The quick brown fox jumps right over the lazy dog.");
			Thread.sleep(1000);
			notesheet.enterComment("Initiated By DSM");
			Thread.sleep(1000);
			notesheet.clickOnSubmit();
			Thread.sleep(3000);
			notesheet.ActionDsm();
			lp.clickLogoutButton();
		}
		@Test(priority=2)
		public void statusENoteSheet2() throws InterruptedException, IOException {
			LoginPage lp = new LoginPage(driver);
			lp.enterUsername("ag3.2dsmlko");
			Thread.sleep(1000);
			lp.enterPassword("123456");
			lp.clickLoginButton();
			ENoteSheetPage notesheet = new ENoteSheetPage(driver);
			notesheet.clickOnModule();
			notesheet.Action();
			notesheet.clickOnENoteSheetStatus();
			Thread.sleep(1000);
			notesheet.clickonViewNoteSheet();
			Thread.sleep(1000);
			notesheet.clickOnRecOption();
			notesheet.enterComment("Rec By Arun Kumar");
			Thread.sleep(1000);
			notesheet.clickOnSubmit();
			Thread.sleep(3000);
			notesheet.ActionAcc();
			lp.clickLogoutButton();
		}
		
		@Test(priority=3, enabled = false)
		public void statusENoteSheet3() throws InterruptedException, IOException {
			LoginPage lp = new LoginPage(driver);
			lp.enterUsername("cao");
			Thread.sleep(1000);
			lp.enterPassword("123456");
			lp.clickLoginButton();

			ENoteSheetPage notesheet = new ENoteSheetPage(driver);
			
			notesheet.clickOnModule();
			notesheet.Action();
			notesheet.clickOnENoteSheetStatus();
			Thread.sleep(1000);
			notesheet.clickonViewNoteSheet();
			Thread.sleep(1000);
			notesheet.clickOnRecOption();
			
			notesheet.enterComment("Rec By CAO");
			Thread.sleep(1000);
			notesheet.clickOnSubmit();
			Thread.sleep(3000);
			notesheet.ActionAcc();
			lp.clickLogoutButton();
		}
		
		@Test(priority=4, enabled = false)
		public void statusENoteSheet4() throws InterruptedException, IOException {
			LoginPage lp = new LoginPage(driver);
			lp.enterUsername("rmlko");
			Thread.sleep(1000);
			lp.enterPassword("123456");
			lp.clickLoginButton();

			ENoteSheetPage notesheet = new ENoteSheetPage(driver);
			
			notesheet.clickOnModule();
			notesheet.Action();
			notesheet.clickOnENoteSheetStatus();
			Thread.sleep(1000);
			notesheet.clickonViewNoteSheet();
			Thread.sleep(1000);
			notesheet.clickOnRecOption();
			
			notesheet.enterComment("Rec By RM lucknow");
			Thread.sleep(1000);
			notesheet.clickOnSubmit();
			Thread.sleep(3000);
			notesheet.ActionAcc();
			lp.clickLogoutButton();
		}
		
		@Test(priority=5, enabled = false)
		public void statusENoteSheet5() throws InterruptedException, IOException {
			LoginPage lp = new LoginPage(driver);
			lp.enterUsername("gmsale");
			Thread.sleep(1000);
			lp.enterPassword("123456");
			lp.clickLoginButton();

			ENoteSheetPage notesheet = new ENoteSheetPage(driver);
			
			notesheet.clickOnModule();
			notesheet.Action();
			notesheet.clickOnENoteSheetStatus();
			Thread.sleep(1000);
			notesheet.clickonViewNoteSheet();
			Thread.sleep(1000);
			notesheet.clickOnRecOption();
			
			notesheet.enterComment("Rec By Accountant Kamlesh");
			Thread.sleep(1000);
			notesheet.clickOnSubmit();
			Thread.sleep(3000);
			notesheet.ActionAcc();
			lp.clickLogoutButton();
		}
		
		@Test(priority=6, enabled = false)
		public void statusENoteSheet6() throws InterruptedException, IOException {
			LoginPage lp = new LoginPage(driver);
			lp.enterUsername("ag3.2dsmlko");
			Thread.sleep(1000);
			lp.enterPassword("123456");
			lp.clickLoginButton();

			ENoteSheetPage notesheet = new ENoteSheetPage(driver);
			
			notesheet.clickOnModule();
			notesheet.Action();
			notesheet.clickOnENoteSheetStatus();
			Thread.sleep(1000);
			notesheet.clickonViewNoteSheet();
			Thread.sleep(1000);
			notesheet.clickOnRecOption();
			
			notesheet.enterComment("Rec By Accountant Kamlesh");
			Thread.sleep(1000);
			notesheet.clickOnSubmit();
			Thread.sleep(3000);
			notesheet.ActionAcc();
			lp.clickLogoutButton();
		}
		
		
}
//span[@id='ctl00_ContentPlaceHolder1_dgPending_ctl01_lblgrdView']
//a[@id='ctl00_ContentPlaceHolder1_dgPending_ctl02_lnkView']//img
//a[@id='ctl00_ContentPlaceHolder1_dgPending_ctl03_lnkView']//img
