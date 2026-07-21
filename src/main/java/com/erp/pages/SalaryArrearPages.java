package com.erp.pages;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.erp.baseclass.BaseClass;
import com.erp.utilities.WaitHelper;

public class SalaryArrearPages extends BaseClass {
	
	 WebDriver driver;
	 WaitHelper wait;
	 
	 // Constructor
	 public SalaryArrearPages(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	     wait = new WaitHelper(driver);
	 }
	 
	 // Locators
	 @FindBy(xpath = "//h3[normalize-space()='Personnel']")
	 WebElement PersonnelModule;

	 @FindBy(linkText = "Payroll")
	 WebElement payrolls;
	 
	 @FindBy(linkText = "Payroll Details")
	 WebElement payrollDetails;
	 
	 @FindBy(linkText = "Arrear")
	 WebElement arrear;
	 
	 @FindBy(xpath="//a[normalize-space()='Salary Arrear']")
	 WebElement salaryarrear;
	 
	 @FindBy(id = "ctl00_ContentPlaceHolder1_D_ddlEPFNo")
	 WebElement selectname;

	 @FindBy(id = "ctl00_ContentPlaceHolder1_ddlMonth")
	 WebElement selectmonth;
	 
	 @FindBy(id="ctl00_ContentPlaceHolder1_ddlYear")
	 WebElement selectyear;
	 
	 @FindBy(xpath="//img[@class='PopcalTrigger']")
	 WebElement calendarIcon;

	@FindBy(xpath="//table[@class='chkboxlist']//label")
	 List<WebElement> allLocations;
	 	 
	
	 @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_btnSave']")
	 WebElement saveButton;
	 
	 @FindBy(id="ctl00_ContentPlaceHolder1_lblMsg")
	 WebElement successMsg;
	             
	 @FindBy(linkText = "Home")
	 WebElement home;

	 
	 // Click Sales Module
	 public void clickPersonelModule() {
		 wait.click(PersonnelModule);
	 }
	 
	 // Open Sale Date Master
	 public void openSalaryArrear() throws InterruptedException {
		 Actions action = new Actions(driver);
		 
		 wait.waitForVisibility(payrolls);
		 action.moveToElement(payrolls).perform();
		 
		 wait.waitForVisibility(payrollDetails);
		 action.moveToElement(payrollDetails).perform();
		 
		 wait.waitForVisibility(arrear);
		 action.moveToElement(arrear).perform();
		 		 
		 wait.click(salaryarrear);
		 Thread.sleep(3000);
	 }
	 
	 // Select Employee
	 public void selectEmp(String salectEmp) throws InterruptedException {
		 wait.waitForVisibility(selectname);
		 wait.selectByText(selectname, salectEmp);
	}
	 
	 // Select Month 
	 public void selectMonth(String month) {
		 wait.waitForVisibility(selectmonth);
		 wait.selectByText(selectmonth, month);
	 }
	 
	 // Select Year 
	 public void selectYear(String year) {
		 wait.waitForVisibility(selectyear);
		 wait.selectByText(selectyear, year);
	 }
	 
	 
	 
	// Enter Date
	/*
	 * public void selectDate(String months, String years, String day) { // Calendar
	 * Open wait.click(calendarIcon);
	 * 
	 * // Switch to Calendar Frame (locator apne HTML ke hisab se change karo)
	 * driver.switchTo().frame(driver.findElement(By.xpath(
	 * "//iframe[contains(@id,'gToday')]")));
	 * 
	 * // Wait for Month Dropdown wait.waitForVisibility(month);
	 * 
	 * // Select Month Select mon = new Select(month);
	 * mon.selectByVisibleText(months);
	 * 
	 * // Select Year Select yr = new Select(year); yr.selectByVisibleText(years);
	 * 
	 * // Select Day WebElement date =
	 * driver.findElement(By.xpath("//a[normalize-space()='" + day + "']"));
	 * wait.click(date);
	 * 
	 * // Back to Main Page driver.switchTo().defaultContent(); }
	 */	    
	    
	 // Select Location
     public void selectLocations(String... locationName) {
    	 
    	 wait.waitForVisibility(allLocations.get(0));
    	 List<String> locationList = Arrays.asList(locationName);
    	 System.out.println(locationList);
    	 
    	 for(WebElement element:allLocations) {
    		 String text = element.getText().trim();
    		 System.out.println("UI = " + text);
    		 
    		 if(locationList.contains(text)) {
    			 wait.click(element);
    			 logger.info("Selected Location : " + text);
    		 }
    	 }
     }

     public void clickSaveButton() throws InterruptedException {
    	    By saveBtn = By.id("ctl00_ContentPlaceHolder1_btnSave");
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
    	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    	    System.out.println("Save Button Clicked");
    	}
     
     public void waitForSaveSuccess() {
    	    wait.waitForVisibility(successMsg);
    	}
	  // Click Home
	  public void clickHome() {
		  wait.click(home);
	  }

}
