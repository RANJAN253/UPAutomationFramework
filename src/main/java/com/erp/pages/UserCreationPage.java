package com.erp.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserCreationPage {
	
	@FindBy(linkText="User Management")
	WebElement User_Management;
	
	@FindBy(linkText="Manage Users")
	WebElement manageuser;
	
	@FindBy(xpath="//a[normalize-space()='User Master']")
	WebElement usermaster;
	
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_D_ddlOffice']")
	WebElement officetype;
	
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_D_ddlDLocation']")
	WebElement defaultLocation;
	
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_D_ddlRole']")
	WebElement roleType;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_R_txtUserName']")
	WebElement userId;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtPassword']")
	WebElement pwd;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_R_txtEmpname']")
	WebElement empname;
	
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_D_ddlDepartment']")
	WebElement department;
	
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_D_ddlDesignation']")
	WebElement designation;

	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnSave']")
	WebElement SaveBtn;
	
	@FindBy(xpath = "//a[@class='hb']")
	WebElement home;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnReset']")
	WebElement reset;
	
	// Initialization the  page  objects
	
	WebDriver ldriver;
	public UserCreationPage(WebDriver rdriver)  { //constructor
		   ldriver = rdriver;
	       PageFactory.initElements(rdriver, this);
	}
				
	//public  void saleDateCreationPage(String saleTypes, String saleStatus, String[] arrDepotName) throws InterruptedException
	public  void clickOnUsermanagement() throws InterruptedException {
		User_Management.click();
		Thread.sleep(1000);
	}
	public void Action() throws InterruptedException {		
		Actions action= new Actions(ldriver);
		action.moveToElement(manageuser).build().perform();
	}
	public void clickOnUserMaster() throws InterruptedException {
		usermaster.click();
		
	}
	public void setUsername(String user) throws InterruptedException{
		userId.sendKeys(user);
	}
	
	public void selectOfficeType(String office) {
		Select offices = new Select(officetype);
		offices.selectByVisibleText(office);
	}
	
	public void selectDLocation(String dlocation) {
		Select defaultlocatoin= new Select(defaultLocation);
		defaultlocatoin.selectByVisibleText(dlocation);
	}
	
	public void selectroleType(String role) { 
		Select roletype	= new Select(roleType);
		roletype.selectByVisibleText(role);
	}
	
	public void enterEmpName(String employee) {
		empname.sendKeys(employee);
	}
	
	public void selectDepartment(String dep) {
		Select depart = new Select(department);
		depart.selectByVisibleText(dep);
	}
	
	public void selectDesignation(String Desi)	{
		Select Desig = new Select(designation);
		Desig.selectByVisibleText(Desi);	
	}
	
	public void setPassword(String password)  {
		pwd.sendKeys(password);
	}
	
	public void clickOnSave() {
		 SaveBtn.click();
	}
	
	public void clickOnHome() throws InterruptedException {
		home.click();
	}
}