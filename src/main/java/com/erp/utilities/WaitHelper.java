package com.erp.utilities;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	// default wait (30 second)
	public WaitHelper(WebDriver driver) {
		this(driver,DEFAULT_TIMEOUT);
	}
	
	//Custom wait
	public WaitHelper(WebDriver driver, int timeout){
		this.driver = driver;
		wait = new WebDriverWait(
				driver,Duration.ofSeconds(timeout)
				);
	}
	
	// =====================================================
    // VISIBILITY
    // =====================================================
	
	//The element is already found as WebElement,
	public WebElement waitForVisibility(WebElement element) {
		return wait.until(
				ExpectedConditions.visibilityOf(element)
				);
	}
	
	// Element is identified using By locator
    public WebElement waitForVisibility(By locator) {
        return wait.until(
        		ExpectedConditions.visibilityOfElementLocated(locator)
        		);
    }
    
    // =====================================================
    // SEND KEYS
    // =====================================================
    
   	public void sendKeys(WebElement element, String value) {
  	    WebElement ele = waitForVisibility(element);
  	    ele.clear();
  	    ele.sendKeys(value);
  	}
  	
  	public void sendKeys(By locator, String value) {
          WebElement ele = waitForVisibility(locator);
          ele.clear();
          ele.sendKeys(value);
    }
  	
  	// =====================================================
    // CLICKABLE
    // =====================================================
      	
	// WebElement version 
	public WebElement waitForClickable(WebElement element) {
	    return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	// Locator version
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
	
    // =========================================================
    // CLICK
    // =========================================================
    
	public void click(WebElement element) {
		waitForClickable(element).click();
	}
	
	public void click(By locator) {
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	    element.click();
	}
	
    // =========================================================
    // INVISIBILITY
    // =========================================================
	
	// Wait for Invisibility-  Waiting for a loading spinner or progress bar to disappear. 
    public void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
	
	// ==========================================================    		
	// SELECT DROPDOWN
	// ==========================================================
    
    public void selectByText(WebElement element, String text) {
        Select select = new Select(waitForClickable(element));
        select.selectByVisibleText(text);
    }
    
    public void selectByText(By locator, String text) {
        Select select = new Select(waitForClickable(locator));
        select.selectByVisibleText(text);
    }

    // ==========================================================    		
 	// TITLE
 	// ==========================================================
    
    public void waitForTitle(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }

    // ==========================================================    		
 	// URL
 	// ==========================================================
    
    public void waitForURL(String url) {
        wait.until(ExpectedConditions.urlContains(url));
    }

    // ==========================================================    		
 	// ALERT
 	// ==========================================================
    
    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    // ==========================================================    		
 	// FRAME
 	// ==========================================================
    public void waitForFrame(String frameName) {
        wait.until(
        		ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName)
        		);
    }
    
    // =====================================================
    // MOUSE HOVER
    // =====================================================
    public  void mouseHover(WebElement element) {
    	Actions actions = new Actions(driver);
    	actions.moveToElement(element).perform();
    }
    
    // =====================================================
    // SCROLL
    // =====================================================
    public void scrollToElement(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            element);
    }
}