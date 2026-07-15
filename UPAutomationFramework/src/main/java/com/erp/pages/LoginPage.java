 package com.erp.pages;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    // ─── Constructor ───────────────────────────────────────────
    // PageFactory.initElements() maps @FindBy annotations to actual elements
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ─── Web Elements (Page Locators) ──────────────────────────
    // @FindBy    → How to find the element (id, name, xpath, css)
    // @CacheLookup → Cache element after first find (faster, use for static elements)

    @FindBy(name = "R_txtLogin")
    @CacheLookup
    private WebElement usernameField;

    @FindBy(id = "R_txtPass")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(id = "btnLogin")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;
    
    @FindBy(xpath = "//a[@id='ctl00_lblLoginName']")
    WebElement profileMenu;
    
    @FindBy(xpath="//a[normalize-space()='DashBoard']")
    WebElement dashboard;

    // ─── Page Actions (Methods used in Test Classes) ───────────
    public void enterUsername(String username) throws InterruptedException {
        usernameField.clear();
        usernameField.sendKeys(username);
      }

    public void enterPassword(String password) throws InterruptedException {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    
    public void clickLoginButton() throws InterruptedException {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
    	wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        
           wait.until(ExpectedConditions.visibilityOf(dashboard));
    }

     public void clickLogoutButton() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Step 1: Hover on profile
        Actions actions = new Actions(driver);
        actions.moveToElement(profileMenu).perform();
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }

    public void loginWith(String username, String password) throws InterruptedException {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        Thread.sleep(2000);
    }
    
    public boolean isDashboardVisible() {

        try {

            return dashboard.isDisplayed();

        } catch(Exception e) {

            return false;
        }
    }
}