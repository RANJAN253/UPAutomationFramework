package com.erp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SalaryReportPage {
	
	WebDriver ldriver;

	public SalaryReportPage(WebDriver rdriver) 
	{ //constructor
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}  

	//@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_ddlloc']")
	//WebElement location;

	@FindBy(how=How.XPATH,using="//select[@id='ctl00_ContentPlaceHolder1_ddlloc']")
	@CacheLookup
	WebElement selectLocation;

	@FindBy(linkText="Personnel")
	WebElement personal;

	@FindBy(linkText="Payroll")
	WebElement masters;
	
	@FindBy(linkText="Payroll Reports")
	WebElement payrollReport;

	@FindBy(linkText="Salary Reports")
	WebElement salary_reports;

	//@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_D_ddlSpecies']")
	//WebElement selspecies;

	@FindBy(how=How.NAME,using="ctl00$ContentPlaceHolder1$D_ddlMonth")
	@CacheLookup
	WebElement selectMonth;
	
	@FindBy(how=How.NAME,using="ctl00$ContentPlaceHolder1$D_ddlYear")
	@CacheLookup
	WebElement selectYear;
	
	@FindBy(how=How.NAME,using="ctl00$ContentPlaceHolder1$ddlReportType")
	@CacheLookup
	WebElement selectReportType;

	@FindBy(how=How.NAME,using="ctl00$ContentPlaceHolder1$btnView")
	@CacheLookup
	WebElement btnView;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$btnSave")
	WebElement btnPreview;
	
	@FindBy(xpath="//span[@id='ctl00_ContentPlaceHolder1_lblMsg']")
	WebElement Msg;

	@FindBy(xpath="//a[@class='icon1']")
	WebElement homebtn;

	public void selectLocation(String loc) 	{
		Select locations = new Select(selectLocation);
		locations.selectByVisibleText(loc);
	}

	public void clickOnModule() throws InterruptedException	{
		personal.click();
	}

	public void Action() throws InterruptedException	{		
		Actions action= new Actions(ldriver);
		action.moveToElement(masters).build().perform();
	}
	
	public void Action1()
	{
		Actions action1 = new Actions(ldriver);
		action1.moveToElement(payrollReport).build().perform();
		
	}
	public void clickOnSalaryReport() throws InterruptedException	{
		salary_reports.click();
	}
	
	public void selectMonth(String mnth) throws InterruptedException 
	{
		   Select month = new Select(selectMonth);
		   month.selectByVisibleText(mnth); 
	}
	  
	public void selectYear(String year) throws InterruptedException 
	{
		Select month = new Select(selectYear);
		month.selectByVisibleText(year); 
	}
	  
	public void selectReportTypes(String report) throws InterruptedException 
	{
		Select month = new Select(selectReportType);
		month.selectByVisibleText(report); 
	}
	
	public void clickOnViewBtn()
	{
		btnView.click();
	}
	
	public void clickOnPreviewBtn()
	{
		btnPreview.click();
	}
}
