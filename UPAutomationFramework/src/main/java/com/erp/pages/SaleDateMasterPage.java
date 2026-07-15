package com.erp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SaleDateMasterPage {
	WebDriver ldriver;
	
	@FindBy(linkText="Sales")
	WebElement salesModule;
	
	@FindBy(linkText="Depot Masters")
	WebElement Depot_master;
	
	@FindBy(linkText="Sale Date Master")
	WebElement Sale_Date_master;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_D_ddlSaleType")
	WebDriver saleType;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_D_ddlStatus")
	WebElement saleStatus;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSave")
	WebElement SaveBtn;
	
	@FindBy(className = "chkboxlist")
	WebElement location;
	
	@FindBy(linkText = "Home")
	WebElement home;
	
	@FindBy(how=How.XPATH,using="//select[@id='ctl00_ContentPlaceHolder1_ddlloc']")
	@CacheLookup
	WebElement selectLocation;
		


	public SaleDateMasterPage(WebDriver rdriver) 
	{ //constructor
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}  
	
	public void clickOnSaleModule() {
		salesModule.click();
	}
	
	public void ActionClass() {
		Actions action= new Actions(ldriver);
		action.moveToElement(Depot_master).build().perform();
		Sale_Date_master.click();
	}





	
	
	
	
}
