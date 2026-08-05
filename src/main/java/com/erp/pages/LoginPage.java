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

    @FindBy(id = "R_txtLogin")
    WebElement txtUsername;

    @FindBy(id = "R_txtPass")
    WebElement txtPassword;

    @FindBy(id = "btnLogin")
    WebElement loginButton;
    
    @FindBy(xpath = "//a[@id='ctl00_lblLoginName']")
    WebElement profileMenu;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement btnLogout;
    
    @FindBy(xpath="//a[normalize-space()='DashBoard']")
    WebElement dashboard;
    
    public void enterUsername(String username) {
        wait.sendKeys(txtUsername, username);
    }

    public void enterPassword(String password) {
        wait.sendKeys(txtPassword, password);
    }

    public void clickLoginButton() {
        wait.click(loginButton);
    }

    public void loginWith(String username, String password) {
    	enterUsername(username);
        enterPassword(password);
    	clickLoginButton();
    }

    public void clickLogoutButton() {
    	//Actions act = new Actions(driver);
    	//act.moveToElement(profileMenu).perform();
    	wait.mouseHover(profileMenu);
    	wait.waitForVisibility(btnLogout);
    	wait.click(btnLogout);
    }
}