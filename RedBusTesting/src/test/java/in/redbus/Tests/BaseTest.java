package in.redbus.Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import in.redbus.Utils.ExcelFileIO;
import in.redbus.Utils.UseScreenshots;
import in.redbus.Utils.DockerClass;

public class BaseTest {
	
	// Log4j logger
	public final static Logger logger = Logger.getLogger(BaseTest.class);

	protected static WebDriver driver;
	public static ExtentTest extentTest;
	
	static File file = new File(".\\Resources\\configuration.properties");
	static FileInputStream fis = null;
	
	// Excel File Test Data Reader
	public static ExcelFileIO reader = null;
	public static ExtentReports extentReport = null;
	
	
	
	protected static Properties prop = new Properties();

	static {
		try {
			fis = new FileInputStream(file);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Exception Handling for Excel File
				try {

					reader = new ExcelFileIO(prop.getProperty("testDataFileLocation"));
				}
				catch(Exception e) {

					logger.error(e.getMessage());
				}
	}
	
	
	@BeforeSuite
	public void setExtent() {
		extentReport = new ExtentReports(".\\Reports\\ExtentReport.html");
	}
	
	@AfterSuite
	public void endExtent() {
		extentReport.flush();
	}

///*
	@BeforeMethod
	public static void intializeWebDriver() {

		 String browserName=prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome"))
        {
            String options = prop.getProperty("headlessMode");
            Boolean opt = Boolean.parseBoolean(options.toLowerCase());
            System.setProperty("webdriver.chrome.driver", "./Resources/Drivers/chromedriver.exe");
            ChromeOptions chromeoption = new ChromeOptions();
            chromeoption.setHeadless(opt);
            driver = new ChromeDriver(chromeoption); // driver to open Chrome
            
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            String options_headless = prop.getProperty("headlessMode");
            Boolean opt_headless = Boolean.parseBoolean(options_headless.toLowerCase());
            System.setProperty("webdriver.gecko.driver", "./Resources/Drivers/geckodriver.exe");
            FirefoxOptions foxoption = new FirefoxOptions();
            foxoption.setHeadless(opt_headless);
            driver = new FirefoxDriver(foxoption); // driver to open firefox
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        
    }
//*/
	
//	@BeforeMethod
	public void initDriver() throws MalformedURLException {

		
		boolean headlessMode = Boolean.parseBoolean(prop.getProperty("headlessMode"));
		boolean runOnDocker = Boolean.parseBoolean(prop.getProperty("runOnDocker"));

		// to run on docker
		if(runOnDocker) {

			if(headlessMode) {
				
				 driver = DockerClass.startBrowserInHeadlessInDocker();
			}
			else {
				
				driver = DockerClass.startBrowserInNonHeadlessInDocker();
				
			}
		}
		else {

			if(headlessMode) {
				
				driver = DockerClass.startBrowserInHeadlessInLocal();
				
			}
			else {
				
				driver = DockerClass.startBrowserInNonHeadlessInLocal();
				
			}
		}
	}

	// depends on initDriver()
	@BeforeMethod    //(dependsOnMethods = "initDriver")
	public void setUp() {

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		if(!prop.getProperty("browser").equals("firefox")) {
			
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("globalWait")), TimeUnit.SECONDS);
			
		}
		// implicit wait will be for all elements 
		
		driver.get(prop.getProperty("testUrl"));
		
		logger.info(prop.getProperty("testUrl")+" page opened...");


	}



	
	
	
	@AfterMethod
	public static void closeBrowser() {

		driver.quit();
	}
	

	
	@AfterMethod
	public void attachScreenshot(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshotPath = UseScreenshots.getScreenshot(driver, result.getName());
			System.out.println(screenshotPath);
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case passed successfully");
		}
		extentReport.endTest(extentTest);
	}

}
