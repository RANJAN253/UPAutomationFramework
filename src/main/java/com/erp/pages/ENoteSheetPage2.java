package com.erp.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.erp.baseclass.BaseClass;
import com.erp.utilities.Log;
import com.erp.utilities.WaitHelper;

public class ENoteSheetPage2 extends BaseClass {
	WebDriver driver;
	WaitHelper wait;
	Log log;
	
	// ========================================================== 
	// CONSTRUCTOR 
	// ==========================================================

	public ENoteSheetPage2(WebDriver rdriver) 	{ //constructor
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WaitHelper(driver);
	}  
	
	private By notesheet_Module       = By.xpath("//a[normalize-space()='E-Note Sheet']");
	private By enotesheet_masters     = By.linkText("E-Note Sheet");
	private By notesheet_new          = By.xpath("//a[contains(text(),'E-Note Sheet [New]')]");
	private By selectstatus           = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_rptDetails_ctl02_rdAppStatus_1']");
	private By selectnotesheetcategoy = By.id("ctl00_ContentPlaceHolder1_D_ddlFileCategory");
	private By selectnotesheetsubcat  = By.id("ctl00_ContentPlaceHolder1_D_ddlFileSubCategory");
	private By enterdocnumber         = By.id("ctl00_ContentPlaceHolder1_R_txtDocNo");
	private By entersubject           = By.id("ctl00_ContentPlaceHolder1_R_txtSubject");
	private By notesheetdetail        = By.xpath("//iframe[@title='Rich text editor, ctl00_ContentPlaceHolder1_txtdesc']");
	private By notesheetcomment       = By.xpath("//iframe[@title='Rich text editor, ctl00_ContentPlaceHolder1_txtComment']");
	private By fileupload             = By.id("ctl00_ContentPlaceHolder1_flUploadFile");
	private By addButton              = By.id("ctl00_ContentPlaceHolder1_btnAddFile");
	private By btnSubmit              = By.id("ctl00_ContentPlaceHolder1_btnSave");
	private By notesheetstatus        = By.linkText("E-Note Sheet Status [New]");
	private By clickView              = By.xpath("//a[@id='ctl00_ContentPlaceHolder1_dgPending_ctl02_lnkView']//img");
	
	private By rdRecommended          = By.xpath("//label[normalize-space()='Recommended']");
	private By rdConsent              = By.xpath("//label[normalize-space()='Consent']");
	private By rdRejected             = By.id("//label[normalize-space()='Rejected']");
	private By rdApproved             = By.xpath("//label[normalize-space()='Approved']");
	private By rdNeed                 = By.xpath("//label[normalize-space()='Need Modification']");
	
	// ========================================================== 
	// NAVIGATION 
	// ==========================================================
	public void clickOnModule() throws InterruptedException {
	    wait.click(notesheet_Module);
	}
	  
	public void Action() {
		WebElement element = wait.waitForVisibility(enotesheet_masters);
		Actions action= new Actions(driver);
	  	action.moveToElement(element).build().perform();
	}
	   
	public void clickOnEnoteSheetNew() throws InterruptedException {
		wait.click(notesheet_new);
	}
	
	public void  clickOnRecOption()  {
		wait.click(selectstatus); 
	}
	
	public void clickOnView()	{
		wait.click(clickView);
	}
	
	public void clickonViewNoteSheet() {
		wait.click(clickView);
	}
	
	public void clickOnNewStatus() {
		wait.click(notesheetstatus);
	}
	
	public void selectNoteSheetCategory(String notesheetcat) throws InterruptedException {
	  WebElement element = wait.waitForVisibility(selectnotesheetcategoy);
	  Select sheetcat = new Select(element);
	  sheetcat.selectByVisibleText(notesheetcat);
	}
	
	public void	selectNoteSheetSubCatagory(String notesheetsubcat) throws  InterruptedException {
		WebElement element = wait.waitForVisibility(selectnotesheetsubcat);
		Select subcat = new Select(element);
	    subcat.selectByVisibleText(notesheetsubcat);
	}
	
	public void  enterDocNumber(String docnumber) throws InterruptedException {
		wait.sendKeys(enterdocnumber,  docnumber);
	}
	
	public void enterSubject(String subject) { 
		wait.sendKeys(entersubject,subject);
	} 
	
	public void enterDetails(String	details)	{ 
		wait.scrollToElement(notesheetdetail);
	    WebElement framelement =wait.waitForVisibility(notesheetdetail);
	    driver.switchTo().frame(framelement);
	    
	    WebElement body = driver.findElement(By.tagName("body"));

	    body.sendKeys(Keys.CONTROL + "a");
	    body.sendKeys(Keys.DELETE);
	    body.sendKeys(details);

	    driver.switchTo().defaultContent();
	} 
	
	public void  enterComment(String comment) { 
		wait.scrollToElement(notesheetcomment);
		WebElement framelement =wait.waitForVisibility(notesheetcomment);
		driver.switchTo().frame(framelement);
		WebElement body = driver.findElement(By.tagName("body"));
		body.sendKeys(Keys.CONTROL + "a");  // Focus inside editor
		body.sendKeys(Keys.DELETE);         //if supported  body.click(), body.clear()
		body.sendKeys(comment);

		driver.switchTo().defaultContent();
	}
	
	public void uploadFile(String filepath) {
		wait.sendKeys(fileupload,filepath);
	}
	
	public void clickAddButton() {
		wait.click(addButton);
	}
		
	public void clickOnSubmit() throws InterruptedException {
		wait.click(btnSubmit);
	}
	
	// ========================================================== 
	// DYNAMIC APPROVAL ACTION 
	// ==========================================================
	public void selectApprovalAction(int level, String action)
	{
		action = action.toLowerCase().trim();
		
		// ====================================================== 
		// APPROVED 
		// ======================================================
		
		
		if (action.equals("approved")) { 
			selectApproved();
			return; 
		}
		
		// ====================================================== /
		// ACTION INDEX 
		// ======================================================
		
		int actionIndex;
		
		switch (action) {
		case "under consideration":
			actionIndex = 0;
			break;
			
		case "recommended":
			actionIndex = 1;
			break;
			
		case "not recommended":
			actionIndex = 2;
			break;
			
		case "compliance": 
			actionIndex = 3; 
			break;
		
		case "consent": 
			actionIndex = 4; 
			break;
		
		case "rejected": 
			actionIndex = 5; 
			break;
		
		case "need modification": 
			actionIndex = 6; 
			break;
		case "query": 
			actionIndex = 7; 
			break;
		
		default: throw new IllegalArgumentException( "Invalid Action : " + action );
		}
		
		// ====================================================== 
	    // VALIDATE LEVEL 
	    // ======================================================
	
		if (level < 2 || level > 7) { 
			throw new IllegalArgumentException("Invalid Approval Level : " 	+ level + ". Valid levels are 2 to 7." ); 
		}
		
		// ====================================================== 
		// CREATE DYNAMIC ID 
		// ====================================================== 
		
		String elementId = String.format( "ctl00_ContentPlaceHolder1_rptDetails_ctl%02d_rdAppStatus_%d", level, actionIndex );
		By locator = By.id(elementId);

		Log.info( "Selecting Approval Action" + " | Level : " + level + " | Action : " + action + " | Locator : " + elementId );

		//====================================================== 
		// YOUR EXISTING WAITHELPER 
		// ======================================================

		wait.click(locator);
	}
	
	private void selectApproved() { 
		By approvedLocator = By.xpath( "//label[normalize-space()='Approved']" );
		Log.info( "Selecting Approved Action" ); 
		wait.click( approvedLocator ); 
	}
		
}