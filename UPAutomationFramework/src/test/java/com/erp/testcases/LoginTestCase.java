package com.erp.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.utilities.B_ReadExcel;

/**
 * ============================================================
 *  LOGIN TEST CLASS
 * ============================================================
 *  Extends BaseClass → so we get:
 *    - driver   (WebDriver, already opened by @BeforeClass)
 *    - logger   (for logging messages)
 *    - username, password, baseURL (from config.properties)
 *    - captureScreenshot() method
 *
 *  Tests in this class:
 *  1. loginWithValidCredentials  → Should pass login
 *  2. loginWithInvalidCredentials → Should fail login (negative test)
 *  3. loginWithExcelData          → Data-driven test using Excel
 * ============================================================
 */
public class LoginTestCase extends BaseClass {

    LoginPage loginPage; // Page Object

    // ===========================================================
    //  TEST 1: Login with valid credentials from config.properties
    // ===========================================================
    @Test(priority = 1, description = "Login with valid credentials")
    public void loginWithValidCredentials() throws InterruptedException {

        logger.info("--- TEST: loginWithValidCredentials ---");
        // Step 1: Create LoginPage object (pass driver to it)
        loginPage = new LoginPage(driver);

       loginPage.loginWith("transcend", "123456");
       logger.info("Login attempted with user: " + username);

        // Step 4: Verify we reached the expected page by checking title
        String expectedTitle = "Forest Corporation";
        String actualTitle   = driver.getTitle();

        logger.info("Page title after login: " + actualTitle);

        // Step 5: Assert and capture screenshot on failure
        if (actualTitle.equals(expectedTitle)) {
            logger.info("PASS: Login successful");
            Assert.assertTrue(true);
            loginPage.clickLogoutButton();
            Thread.sleep(2000);
        } else {
            logger.error("FAIL: Expected title '" + expectedTitle + "' but got '" + actualTitle + "'");
            Assert.fail("Login failed — unexpected page title: " + actualTitle);
            // Note: Screenshot is auto-captured by TestListener on failure
        }
    }

    // ===========================================================
    //  TEST 2: Negative test — Login with invalid credentials
    // ===========================================================
    @Test(priority = 2, description = "Login with invalid credentials should fail")
    public void loginWithInvalidCredentials() throws InterruptedException {

        logger.info("--- TEST: loginWithInvalidCredentials ---");

        loginPage = new LoginPage(driver);
        loginPage.loginWith("wrongUser", "wrongPass");
        Thread.sleep(1000);
      }

    // ===========================================================
    //  TEST 3: Data-driven login — reads multiple rows from Excel
    //  @DataProvider feeds multiple username/password pairs
    //  TestNG will run this test once per row of Excel data
    // ===========================================================
    
    @Test(priority = 3, dataProvider = "loginData", description = "Data-driven login test from Excel")
    public void loginWithExcelData(String excelUser, String excelPass) throws InterruptedException {

        logger.info("--- TEST: loginWithExcelData | User: " + excelUser + " ---");

        loginPage = new LoginPage(driver);
        loginPage.loginWith(excelUser, excelPass);
        Thread.sleep(3000);
        
        String title = driver.getTitle();
        logger.info("Title after login: " + title);

        Assert.assertEquals(title, "Forest Corporation",
            "Login failed for user: " + excelUser);

        logger.info("PASS: Data-driven login passed for: " + excelUser);
        loginPage.clickLogoutButton();
    }

    // ─── DataProvider: Reads data from Excel ──────────────────
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        // Reads "LoginSheet" sheet from Excel file
        // Each row = one test run: { username, password }
        return B_ReadExcel.testData("login");
    }
}
