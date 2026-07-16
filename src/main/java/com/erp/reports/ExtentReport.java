package com.erp.reports;
//Listener class  used to generate Extent reports
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//com.erp.utilities.ExtentReport
public class ExtentReport extends TestListenerAdapter {
	
	 public ExtentSparkReporter sparkReporter;
	 public ExtentReports extent;
	 public ExtentTest test;
	 
	 public void onStart(ITestContext context) {
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	     String repName = "ExtentReport.html";

	     // ✅ Correct initialization
	     sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/" + repName);

	     sparkReporter.config().setDocumentTitle("UP Forest Project");
	     sparkReporter.config().setReportName("Automation Test Report");
	     sparkReporter.config().setTheme(Theme.DARK);

	     extent = new ExtentReports();
	     extent.attachReporter(sparkReporter);

	     extent.setSystemInfo("Host Name", "localhost");
	     extent.setSystemInfo("Environment", "QA");
	     extent.setSystemInfo("User", "Ranjan");
	     extent.setSystemInfo("OS", "Windows 11");
	 }
	 
	 public void onTestSuccess(ITestResult result) {
		 test = extent.createTest(result.getName());
	     test.log(Status.PASS,MarkupHelper.createLabel("Test Passed: " + result.getName(), ExtentColor.GREEN));
	 }
	 
	 public void onTestFailure(ITestResult result) {
		 test = extent.createTest(result.getName());
         test.log(Status.FAIL,MarkupHelper.createLabel("Test Failed: " + result.getName(), ExtentColor.RED));
         String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + result.getName() + ".png";
         File file = new File(screenshotPath);
         
         if (file.exists()) {
        	 test.fail("Screenshot:",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
         }
	 }
	 
	 public void onTestSkipped(ITestResult result) {
		 test = extent.createTest(result.getName());
		 test.log(Status.SKIP,MarkupHelper.createLabel("Test Skipped: " + result.getName(), ExtentColor.ORANGE));
	 }
	 
	 public void onFinish(ITestContext context) {
		 extent.flush();
	 }
}
