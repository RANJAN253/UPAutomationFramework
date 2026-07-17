package com.erp.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.pages.PlotMasterPage;
import com.erp.utilities.ScreenshotUtility;

public class TC3_PlotMasterTestCase extends BaseClass {
	//@Test(dataProvider="PlotData")
	@Test
	public void addPlotMaster() throws InterruptedException, IOException {
		
		logger.info("********** Plot Master Test Started **********");
		
		 // Login
        LoginPage lp = new LoginPage(driver);
        
		lp.enterUsername(username);
		logger.info("Entered Username");
		
		lp.enterPassword(password);
		logger.info("Entered Password");
	
		lp.clickLoginButton();
        logger.info("Login Successful");

     // Open Plot Master Page
        PlotMasterPage plot = new PlotMasterPage();
        
        // Select Location
       
        plot.selectLocation("Kursi Road Depot Lucknow [Depot]");
        logger.info("Location Selected");
        
     // Click Depot Module
        plot.clickDepot();
        logger.info("Clicked on Depot Module");
        
     // Click Plot Master
        plot.clickPlotMaster();
        logger.info("Clicked on Plot Master");
        
     // Create Plot
        plot.createPlotPage(
                "Kursi Road Depot Lucknow [Depot]",   // Depot Name
                "Aam Dry",                            // Species
                "12/24-25");                          // Plot Number
        
        logger.info("Plot Details Entered Successfully");

        // Validation
        String title = driver.getTitle();

        if (title.contains("Record Saved Successfully")) {

            logger.info("Plot Master Entry Successful");
            Assert.assertTrue(true);

        } else {

            logger.error("Plot Master Entry Failed");

            ScreenshotUtility.captureScreenshot(driver, "addPlotMaster");
           
            Assert.fail("Record Not Saved");
        }

        logger.info("********** Plot Master Test Completed **********");
    }
}

	