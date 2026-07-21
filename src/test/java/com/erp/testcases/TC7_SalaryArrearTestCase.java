package com.erp.testcases;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.pages.SalaryArrearPages;
import com.erp.utilities.RetryAnalyzer;
import com.erp.utilities.WaitHelper;

public class TC7_SalaryArrearTestCase extends BaseClass {
	LoginPage loginPage;
	SalaryArrearPages salarrear;
    WaitHelper wait;
    
    @Test(retryAnalyzer = RetryAnalyzer.class)   
    public void verifySalaryArrearEntry() throws InterruptedException {
    	
        logger.info("========== Salary Arrear Test Started ==========");

        loginPage = new LoginPage(driver);
        wait = new WaitHelper(driver);

        // Login
        loginPage.loginWith(username, password);
        wait.waitForTitle("Forest Corporation");
        logger.info("Login Successful");
        
        // Open Salary Arrear Page
        salarrear = new SalaryArrearPages(driver);
        salarrear.clickPersonelModule();
        salarrear.openSalaryArrear();
        logger.info("Salary Arrear Master Page Opened");
       
        // Fill Details
        salarrear.selectEmp("A.K.Dwivedi (0)");
        logger.info("Employee Selected");
        
        salarrear.selectMonth("MARCH");
        logger.info("Month Selected");

        salarrear.selectYear("2026");
        logger.info("Year Selected");
       
     
    }
}
       

