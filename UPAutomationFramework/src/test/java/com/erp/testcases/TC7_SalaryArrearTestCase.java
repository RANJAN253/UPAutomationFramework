package com.erp.testcases;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.pages.SalaryArrearPages;
import com.erp.utilities.Log;
import com.erp.utilities.RetryAnalyzer;
import com.erp.utilities.WaitHelper;

public class TC7_SalaryArrearTestCase extends BaseClass {
	LoginPage loginPage;
	SalaryArrearPages salarrear;
    WaitHelper wait;
    
    @Test(retryAnalyzer = RetryAnalyzer.class)   
    public void verifySalaryArrearEntry() throws InterruptedException {
    	
    	Log.info("========== Salary Arrear Test Started ==========");

        loginPage = new LoginPage(getDriver());
        wait = new WaitHelper(getDriver());

        // Login
        loginPage.loginWith(username, password);
        wait.waitForTitle("Forest Corporation");
        Log.info("Login Successful");
        
        // Open Salary Arrear Page
        salarrear = new SalaryArrearPages(getDriver());
        salarrear.clickPersonelModule();
        salarrear.openSalaryArrear();
        Log.info("Salary Arrear Master Page Opened");
       
        // Fill Details
        salarrear.selectEmp("A.K.Dwivedi (0)");
        Log.info("Employee Selected");
        
        salarrear.selectMonth("MARCH");
        Log.info("Month Selected");

        salarrear.selectYear("2026");
        Log.info("Year Selected");
    }
}
