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

public class TC1_LoginTestCase extends BaseClass
{
	LoginPage login;
	@Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginTest() throws IOException, InterruptedException 
    {
		login = new LoginPage(driver);
		
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLoginButton(); 
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Forest Corporation"));
		
		String actualTitle = driver.getTitle().trim();
		System.out.println("Actual Title:-  [" + actualTitle + "]");
		logger.info("Actual Title : " + actualTitle);
			
		Assert.assertTrue(actualTitle.contains("Forest Corporation1"),
	            "Login Failed - Dashboard title not found");

	    logger.info("Login Test Passed");
	}
	
	
}