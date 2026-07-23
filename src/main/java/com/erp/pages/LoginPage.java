package com.erp.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.utilities.Log;
import com.erp.utilities.WaitHelper;

public class LoginPage {

    WebDriver driver;
    WaitHelper wait;
    Log log;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitHelper(driver);
    }

    // Username
    @FindBy(id = "R_txtLogin")
    WebElement txtUsername;

    // Password
    @FindBy(id = "R_txtPass")
    WebElement txtPassword;

    // Login Button
    @FindBy(id = "btnLogin")
    WebElement loginButton;
    
    @FindBy(xpath = "//a[@id='ctl00_lblLoginName']")
    WebElement profileMenu;

    // Logout Button (Change locator according to ERP)
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement btnLogout;
    
    @FindBy(xpath="//a[normalize-space()='DashBoard']")
    WebElement dashboard;
    
    // Enter Username
    public void enterUsername(String username) {
        wait.sendKeys(txtUsername, username);
    }

    // Enter Password
    public void enterPassword(String password) {
        wait.sendKeys(txtPassword, password);
    }

    // Click Login
    public void clickLoginButton() {
        wait.click(loginButton);
    }

    // Complete Login
    public void loginWith(String username, String password) {
    	
    	Log.info("Entering Username");
        enterUsername(username);
        
        Log.info("Entering Password");
        enterPassword(password);
        
        Log.info("Clicking Login Button");
        clickLoginButton();
        
        Log.info("Logout Successfully");
    }

    // Logout
    public void clickLogoutButton() {
    	 //Actions act = new Actions(driver);
    	 //act.moveToElement(profileMenu).perform();
    	 wait.mouseHover(profileMenu);
    	 wait.waitForVisibility(btnLogout);
    	 wait.click(btnLogout);
    	 
    	 Log.info("Clicking Login Button");
    
    }
}