package com.erp.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ENoteSheetPage {
	WebDriver ldriver;

	public ENoteSheetPage(WebDriver rdriver) 	{ //constructor
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}  
	
	@FindBy(id="R_txtLogin")
	WebElement userid;
	
	@FindBy(id="R_txtPass")
	WebElement pwd;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement btnLogin;
	
	@FindBy(partialLinkText ="Shiv kumar Verma")
	WebElement transcend;
	
	@FindBy(partialLinkText ="Arun Kumar")
	WebElement transcend1;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement Logout;
	
	@FindBy(linkText="E-Note Sheet")
	WebElement notesheet_Module;
	
	@FindBy(linkText="E-Note Sheet")
	WebElement enotesheet_masters;
	
	@FindBy(linkText="E-Note Sheet [New]")
	WebElement notesheet_new;
	
	@FindBy(linkText="E-Note Sheet Status [New]")
	WebElement notesheetstatus;
	
	@FindBy(xpath="//a[@id='ctl00_ContentPlaceHolder1_dgPending_ctl02_lnkView']//img")
	WebElement clickView;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_rptDetails_ctl02_rdAppStatus_1']")
	WebElement selectstatus;
	
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_D_ddlFileCategory']")
	WebElement selectnotesheetcategory;
	
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_D_ddlFileSubCategory']")
	WebElement selectnotesheetsubcategory;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_R_txtDocNo']")
	WebElement enterdocnumber;
	
	@FindBy(id ="ctl00_ContentPlaceHolder1_R_txtSubject")
	WebElement entersubject;
	
	@FindBy(xpath = "//iframe[@title='Rich text editor, ctl00_ContentPlaceHolder1_txtdesc']")
	WebElement notesheetdetail;
	
	@FindBy(xpath = "//iframe[@title='Rich text editor, ctl00_ContentPlaceHolder1_txtComment']")
	WebElement notesheetcomment;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnSave']")
	WebElement btnSubmit;
	
	public void enterusername(String username)	{
		userid.sendKeys(username);
	}
	
	public void enterpassword(String password)	{
		pwd.sendKeys(password);
	}
	
	public void clickOnModule() throws InterruptedException {
	    notesheet_Module.click();
	}
	  
	public void Action() throws InterruptedException	{
		Actions action= new Actions(ldriver);
	  	action.moveToElement(enotesheet_masters).build().perform();
		
	}
	   
	public void clickOnEnoteSheetNew() throws InterruptedException {
	   notesheet_new.click();
	}
	
	public void clickOnENoteSheetStatus() { 
		  notesheetstatus.click(); 
	 } 
	 
	public void clickonViewNoteSheet() {
		  clickView.click();
	}
	
	public void  clickOnRecOption()  {
		selectstatus.click(); 
	}
	
	public void selectNoteSheetCategory(String notesheetcat) throws InterruptedException {
	  Select sheetcat = new Select(selectnotesheetcategory);
	  sheetcat.selectByVisibleText(notesheetcat);
	}
	
	public void	selectNoteSheetSubCatagory(String notesheetsubcat) throws  InterruptedException {
		Select subcat = new Select(selectnotesheetsubcategory);
	    subcat.selectByVisibleText(notesheetsubcat);
	}
	
	public void  enterDocNumber(String docnumber) throws InterruptedException {
	  enterdocnumber.sendKeys(docnumber);
	}
	
	public void enterSubject(String subject) { 
		entersubject.sendKeys(subject);
	} 
	
	public void enterDetails(String	details)	{ 
		notesheetdetail.sendKeys(details);
	} 
	
	public void  enterComment(String comment) { 
		notesheetcomment.sendKeys(comment);
	}
	
	public void clickOnSubmit() throws InterruptedException {
		btnSubmit.click();
	}
	
	public void ActionDsm() throws InterruptedException {
		Actions action= new Actions(ldriver);
		action.moveToElement(transcend).build().perform();
	}
	
	public void ActionAcc() throws InterruptedException {
		  Actions action= new Actions(ldriver);
		  action.moveToElement(transcend1).build().perform();
	} 
	
	public void clickOnddlLogoutBtn() { 
		  Logout.click();
	}
	  
	 
}
