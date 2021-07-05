package in.redbus.Utils;

// This class contains code for explicit wait

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import in.redbus.Tests.BaseTest;

import org.openqa.selenium.WebDriver;

public class ExplicitWaitElement extends BaseTest {

	// To wait for some seconds explicitly
	public static void checkClickableExplicitly(WebDriver driver, WebElement locator, int timeout) {
		
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).
		until(ExpectedConditions.elementToBeClickable(locator));
		//locator.click();
	}
	
	// Implicit wait - wait for given time and then throw error of no element found
		public static void implicitWait() {
			
			int timeUnit = Integer.valueOf(prop.getProperty("implicitWaitTime"));
//			logger.info("Implicit wait : waited for " + String.valueOf(timeUnit)+ " seconds .");
			
			driver.manage().timeouts().implicitlyWait(timeUnit,TimeUnit.SECONDS); 
		}

		// Explicit wait - wait till certain condition or time is completed
		public static void explicitWait(int time, WebElement locator) {

			WebDriverWait wait = new WebDriverWait(driver,time);
			wait.until(ExpectedConditions.visibilityOf(locator));      
		}
}
