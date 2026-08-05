package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.EmpMasterPage;
import com.erp.pages.LoginPage;
import com.erp.utilities.Log;

@Test
public class TC11_EmpMasterTestCase extends BaseClass {
	
	public void addPlotMaster() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(getDriver());
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLoginButton();

		EmpMasterPage emp = new EmpMasterPage(getDriver());
				
		emp.clickOnModule();
		Log.info("Click on Module");
		
		emp.Action();
		Log.info("Page is going to Establishment");
		
		emp.Action1();
		Log.info("Page is going to Establishment Details");
		
		emp.clickOnEmpMaster();
		Log.info("Click to Plot Master");
	}
}
