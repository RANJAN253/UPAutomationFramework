package com.erp.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.driver.DriverFactory;
import com.erp.pages.LoginPage;
import com.erp.utilities.Log;
import com.erp.utilities.RetryAnalyzer;
import com.erp.utilities.WaitHelper;

public class TC01_LoginTestCase extends BaseClass
{
	LoginPage loginPage;
    WaitHelper wait;

    @Test(groups= {"Smoke"}, priority = 1, retryAnalyzer = RetryAnalyzer.class, description = "Verify Login with Valid Credentials")
    public void verifyLogin() {
    	
    	Log.info("=========== LOGIN TEST STARTED ===========");
    	
    	loginPage = new LoginPage(DriverFactory.getDriver());
        wait = new WaitHelper(DriverFactory.getDriver());

        loginPage.loginWith(username, password);
        Log.info("Entered Username : " + username);
       
        // Wait for Dashboard Title
        wait.waitForTitle("Forest Corporation");

        String actualTitle = DriverFactory.getDriver().getTitle();
        String expectedTitle = "Forest Corporation";
        
        Log.info("Actual Title : " + actualTitle);
        
        Assert.assertEquals(actualTitle,expectedTitle,"Login Failed");
        Log.info("Login Successful");

        // Logout
        loginPage.clickLogoutButton();
        
        Log.info("Logout Successful");
        Log.info("=========== LOGIN TEST COMPLETED ===========");
        
        //***
    }
}