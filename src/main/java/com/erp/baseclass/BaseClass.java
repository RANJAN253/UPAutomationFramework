package com.erp.baseclass;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.erp.utilities.Log;
import com.erp.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	//public static WebDriver driver;
	
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	
	public static WebDriver getDriver() {  
	    return driver.get();
	}

	public static void setDriver(WebDriver webDriver) {  
	    driver.set(webDriver);
	}
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("chrome") String br) {
	//public void setUp(String br)  {
		try {
		if(br.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			 ChromeOptions options = new ChromeOptions();

			// 🔥 MUST (fresh + clean session)
			 options.addArguments("--disable-notifications");
			 options.addArguments("--disable-popup-blocking");
			 options.addArguments("--disable-infobars");
			 options.addArguments("--disable-extensions");
			 options.addArguments("--disable-features=PasswordLeakDetection");
			 
			// 🔥 Preferences (IMPORTANT)
		    Map<String, Object> prefs = new HashMap<>();
		    
		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);
		    prefs.put("profile.password_manager_leak_detection", false);

		    options.setExperimentalOption("prefs", prefs);
		    
		    setDriver(new ChromeDriver(options));  //Thread
		    
		} else if(br.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		   setDriver(new FirefoxDriver());  // For Thread
		  
		}  else if (br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());   // Thread 
			
		} else {
			
			throw new IllegalArgumentException("Browser not supported : " + br);
		}
		
		Log.info("Launching " + br + " browser");
			 
		getDriver().manage().window().maximize();  
		getDriver().manage().deleteAllCookies();
		getDriver().get(baseURL);	  
		Log.info("Application URL : " + baseURL);
				 
		} catch (Exception e ){
			
			Log.error("Failed to launch browser : " + br, e);
		}
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()	{
		Log.info("Closing Browser");
		if(getDriver()!=null) {  // Thread
			getDriver().quit();
			driver.remove();

		}
	} 
}
