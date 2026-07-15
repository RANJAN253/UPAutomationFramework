package com.erp.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.erp.baseclass.BaseClass;
import com.erp.utilities.WaitHelper;

public class PlotMasterPage extends BaseClass
{
	 @FindBy(linkText = "Depot")
	 WebElement depot_Module;

	 @FindBy(linkText = "Masters")
	 WebElement masters;

	 @FindBy(linkText = "Plot Master")
	 WebElement plot_master;

	 @FindBy(linkText = "Home")
	 WebElement home;

	 @FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
	 WebElement SaveBtn;

	 @FindBy(xpath = "//a[@class='icon1']")
	 WebElement homebtn;
	 
	 @FindBy(id="txtLocation")
	 WebElement txtlocation;

	 @FindBy(id = "ctl00_ContentPlaceHolder1_ddlloc")
	 WebElement locationDropdown;

	 @FindBy(id = "ctl00_ContentPlaceHolder1_D_ddlDepot")
	 WebElement depotDropdown;

	 @FindBy(id = "ctl00_ContentPlaceHolder1_D_ddlSpecies")
	 WebElement speciesDropdown;

	 @FindBy(id = "ctl00_ContentPlaceHolder1_R_txtPlotNo")
	 WebElement txtPlotNo;

	 WaitHelper waithelper;

	 // Constructor
	 public PlotMasterPage() {

	     PageFactory.initElements(driver, this);
	     waithelper = new WaitHelper(driver);
	 }

	 public void selectLocation(String location) {
		 waithelper.sendKeys(txtlocation, location);
		 txtlocation.sendKeys(Keys.ARROW_DOWN);
		 txtlocation.sendKeys(Keys.ENTER);
	 }

	    // Click Depot
	    public void clickDepot() {

	        waithelper.click(depot_Module);
	    }

	    // Click Plot Master
	    public void clickPlotMaster() {

	        Actions action = new Actions(driver);
	        action.moveToElement(masters).perform();

	        waithelper.click(plot_master);
	    }

	    // Create Plot
	    public void createPlotPage(String depotNames, String species, String plotNo) {

	        waithelper.selectByText(depotDropdown, depotNames);

	        waithelper.selectByText(speciesDropdown, species);

	        waithelper.sendKeys(txtPlotNo, plotNo);

	        waithelper.click(SaveBtn);

	        waithelper.click(home);
	    }
}