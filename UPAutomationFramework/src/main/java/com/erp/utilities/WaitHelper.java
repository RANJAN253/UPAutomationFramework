package com.erp.utilities;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public WaitHelper(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	public void waitForVisibility(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void click(WebElement element) {

	    wait.until(ExpectedConditions.elementToBeClickable(element));

	    element.click();
	}
	
	public void sendKeys(WebElement element, String value) {
	    wait.until(ExpectedConditions.visibilityOf(element));
	    element.clear();
	    element.sendKeys(value);
	}
	
	public void selectByText(WebElement element, String text) {

	    WebElement dropdown = wait.until(
	            ExpectedConditions.elementToBeClickable(element));

	    Select select = new Select(dropdown);

	    select.selectByVisibleText(text);
	}
}