package com.erp.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.utilities.B_ReadExcel;
import com.erp.utilities.RetryAnalyzer;
import com.erp.utilities.WaitHelper;

public class TC2_LoginWithDataDriven extends BaseClass{
	
	 LoginPage loginPage;
	 WaitHelper wait;

	    @Test(dataProvider = "LoginData", retryAnalyzer = RetryAnalyzer.class)
	    public void verifyLoginDDT(String user, String pass) {

	        loginPage = new LoginPage(driver);
	        wait = new WaitHelper(driver);
	        logger.info("Executing User : " + user);

	        loginPage.loginWith(user, pass);
	        wait.waitForTitle("Forest Corporation");

	        String actualTitle = driver.getTitle();

	        Assert.assertEquals(actualTitle, "Forest Corporation", "Login Failed for : " + user);

	        logger.info("Login Successful : " + user);
	        loginPage.clickLogoutButton();
	    }

	    @DataProvider(name = "LoginData")
	    public Object[][] getData() throws IOException {

	        return B_ReadExcel.testData("login");

	    }
}