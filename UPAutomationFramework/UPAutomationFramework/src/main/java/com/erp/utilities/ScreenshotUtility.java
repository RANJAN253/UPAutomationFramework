package com.erp.utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.erp.constants.FrameworkConstants;

public class ScreenshotUtility {
	
	public static String captureScreenshot(WebDriver driver, String testName) throws IOException {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

       // String path = System.getProperty("user.dir") + "/Screenshots/"+ testName + "_" + timestamp + ".png";
        
        String path = FrameworkConstants.SCREENSHOT_PATH + testName + "_" + timestamp + ".png";

        File target = new File(path);

        FileUtils.copyFile(source, target);
       
        return path;
    }

}
