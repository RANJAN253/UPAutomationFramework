package com.erp.reports;
//Listener class  used to generate Extent reports
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//com.erp.utilities.ExtentReport
public class ExtentManagerReport {
	
	private static ExtentReports extent;
		 
	 public static ExtentReports getInstance() {
		 
	 	 if (extent == null) {
	 		 String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	 		 String reportPath = System.getProperty("user.dir") +"/Reports/ExtentReport_" + timestamp + ".html";
	 		 System.out.println("Extent Report Path : " + reportPath);
	 		 
	 		 ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
	 		 
	 		 spark.config().setDocumentTitle("ERP Automation Report");
	 		 spark.config().setReportName("UP Forest Automation");
	 		 spark.config().setTheme(Theme.DARK);
	 		 
	 		 extent = new ExtentReports();
	 		 extent.attachReporter(spark);
	 		 
	 		 extent.setSystemInfo("Tester", "Ranjan");
	 		 extent.setSystemInfo("Environment", "QA");
	 		 extent.setSystemInfo("OS", System.getProperty("os.name"));
	 		 extent.setSystemInfo("Java Version", System.getProperty("java.version"));
	 	 }
		 return extent;
	 }
}
