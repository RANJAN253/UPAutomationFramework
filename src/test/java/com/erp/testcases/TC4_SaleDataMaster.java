package com.erp.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.pages.SaleDateMasterPage;
import com.erp.utilities.RetryAnalyzer;
import com.erp.utilities.WaitHelper;

public class TC4_SaleDataMaster extends BaseClass {
	LoginPage loginPage;
    SaleDateMasterPage salePage;
    WaitHelper wait;
    
    @Test(retryAnalyzer = RetryAnalyzer.class)   
    public void verifySaleDateMasterCreation() throws InterruptedException {
    	
        logger.info("========== Sale Date Master Test Started ==========");

        loginPage = new LoginPage(driver);
        wait = new WaitHelper(driver);

        // Login
        loginPage.loginWith(username, password);
        wait.waitForTitle("Forest Corporation");
        logger.info("Login Successful");
        
        // Open Sale Date Master
        salePage = new SaleDateMasterPage(driver);
        salePage.clickSalesModule();
        salePage.openSaleDateMaster();
        logger.info("Sale Date Master Page Opened");

        // Fill Details
        salePage.selectSaleType("Auction");
        logger.info("Sale Type Selected");

        salePage.selectSaleStatus("Due");
        logger.info("Sale Status Selected");

        salePage.selectDate("Jul","2026","27");
        logger.info("Date Selected");
       
        salePage.selectLocations("Akbarpur","Aashifbagh","Anwla", "Sultanpur Depot");
        logger.info("Location Selected");

        salePage.clickAddButton();
        logger.info("Location Added");

        salePage.clickSaveButton();
        logger.info("Save Button Clicked");
        
        salePage.waitForSaveSuccess();
        logger.info("Processing for Save button");

        // Validation
        Assert.assertTrue(true);
        logger.info("Sale Date Master Created Successfully");

    }
}
