package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.pages.TimberStackMasterPage;
import com.erp.utilities.Log;

public class TC05_TimberStackMasterTestCase extends BaseClass {
	@Test
	public void stackMaster() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(getDriver());
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLoginButton();

		TimberStackMasterPage stack = new TimberStackMasterPage(getDriver());
		stack.selectLocation("Kursi Road Depot Lucknow [Depot]");
	
		Log.info("Selected Location");
		stack.clickonModule();
		stack.clickOnAction();
		stack.clickOnTimberStackMaster();
		stack.selectSpecies("Shisham");
		Thread.sleep(1000);
		stack.selectGrade("I");
		Thread.sleep(1000);
		stack.selectPlot("Shisham");
		Thread.sleep(1000);
		stack.selectSpeciesCat("Bota");
		Thread.sleep(1000);
		stack.selectTimberType("Round");
		Thread.sleep(1000);
		stack.enterStackNo();
		Thread.sleep(1000);
		stack.enterMaxValue("15");
		Thread.sleep(1000);
		stack.selectFromMidGirth("51.00");
		Thread.sleep(1000);
		stack.selectToMidGirth("150.00");
		Thread.sleep(2000);
		stack.selectFromLength("1.25");
		Thread.sleep(2000);
		stack.selectToLength("2.45");
		Thread.sleep(2000);
		stack.clickonCalender();
		Thread.sleep(1000);
		//stack.selectDate();
		//Thread.sleep(1000);
		stack.clickOnSave();
		
		
	

	}
}
	
