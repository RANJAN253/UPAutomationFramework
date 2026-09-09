package com.erp.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.utilities.B_ReadExcel;
import com.erp.utilities.Log;
import com.erp.utilities.RetryAnalyzer;
import com.erp.utilities.WaitHelper;

public class TC02_LoginWithDataDriven extends BaseClass{
	
	 LoginPage loginPage;
	 WaitHelper wait;

	    @Test(dataProvider = "LoginData",retryAnalyzer = RetryAnalyzer.class)
	    public void verifyLoginDDT(String user, String pass) {

	    	loginPage = new LoginPage(getDriver());
	        wait = new WaitHelper(getDriver());
	        Log.info("Executing User : " + user);

	        loginPage.loginWith(user, pass);
	        wait.waitForTitle("Forest Corporation");

	        String actualTitle = getDriver().getTitle();

	        Assert.assertEquals(actualTitle, "Forest Corporation", "Login Failed for : " + user);

	        Log.info("Login Successful : " + user);
	        loginPage.clickLogoutButton();
	    }

	    @DataProvider(name = "LoginData")
	    public Object[][] getData() throws IOException {

	        return B_ReadExcel.testData("login");

	    }
}