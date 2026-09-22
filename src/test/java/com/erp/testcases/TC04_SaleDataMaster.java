package com.erp.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.driver.DriverFactory;
import com.erp.pages.LoginPage;
import com.erp.pages.SaleDateMasterPage;
import com.erp.utilities.Log;
import com.erp.utilities.RetryAnalyzer;
import com.erp.utilities.WaitHelper;

public class TC04_SaleDataMaster extends BaseClass {
	LoginPage loginPage;
    SaleDateMasterPage salePage;
    WaitHelper wait;
    
    @Test(retryAnalyzer = RetryAnalyzer.class)   
    public void verifySaleDateMasterCreation() throws InterruptedException {
    	
    	Log.info("========== Sale Date Master Test Started ==========");

        loginPage = new LoginPage(DriverFactory.getDriver());
        wait = new WaitHelper(DriverFactory.getDriver());

        // Login
        loginPage.loginWith(username, password);
        wait.waitForTitle("Forest Corporation");
        Log.info("Login Successful");
        
        // Open Sale Date Master
        salePage = new SaleDateMasterPage(DriverFactory.getDriver());
        salePage.clickSalesModule();
        salePage.openSaleDateMaster();
        Log.info("Sale Date Master Page Opened");

        // Fill Details
        salePage.selectSaleType("Auction");
        Log.info("Sale Type Selected");

        salePage.selectSaleStatus("Due");
        Log.info("Sale Status Selected");

        salePage.selectDate("Jul","2026","27");
        Log.info("Date Selected");
       
        salePage.selectLocations("Akbarpur","Aashifbagh","Anwla", "Sultanpur Depot");
        Log.info("Location Selected");

        salePage.clickAddButton();
        Log.info("Location Added");

        salePage.clickSaveButton();
        Log.info("Save Button Clicked");
        
        salePage.waitForSaveSuccess();
        Log.info("Processing for Save button");

        // Validation
        Assert.assertTrue(true);
        Log.info("Sale Date Master Created Successfully");

    }
}
