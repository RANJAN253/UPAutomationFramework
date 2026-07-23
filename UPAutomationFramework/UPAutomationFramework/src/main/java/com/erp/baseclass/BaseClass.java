package com.erp.baseclass;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.erp.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	ReadConfig readconfig=new ReadConfig();
		
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	
	@Parameters("browser")
	@BeforeClass
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
		    
		    driver = new ChromeDriver(options);
			
		} else if(br.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  driver= new FirefoxDriver();
		  
		}  else if (br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		} else {
			
			System.out.println("Browser not supported");
		}
			 
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.get(baseURL);
		 
		logger.info("Application URL Opened:" + baseURL);
		 
		} catch (Exception e ){
			
			logger.error("Error during browser setup:" + e.getMessage());
		}
	}
	
	@AfterClass()
	public void tearDown()	{
		
		if(driver !=null) {
				
		driver.quit();
		logger.info("Browser Closed");
		}
	} 
}
