package in.redbus.Utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import in.redbus.Tests.BaseTest;

// have methods needed by docker
public class DockerClass extends BaseTest{
	
	// variables needed by all methods
	public static RemoteWebDriver remoteDriver;
	public static WebDriver webDriver;
	public static DesiredCapabilities caps;
	private static String browserName = prop.getProperty("browser").toLowerCase() ;
	
	public DockerClass() throws Exception {
		
		// check for browsername
		if(browserName.equals("chrome")||browserName.equals("firefox")||browserName.equals("ie")) {
			
			logger.info("Browser supported");
		}
		else {
			
			System.out.println(browserName);
			logger.error("Browser not supported");
			throw new Exception("Browser not supported");
		}
	}


	// To start different browsers
	public static RemoteWebDriver startBrowserInHeadlessInDocker() throws MalformedURLException {
		
		ChromeOptions chromeOptions = null;
		FirefoxOptions firefoxOptions = null;
		InternetExplorerOptions ieOptions = null;

		if(browserName.equals("chrome")) {
			
			caps = DesiredCapabilities.chrome();
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("headless");
			chromeOptions.merge(caps);
			remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions);
		}
		
		else if(browserName.equals("firefox")) {
			
			caps = DesiredCapabilities.firefox();
			firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("headless");
			firefoxOptions.merge(caps);
			remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),firefoxOptions);
		}
		
		else if(browserName.equals("ie")) {
			
			caps = DesiredCapabilities.internetExplorer();
			ieOptions = new InternetExplorerOptions();
//			ieOptions.addArguments("headless");
			ieOptions.merge(caps);
			remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),ieOptions);
		}
		
		
		return remoteDriver;
	}
	
	// To start different browsers in nonheadless
	public static RemoteWebDriver startBrowserInNonHeadlessInDocker() throws MalformedURLException {
		
		if(browserName.equals("chrome")) {
			
			caps = DesiredCapabilities.chrome();
		}
		
		else if(browserName.equals("firefox")) {
			
			caps = DesiredCapabilities.firefox();
		}
		
		else if(browserName.equals("ie")) {
			
			caps = DesiredCapabilities.internetExplorer();
		}
		
		remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps);
		
		return remoteDriver;
	}
	
public static WebDriver startBrowserInHeadlessInLocal() {
		
		ChromeOptions chromeOptions = null;
		FirefoxOptions firefoxOptions = null;
		InternetExplorerOptions ieOptions = null;

		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","./Resources/drivers/chromedriver.exe");
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("headless");
			webDriver = new ChromeDriver(chromeOptions);
		}
		
		else if(browserName.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver","./Resources/drivers/geckodriver.exe");
			firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(true);
//			firefoxOptions.addArguments("headless");
			webDriver = new FirefoxDriver(firefoxOptions);
		}
		
		else if(browserName.equals("ie")) {
			
			System.setProperty("webdriver.ie.driver","./Resources/drivers/IEDriverServer.exe");
			ieOptions = new InternetExplorerOptions();
			
			logger.info("IE doesn't support headless mode .... starting normal");
			// ieOptions.merge(caps);
			webDriver = new InternetExplorerDriver(ieOptions);
		}
		
		
		return webDriver;
	}
	
	// To start different browsers in nonheadless
	public static WebDriver startBrowserInNonHeadlessInLocal() {
		
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","./Resources/drivers/chromedriver.exe");
			webDriver = new ChromeDriver();
			logger.info("Chrome driver initiated in head mode");
		}
		
		else if(browserName.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver","./Resources/drivers/geckodriver.exe");
			webDriver = new FirefoxDriver();
			logger.info("Firefox driver initiated in head mode");
			
		}
		
		else if(browserName.equals("ie")) {
			
			System.setProperty("webdriver.ie.driver","./Resources/drivers/IEDriverServer.exe");
			webDriver = new InternetExplorerDriver();
			logger.info("IE driver initiated in head mode");
		}
		
		
		return webDriver;
	}
}
