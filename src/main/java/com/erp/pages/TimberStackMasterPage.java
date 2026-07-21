package com.erp.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.erp.utilities.DropdownUtils;
import com.erp.utilities.RandomDataGeneration;

public class TimberStackMasterPage {
	WebDriver ldriver;
	
	public TimberStackMasterPage(WebDriver rdriver)  { //constructor
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	} 
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_ddlloc']")
	WebElement location;
	
	@FindBy(linkText="Depot")
	WebElement depot_Module;
	
	@FindBy(linkText="Masters")
	WebElement masters;
	
	@FindBy(linkText="Timber Stack Master")
	WebElement Timber_Stack;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_D_ddlSpecies")
	WebElement speciespath;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_D_ddlGrade")
	WebElement gradepath;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_D_ddlPlotNo")
	WebElement plotpath;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_D_ddlSpeciesCategory")
	WebElement speciescatpath;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_D_ddlTimberType")
	WebElement timbertypetpath;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_R_txtStackNo")
	WebElement stacknopath;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_R_txtMaxVolume")
	WebElement maxvalue;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_D_ddlfrommidgirth")
	WebElement frommidpath;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_D_ddltomidgirth")
	WebElement tomidpath;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_D_ddlfromlength")
	WebElement fromlengthpath;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_D_ddltolength")
	WebElement tolengthpath;
	
	@FindBy(xpath="//div[16]//div[2]//a[1]//img[1]")
	WebElement calander;
	
	@FindBy(xpath="//a[normalize-space()='Today : Dec 5, 2024']")
	WebElement selectDate;
	
	@FindBy(linkText = "Home")
	WebElement home;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSave")
	WebElement SaveBtn;
		
  public void selectLocation(String value) throws InterruptedException {
		//Select selectdrp = new Select(location);
		//selectdrp.selectByVisibleText(value);
		DropdownUtils.selectOptionFromDropDown(ldriver,location, value);
		Thread.sleep(1000);
	}
	public void clickonModule() {
		depot_Module.click();
	}
	public void clickOnAction() throws InterruptedException	{
		Actions action= new Actions(ldriver);
		action.moveToElement(masters).build().perform();
		Thread.sleep(1000);
	}
	public void clickOnTimberStackMaster() throws InterruptedException {
		Timber_Stack.click();
		Thread.sleep(1000);
	}
	public void selectSpecies(String value) {
		DropdownUtils.selectOptionFromDropDown(ldriver, speciespath, value);
	}
	public void selectGrade(String value) {
		DropdownUtils.selectOptionFromDropDown(ldriver, gradepath, value);
	}
	public void selectPlot(String value) {
		DropdownUtils.selectOptionFromDropDown(ldriver, plotpath, value);
	}
	public void selectSpeciesCat(String value) {
		DropdownUtils.selectOptionFromDropDown(ldriver, speciescatpath, value);
	}
	public void selectTimberType(String value) {
		DropdownUtils.selectOptionFromDropDown(ldriver, timbertypetpath, value);
	}
	public void enterStackNo()	{
		stacknopath.sendKeys(RandomDataGeneration.generationRandomNumber());
		//RandomDataGeneration.generationRandomNumber();
		
		
	}
	public void enterMaxValue(String value) {
		maxvalue.sendKeys(value);
	}
	public void selectFromMidGirth(String value) {
		DropdownUtils.selectOptionFromDropDown(ldriver, frommidpath, value);
	}
	public void selectToMidGirth(String value) {
		DropdownUtils.selectOptionFromDropDown(ldriver, tomidpath, value);
	}
	public void selectFromLength(String value) {
		DropdownUtils.selectOptionFromDropDown(ldriver, fromlengthpath, value);
	}
	public void selectToLength(String value) {
		DropdownUtils.selectOptionFromDropDown(ldriver, tolengthpath, value);
	}
	public void clickOnSave() {
		SaveBtn.click();
	}
	
	public void clickOnHomePage()
	{
		home.click();
	}
	public void clickonCalender() throws InterruptedException {
		calander.click();
		
		Thread.sleep(2000);
		
		ldriver.switchTo().frame(0);
		Thread.sleep(2000);
		
		Select mon = new Select(ldriver.findElement(By.id("MonSelect")));
		mon.selectByVisibleText("Dec");
		
		Thread.sleep(1000);
		Select years = new Select(ldriver.findElement(By.id("YearSelect")));
		mon.selectByVisibleText("2024");
		
		String date  = "5";
		
		List<WebElement> allDates = ldriver.findElements(By.xpath("//div[@id='innerDiv']//td"));
		
		for(WebElement e:allDates)
		{
			String dt = e.getText();
			
			if(dt.equals(date))
			{
				e.click();
				break;
			}
		}
		
		ldriver.switchTo().defaultContent();
	
	}
	
	/*public void selectDate() throws InterruptedException
	{
		ldriver.switchTo().frame(0);
		Thread.sleep(1000);
		
		Select mon = new Select(ldriver.findElement(By.id("MonSelect")));
		mon.selectByVisibleText("Dec");
		
		Thread.sleep(1000);
		Select years = new Select(ldriver.findElement(By.id("YearSelect")));
		mon.selectByVisibleText("2024");
		
		//String date  = "5";
		
		List<WebElement> allDates = ldriver.findElements(By.xpath("//div[@id='innerDiv']//td"));
		
		for(WebElement e:allDates)
		{
			String dt = e.getText();
			
			if(dt.equals(date))
			{
				e.click();
				break;
			}
		}
		
		ldriver.switchTo().defaultContent();
	
	}*/
}






