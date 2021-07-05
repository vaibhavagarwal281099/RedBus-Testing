package in.redbus.Tests;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import in.redbus.Pages.SearchPage;
import in.redbus.Utils.CommonUtils;


// includes tests for search page

public class SearchPageTest extends BaseTest{


	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("searchPageSheetName");


	@Test( )
	public void whenUserEntersValidFromAndValidToAndValidDate() throws InterruptedException {

		String testName = "whenUserEntersValidFromAndValidToAndValidDate";

		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();

		String fromLocation = testData.get("From"); 
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedTitle = testData.get("Expected Title");

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		SearchPage searchPage = new SearchPage(driver);

		searchPage.enterFromLocation(fromLocation);
		logger.info(fromLocation+" was entered");
		extentTest.log(LogStatus.INFO, fromLocation+" was entered");

		String actualTitle1 = driver.getTitle().toLowerCase();
		System.out.println(actualTitle1);
		
		searchPage.enterToLocation(toLocation);
		logger.info(toLocation+" was entered");
		extentTest.log(LogStatus.INFO, toLocation+" was entered");

		searchPage.enterDate(dateVal);
		logger.info(dateVal+" date was entered");
		extentTest.log(LogStatus.INFO, dateVal+" date was entered");

		searchPage.clickOnSearchBusesButton();
		logger.info("search buses button was clicked");
		extentTest.log(LogStatus.INFO, "search buses button was clicked");

		// wait
//		new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class).
//		until(ExpectedConditions.urlContains("fromCity"));

		String actualTitle = driver.getTitle().toLowerCase();
		System.out.println(actualTitle);
		logger.info("ActualTitle :"+actualTitle);
		extentTest.log(LogStatus.INFO, "ActualTitle :"+actualTitle);

//		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title of search page.");

		// ----------------------- Test Ends --------------------------------------------------
	}

	@Test()
	public void whenUserEntersValidFromAndInvalidToAndValidDate() throws InterruptedException {

		String testName = "whenUserEntersValidFromAndInvalidToAndValidDate";
		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();

		String fromLocation = testData.get("From"); 
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedTitle = testData.get("Expected Title");

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		SearchPage searchPage = new SearchPage(driver);

		searchPage.enterFromLocation(fromLocation);
		logger.info(fromLocation+" was entered");
		extentTest.log(LogStatus.INFO, fromLocation+" was entered");

		searchPage.enterToLocation(toLocation);
		logger.info(toLocation+" was entered");
		extentTest.log(LogStatus.INFO, toLocation+" was entered");

		searchPage.enterDate(dateVal);
		logger.info(dateVal+" date was entered");
		extentTest.log(LogStatus.INFO, dateVal+" date was entered");


		searchPage.clickOnSearchBusesButton();
		logger.info("search buses button was clicked");
		extentTest.log(LogStatus.INFO, "search buses button was clicked");

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Title :"+actualTitle);
		extentTest.log(LogStatus.INFO, "Title :"+actualTitle);

		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title of search page.");

		// ----------------------- Test Ends --------------------------------------------------
	}

	@Test()
	public void whenUserEntersInvalidFromAndValidToAndValidDate() throws InterruptedException {

		String testName = "whenUserEntersInvalidFromAndValidToAndValidDate";
		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String fromLocation = testData.get("From"); 
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedTitle = testData.get("Expected Title");
		String executionRequired = testData.get("Execution Required").toLowerCase();


		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);


		// Test
		SearchPage searchPage = new SearchPage(driver);

		searchPage.enterFromLocation(fromLocation);
		logger.info(fromLocation+" was entered");
		extentTest.log(LogStatus.INFO, fromLocation+" was entered");

		searchPage.enterToLocation(toLocation);
		logger.info(toLocation+" was entered");
		extentTest.log(LogStatus.INFO, toLocation+" was entered");

		searchPage.enterDate(dateVal);
		logger.info(dateVal+" date was entered");
		extentTest.log(LogStatus.INFO, dateVal+" date was entered");


		searchPage.clickOnSearchBusesButton();
		logger.info("search buses button was clicked");
		extentTest.log(LogStatus.INFO, "search buses button was clicked");


		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Title :"+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Title :"+actualTitle);

		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title of search page.");

		// ----------------------- Test Ends --------------------------------------------------
	}
}
