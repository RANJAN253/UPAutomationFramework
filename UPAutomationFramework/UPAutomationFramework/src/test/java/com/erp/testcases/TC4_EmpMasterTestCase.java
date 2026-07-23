package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.Test;

import com.erp.baseclass.BaseClass;
import com.erp.pages.EmpMasterPage;
import com.erp.pages.LoginPage;
import com.erp.pages.PlotMasterPage;

import junit.framework.Assert;

@Test
public class TC4_EmpMasterTestCase extends BaseClass {
	
	public void addPlotMaster() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLoginButton();

		EmpMasterPage emp = new EmpMasterPage(driver);
		
		
		emp.clickOnModule();
		logger.info("Click on Module");
		
		emp.Action();
		logger.info("Page is going to Establishment");
		
		emp.Action1();
		logger.info("Page is going to Establishment Details");
		
		emp.clickOnEmpMaster();
		logger.info("Click to Plot Master");
		
	
	}

}
