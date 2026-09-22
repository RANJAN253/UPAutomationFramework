package com.erp.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.driver.DriverFactory;
import com.erp.pages.LoginPage;
import com.erp.pages.PlotMasterPage;
import com.erp.utilities.Log;
import com.erp.utilities.ScreenshotUtility;

public class TC12_PlotMasterTestCase extends BaseClass {
	//@Test(dataProvider="PlotData")
	@Test
	public void addPlotMaster() throws InterruptedException, IOException {
		
		Log.info("********** Plot Master Test Started **********");
		
		 // Login
        LoginPage lp = new LoginPage(DriverFactory.getDriver());
        
		lp.enterUsername(username);
		Log.info("Entered Username");
		
		lp.enterPassword(password);
		Log.info("Entered Password");
	
		lp.clickLoginButton();
		Log.info("Login Successful");

     // Open Plot Master Page
        PlotMasterPage plot = new PlotMasterPage();
        
        // Select Location
       
        plot.selectLocation("Kursi Road Depot Lucknow [Depot]");
        Log.info("Location Selected");
        
     // Click Depot Module
        plot.clickDepot();
        Log.info("Clicked on Depot Module");
        
     // Click Plot Master
        plot.clickPlotMaster();
        Log.info("Clicked on Plot Master");
        
     // Create Plot
        plot.createPlotPage(
                "Kursi Road Depot Lucknow [Depot]",   // Depot Name
                "Aam Dry",                            // Species
                "12/24-25");                          // Plot Number
        
        Log.info("Plot Details Entered Successfully");

        // Validation
        String title = DriverFactory.getDriver().getTitle();

        if (title.contains("Record Saved Successfully")) {

        	Log.info("Plot Master Entry Successful");
            Assert.assertTrue(true);

        } else {

        	Log.error("Plot Master Entry Failed");

            ScreenshotUtility.captureScreenshot(DriverFactory.getDriver(), "addPlotMaster");
           
            Assert.fail("Record Not Saved");
        }

        Log.info("********** Plot Master Test Completed **********");
    }
}

	