package com.erp.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.utilities.Log;
import com.erp.utilities.RetryAnalyzer;
import com.erp.utilities.WaitHelper;

public class TC1_LoginTestCase extends BaseClass
{
	LoginPage loginPage;
    WaitHelper wait;

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class, description = "Verify Login with Valid Credentials")
    public void verifyLogin() {
    	
    	Log.info("=========== LOGIN TEST STARTED ===========");
    	
    	loginPage = new LoginPage(getDriver());
        wait = new WaitHelper(getDriver());

        // Login ********
        loginPage.loginWith(username, password);
        Log.info("Entered Username : " + username);
       
        // Wait for Dashboard Title
        wait.waitForTitle("Forest Corporation");

        String actualTitle = getDriver().getTitle();
        String expectedTitle = "Forest Corporation";
        
        Log.info("Actual Title : " + actualTitle);
        
        Assert.assertEquals(actualTitle,expectedTitle,"Login Failed - Dashboard Title Mismatch");
        Log.info("Login Successful");

        // Logout
        loginPage.clickLogoutButton();
        
        Log.info("Logout Successful");
        Log.info("=========== LOGIN TEST COMPLETED ===========");
        
        //***
    }
}