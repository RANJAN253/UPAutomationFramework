package com.erp.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.erp.baseclass.BaseClass;
import com.erp.utilities.WaitHelper;

public class ENoteSheetPage extends BaseClass {
	WebDriver driver;
	WaitHelper wait;

	public ENoteSheetPage(WebDriver rdriver) 	{ //constructor
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		 wait = new WaitHelper(driver);
	}  
	
	@FindBy(xpath="//a[normalize-space()='E-Note Sheet']")  //h3[normalize-space()='E-Note Sheet']
	WebElement notesheet_Module;
	
	@FindBy(linkText="E-Note Sheet")
	WebElement enotesheet_masters;
	
	@FindBy(xpath="//a[contains(text(),'E-Note Sheet [New]')]")
	WebElement notesheet_new;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_rptDetails_ctl02_rdAppStatus_1']")
	WebElement selectstatus;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_D_ddlFileCategory")
	WebElement selectnotesheetcategory;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_D_ddlFileSubCategory")
	WebElement selectnotesheetsubcategory;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_R_txtDocNo")
	WebElement enterdocnumber;
	
	@FindBy(id ="ctl00_ContentPlaceHolder1_R_txtSubject")
	WebElement entersubject;
	
	@FindBy(xpath = "//iframe[@title='Rich text editor, ctl00_ContentPlaceHolder1_txtdesc']")
	WebElement notesheetdetail;
	
	@FindBy(xpath = "//iframe[@title='Rich text editor, ctl00_ContentPlaceHolder1_txtComment']")
	WebElement notesheetcomment;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_flUploadFile")
	WebElement fileupload;
	
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnAddFile")
	WebElement addButton;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSave")
	WebElement btnSubmit;
	
	@FindBy(linkText="E-Note Sheet Status [New]")
	WebElement notesheetstatus;
	
	@FindBy(xpath="//a[@id='ctl00_ContentPlaceHolder1_dgPending_ctl02_lnkView']//img")
	WebElement clickView;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_rptDetails_ctl02_rdAppStatus_1")
	WebElement rdRecommended;

	@FindBy(id="ctl00_ContentPlaceHolder1_rptDetails_ctl03_rdAppStatus_4")
	WebElement rdConsent;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_rptDetails_ctl02_rdAppStatus_5")
	WebElement rdRejected;

	@FindBy(id="ctl00_ContentPlaceHolder1_rptDetails_ctl06_rdAppStatus_1")
	WebElement rdApproved;

	public void clickOnModule() throws InterruptedException {
	    notesheet_Module.click();
	}
	  
	public void Action() throws InterruptedException	{
		Actions action= new Actions(driver);
	  	action.moveToElement(enotesheet_masters).build().perform();
	}
	   
	public void clickOnEnoteSheetNew() throws InterruptedException {
		notesheet_new.click();
	}
	
	public void clickonViewNoteSheet() {
		wait.waitForVisibility(clickView);
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
		//notesheetdetail.sendKeys(details);
		wait.scrollToElement(notesheetdetail);
	    driver.switchTo().frame(notesheetdetail);
	    WebElement body = driver.findElement(By.tagName("body"));

	    body.sendKeys(Keys.CONTROL + "a");
	    body.sendKeys(Keys.DELETE);
	    body.sendKeys(details);

	    driver.switchTo().defaultContent();
	} 
	
	public void  enterComment(String comment) { 
		//notesheetcomment.sendKeys(comment);
		wait.scrollToElement(notesheetcomment);
		driver.switchTo().frame(notesheetcomment);
		WebElement body = driver.findElement(By.tagName("body"));
		 body.sendKeys(Keys.CONTROL + "a");  // Focus inside editor
		 body.sendKeys(Keys.DELETE);         //if supported  body.click(), body.clear()
		 body.sendKeys(comment);

		 driver.switchTo().defaultContent();
	}
	
	public void uploadFile(String filepath) {
		fileupload.sendKeys(filepath);
	}
	
	public void clickAddButton() {
		addButton.click();
	}
		
	public void clickOnSubmit() throws InterruptedException {
		 wait.scrollToElement(btnSubmit);
		 wait.click(btnSubmit);
		//btnSubmit.click();
	}
	
	public void clickOnNewStatus() {
		notesheetstatus.click();
	}
	
	public void clickOnView()
	{
		clickView.click();
	}
	
	public void selectApprovalAction(String action)
	{
	    switch(action.toLowerCase())
	    {
	        case "recommended":
	        	wait.scrollToElement(rdRecommended);
	            wait.click(rdRecommended);
	            break;

	        case "consent":
	        	wait.scrollToElement(rdConsent);
	            wait.click(rdConsent);
	            break;
	            
	        case "rejected":
	        	wait.scrollToElement(rdApproved);
	            wait.click(rdRejected);
	            break;

	        case "approved":
	        	wait.scrollToElement(rdRejected);
	            wait.click(rdApproved);
	            break;

	        
	        default:
	            throw new IllegalArgumentException("Invalid Action : " + action);
	    }
	}
}