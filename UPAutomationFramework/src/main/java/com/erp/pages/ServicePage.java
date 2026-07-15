package com.erp.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicePage {
	
	
	WebDriver ldriver;
	public ServicePage(WebDriver rdriver)  { //constructor
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}  
	
	@FindBy(xpath="//input[@name='ServiceToken']")
	WebElement serviceToken;
	
	@FindBy(xpath="//input[@name='Fk_Poid']")
	WebElement poId;
	
	@FindBy(xpath="//input[@value='Invoke']")
	WebElement invoke;
	
	public void enterUserName(String token)  {
		serviceToken.clear();
		serviceToken.sendKeys(token);
	}

	public void enterPassword(String po_Id)	{
		poId.clear();
		poId.sendKeys(po_Id);
	}

	public void clickOnLoginBtn()   {
		//loginBtn.click();
		//loginBtn.sendKeys(Keys.CONTROL,"a");
		//loginBtn.sendKeys(Keys.BACK_SPACE);
		invoke.sendKeys(Keys.ENTER);
	}    
	
	

}
