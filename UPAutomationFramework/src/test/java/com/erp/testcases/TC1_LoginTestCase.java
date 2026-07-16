package com.erp.testcases;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.utilities.RetryAnalyzer;
import com.erp.utilities.WaitHelper;

public class TC1_LoginTestCase extends BaseClass
{
	LoginPage loginPage;
    WaitHelper wait;

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class, description = "Verify Login with Valid Credentials")
    public void verifyLogin() {

        logger.info("=========== LOGIN TEST STARTED ===========");

        loginPage = new LoginPage(driver);
        wait = new WaitHelper(driver);

        // Login
        loginPage.loginWith(username, password);
        logger.info("Enter Username & Password : " + username, password);

        // Wait for Dashboard Title
        wait.waitForTitle("Forest Corporation");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Forest Corporation";
        logger.info("Actual Title : " + actualTitle);

        Assert.assertEquals(actualTitle,expectedTitle,"Login Failed - Dashboard Title Mismatch");
        logger.info("Login Successful");

        // Logout
        loginPage.clickLogoutButton();
        logger.info("Logout Successful");
        logger.info("=========== LOGIN TEST COMPLETED ===========");
    }
}