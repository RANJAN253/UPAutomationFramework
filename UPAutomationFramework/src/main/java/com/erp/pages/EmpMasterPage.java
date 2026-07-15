package com.erp.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmpMasterPage {
	
	WebDriver ldriver;

	public EmpMasterPage(WebDriver rdriver) { //constructor
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}  

	@FindBy(linkText="Personnel")
	WebElement personnel_Module;

	@FindBy(linkText="Establishment")
	WebElement establishment;
	
	@FindBy(linkText="Establishment Details")
	WebElement establishment_Details;

	@FindBy(linkText="Employee Master")
	WebElement emp_master;

	@FindBy(how=How.NAME,using="ctl00$ContentPlaceHolder1$txtManualCode")
	@CacheLookup
	WebElement empManualCode;

	@FindBy(how=How.NAME,using="ctl00$ContentPlaceHolder1$R_txtEmpName")
	@CacheLookup
	WebElement empName;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_txtEmpName_h")
	WebElement empName_H;

	@FindBy(linkText = "Home")
	WebElement home;

	@FindBy(id="ctl00_ContentPlaceHolder1_btnSave")
	WebElement SaveBtn;

	@FindBy(xpath="//span[@id='ctl00_ContentPlaceHolder1_lblMsg']")
	WebElement Msg;

	@FindBy(xpath="//a[@class='icon1']")
	WebElement homebtn;

	public void clickOnModule() throws InterruptedException	{
		personnel_Module.click();
	}

	public void Action() throws InterruptedException	{		
		Actions action= new Actions(ldriver);
		action.moveToElement(establishment).build().perform();
	}
	
	public void Action1() throws InterruptedException	{		
		Actions action1= new Actions(ldriver);
		action1.moveToElement(establishment_Details).build().perform();
	}
	
	public void clickOnEmpMaster() throws InterruptedException	{
		emp_master.click();
	}
	
	public void enterManualCode(int code) {
		empManualCode.sendKeys("code");
	}

	public void selectSpecies(String species) throws InterruptedException	{
		//Select speciesName = new Select(selectSpecies);
		//speciesName.selectByVisibleText(species);
	}

	public void setPlotNumber(String plotNo) throws InterruptedException	{
		//txtPlotNo.sendKeys(plotNo);
	}

	public void clickOnSubmit() throws InterruptedException	{
		SaveBtn.click();
	}

	public String getSuccessfullMsg() {
		String text = Msg.getText();
		return text;
	}

	

}
