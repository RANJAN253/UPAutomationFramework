package com.erp.pages;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.baseclass.BaseClass;

public class SendToAllPage {
	
	
	WebDriver driver;
	@FindBy(name="R_txtLogin")
	@CacheLookup
	 WebElement txtUserName;
	
	@FindBy(id="R_txtPass")
	@CacheLookup
	private WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement SingIn;
	
	@FindBy(xpath="//h3[normalize-space()='Tendu Leaf']")
	WebElement Tendu_Leaf;
	
	@FindBy(xpath="//span[normalize-space()='TP-Collection']")
	WebElement TP_Collection;
	
	@FindBy(xpath="//div[@class='content-shadow']//div[3]//div[2]//a[1]//img[1]")
	WebElement ClickToCalender;
	
	@FindBy(xpath="//body[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]")
	WebElement selectDate;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnCollPending']")
	WebElement BtnPending;
	
	@FindBy(xpath="ctl00_ContentPlaceHolder1_btnsendall")
	WebElement ClickToSendAll;
	
	@FindBy(linkText="Welcome - PHAD Arjguda")
	WebElement welcome_phad1;
	
	@FindBy(xpath="//a[@id='ctl00_lblLoginName']")
	WebElement welcome_phad;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logout;
	
	
	
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnReset']")
	WebElement reset;
	
	
	// Initialization the  page  objects
	WebDriver ldriver;
	public SendToAllPage(WebDriver rdriver)  { //constructor
	   ldriver = rdriver;
       PageFactory.initElements(rdriver, this);
    }  
		
	public void setUserName(String username)  {
		txtUserName.clear();
		txtUserName.sendKeys(username);
	}
	
	public void setPassword(String pwd)	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	 }
	
	public void clickSubmit()   {
		//loginBtn.click();
		//loginBtn.sendKeys(Keys.CONTROL,"a");
		//loginBtn.sendKeys(Keys.BACK_SPACE);
		SingIn.sendKeys(Keys.ENTER);
		}
	
	public void clickTenduLeaf()
	{
		Tendu_Leaf.click();
	}
	
	public void clickOnTenduCollection()
	{
		TP_Collection.click();
	}
	
	public void clickOnCalender()  { 
		ClickToCalender.click();
		}
	
	public void selectDateM()
	{
		selectDate.click();
	}
	
	public void clickOnPending()
	{
		BtnPending.click();
		driver.switchTo().alert().accept();
		
		
	}
	 
	 
	
	/*
	 * public void selectdate() throws Exception { Calendar calendar =
	 * Calendar.getInstance(); String targetDate = "01-April-2024"; SimpleDateFormat
	 * targetDateFormat = new SimpleDateFormat("dd-MMM-yyyy"); Date
	 * formattedTargetDate; try { targetDateFormat.setLenient(false);
	 * formattedTargetDate = targetDateFormat.parse(targetDate);
	 * calendar.setTime(formattedTargetDate);
	 * 
	 * int targetDay = calendar.get(Calendar.DAY_OF_MONTH); int targetMonth =
	 * calendar.get(Calendar.MONTH); int targetYear = calendar.get(Calendar.YEAR);
	 * 
	 * ClickToCalender.click(); Thread.sleep(2000);
	 * 
	 * driver.switchTo().frame(1); currntDate.click();
	 * driver.switchTo().defaultContent(); } catch (ParseException e) { throw new
	 * Exception("Invalid date is provided, please check input date"); } }
	 */

		
	
	public void Action() throws InterruptedException
	{		
		Actions action= new Actions(ldriver);
		action.moveToElement(welcome_phad).build().perform();
		Thread.sleep(1000);
		
	}
	
	public void clickOnLogout() throws InterruptedException
	{
		logout.click();
		
	}

		
}
