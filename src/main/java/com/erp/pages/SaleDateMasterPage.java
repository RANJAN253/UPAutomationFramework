package com.erp.pages;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.erp.baseclass.BaseClass;
import com.erp.utilities.WaitHelper;

public class SaleDateMasterPage extends BaseClass{
	 WebDriver driver;
	 WaitHelper wait;
	 
	 // Constructor
	 public SaleDateMasterPage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	     wait = new WaitHelper(driver);
	 }
	 
	 // Locators
	 @FindBy(xpath = "//h3[normalize-space()='Sales']")
	 WebElement salesModule;

	 @FindBy(linkText = "Depot Masters")
	 WebElement depotMaster;

	 @FindBy(linkText = "Sale Date Master")
	 WebElement saleDateMaster;

	 @FindBy(id = "ctl00_ContentPlaceHolder1_D_ddlSaleType")
	 WebElement saleType;

	 @FindBy(id = "ctl00_ContentPlaceHolder1_D_ddlStatus")
	 WebElement saleStatus;
	 
	 @FindBy(xpath="//img[@class='PopcalTrigger']")
	 WebElement calendarIcon;

	 @FindBy(id="MonSelect")
	 WebElement month;

	 @FindBy(id="YearSelect")
	 WebElement year;
	 
	 @FindBy(id = "ctl00_ContentPlaceHolder1_D_txtDate")
	 WebElement saleDate;
	 
	 @FindBy(xpath = "//input[@value='>']")
	 WebElement addButton;

	 @FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
	 WebElement saveButton;

    // @FindBy(className = "chkboxlist")
    // WebElement location;
	 
	 @FindBy(xpath="//table[@class='chkboxlist']//label")
	 List<WebElement> allLocations;
	 
    // @FindBy(xpath="//div[@class='chkboxlist']//label")
     

	 @FindBy(linkText = "Home")
	 WebElement home;

	 @FindBy(how = How.XPATH, using = "//select[@id='ctl00_ContentPlaceHolder1_ddlloc']")
	 @CacheLookup
	 WebElement selectLocation;
	 
	 // Click Sales Module
	 public void clickSalesModule() {
		 wait.click(salesModule);
	 }
	 // Open Sale Date Master
	 public void openSaleDateMaster() {
		 Actions action = new Actions(driver);
		 wait.waitForVisibility(depotMaster);
		 action.moveToElement(depotMaster).perform();
		 wait.click(saleDateMaster);
	 }
	 
	 // Select Sale Type
	 public void selectSaleType(String saleTypeName) throws InterruptedException {
		 wait.selectByText(saleType, saleTypeName);
		 Thread.sleep(3000);
	 }
	 
	 // Select Sale Status
	 public void selectSaleStatus(String status) {
		 wait.selectByText(saleStatus, status);
	 }
	 
	// Enter Date
	 public void selectDate(String months, String years, String day) {
		 // Calendar Open
		    wait.click(calendarIcon);
		    
		    // Switch to Calendar Frame (locator apne HTML ke hisab se change karo)
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'gToday')]")));

		    // Wait for Month Dropdown
		    wait.waitForVisibility(month);

		    // Select Month
		    Select mon = new Select(month);
		    mon.selectByVisibleText(months);

		    // Select Year
		    Select yr = new Select(year);
		    yr.selectByVisibleText(years);

		    // Select Day
		    WebElement date = driver.findElement(By.xpath("//a[normalize-space()='" + day + "']"));
		    wait.click(date);
		    
		 // Back to Main Page
		    driver.switchTo().defaultContent();
	 }	    
	    
	 // Select Location
     public void selectLocations(String... locationName) {
    	 
    	 wait.waitForVisibility(allLocations.get(0));
    	 
    	 List<String> locationList = Arrays.asList(locationName);
    	 
    	 System.out.println(locationList);
    	 
    	 for(WebElement element:allLocations) {
    		 String text = element.getText().trim();
    		 System.out.println("UI = " + text);
    		 
    		 if(locationList.contains(text))
    		 {
    			 wait.click(element);
    			 logger.info("Selected Location : " + text);
    		 }
    	 }
     }
    	
     // Click >
     public void clickAddButton() {
    	 wait.click(addButton);
     }
	 
	 // Click Save Button
	  public void clickSaveButton() {
		  wait.click(saveButton);
	  }
	  
	  // Click Home
	  public void clickHome() {
		  wait.click(home);
	  }
}