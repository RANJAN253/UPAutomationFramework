package com.erp.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.erp.reports.ExtentManagerReport;

import com.erp.baseclass.BaseClass;
import com.erp.utilities.ScreenshotUtility;
import com.erp.utilities.Log;

public class ExtentListener implements ITestListener {
	
	private ExtentReports extent = ExtentManagerReport.getInstance();   //Get ExtentReport object from ExtentManagarReport
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>(); // Thread-safe ExtentTest object //OR
    //private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
    	//Report is already initialized in ExtentManagerReport
    	
    }

    @Override
    public void onTestStart(ITestResult result) {
    	Log.info("Test Started : " + result.getMethod().getMethodName());
       	ExtentTest extentest = extent.createTest(result.getMethod().getMethodName());
    	test.set(extentest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	Log.info("Test Passed : " + result.getMethod().getMethodName());
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	
    	Log.error("Test Failed : " + result.getMethod().getMethodName());
    	test.get().fail(result.getThrowable());
    	test.get().info("Test Name : " + result.getMethod().getMethodName());
    	
    	 try {
    		 String screenshotPath = ScreenshotUtility.captureScreenshot(BaseClass.getDriver(),result.getMethod().getMethodName());
    	     test.get().addScreenCaptureFromPath(screenshotPath);
    	     
    	    } catch (Exception e) {
    	    	Log.error("Screenshot Capture Failed", e);
    	        test.get().warning("Unable to attach screenshot : " + e.getMessage());
    	    }
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
    	Log.warn("Test Skipped : " + result.getMethod().getMethodName());
    	test.get().skip("Test Skipped : " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
    	Log.endTestCase(context.getName());
        extent.flush();
        test.remove();
    }
}