package com.erp.utilities;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class WaitHelper {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private static final int DEFAULT_TIMEOUT =30;
	
	// default wait (20 second)
	public WaitHelper(WebDriver driver) {
		this(driver,DEFAULT_TIMEOUT);
	}
	
	//Custom wait
	public WaitHelper(WebDriver driver, int timeout){
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
	}
	
	// wait for visibility
	public WebElement waitForVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	// wait for clickable
	public WebElement waitForClickable(WebElement element) {
	    return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	// click
	public void click(WebElement element) {
		waitForClickable(element).click();
	}
	
	//click
	public void click(By locator) {
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	    element.click();
	}
	
	//send keys
	public void sendKeys(WebElement element, String value) {
	    WebElement ele = waitForVisibility(element);
	    ele.clear();
	    ele.sendKeys(value);
	}
	    		
	// Select Dropdown
    public void selectByText(WebElement element, String text) {
        Select select = new Select(waitForClickable(element));
        select.selectByVisibleText(text);
    }

    // Wait for Title
    public void waitForTitle(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }

    // Wait for URL
    public void waitForURL(String url) {
        wait.until(ExpectedConditions.urlContains(url));
    }

    // Wait for Alert
    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    // Wait for Invisibility
    public void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // Wait for Frame
    public void waitForFrame(String frameName) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
    }
    
    public  void mouseHover(WebElement element) {
    	Actions actions = new Actions(driver);
    	actions.moveToElement(element).perform();
    }
}