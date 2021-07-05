package in.redbus.Tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.redbus.Pages.HomePage;
import in.redbus.Utils.CommonUtils;

public class HomePageTest extends BaseTest{


	private String sheetName = prop.getProperty("homePageSheetName"); 
	
	@Test()
	public void whenUserClickOnRPoolLink() {

		String testName = "whenUserClickOnRPoolLink";

		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName, testName+" started");

//		 Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String expectedTitle = testData.get("Expected Title");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String desc = testData.get("Description");

		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		HomePage homePage = new HomePage(driver);

		homePage.clickOnRPoolLink();;
		logger.info("RPool was clicked");
		extentTest.log(LogStatus.INFO, "RPool was clicked");

		String actualTitle = driver.getTitle().toLowerCase();
		System.out.println(actualTitle);
		logger.info("Title :"+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Title : "+actualTitle);


		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title of search page.");
		extentTest.log(LogStatus.INFO, desc);

		// ----------------------- Test Ends --------------------------------------------------
	}

	@Test()
	public void whenUserClickOnBusHireLink() {


		String testName = "whenUserClickOnBusHireLink";

		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName, testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String expectedTitle = testData.get("Expected Title");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusHireLink();
		logger.info("BusHireLink was clicked");
		extentTest.log(LogStatus.INFO, "BusHireLink was clicked");

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Title :"+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Title :"+actualTitle);

		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title of search page.");

		// ----------------------- Test Ends --------------------------------------------------
	}

	@Test()
	public void whenUserClickOnRedBusLogo() {

		String testName = "whenUserClickOnRedBusLogo";

		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName, testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String expectedTitle = testData.get("Expected Title");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		HomePage homePage = new HomePage(driver);

		homePage.clickOnRedBusLogo();
		logger.info("RedBusLogo was clicked");
		extentTest.log(LogStatus.INFO, "RedBusLogo was clicked");

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Title :"+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Title :"+actualTitle);

		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title of search page.");

		// ----------------------- Test Ends --------------------------------------------------
	}

	@Test()
	public void whenUserClickOnBusTicketLink() {

		String testName = "whenUserClickOnBusTicketLink";

		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName, testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String expectedTitle = testData.get("Expected Title");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusTicketsLink();;
		logger.info("BusTickets Link was clicked");
		extentTest.log(LogStatus.INFO, "BusTickets Link was clicked");

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Title :"+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Title :"+actualTitle);

		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title of search page.");

		// ----------------------- Test Ends --------------------------------------------------
	}
}
