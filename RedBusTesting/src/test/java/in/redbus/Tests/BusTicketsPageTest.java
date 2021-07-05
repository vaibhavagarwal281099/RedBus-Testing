package in.redbus.Tests;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.redbus.Pages.BusTicketsPage;
import in.redbus.Pages.HomePage;
import in.redbus.Utils.CommonUtils;

public class BusTicketsPageTest extends BaseTest {

	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("busTicketsPageSheetName");



	@Test()
	public void whenUserClicksOnCancellationLink() {

		String testName = "whenUserClicksOnCancellationLink";

		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		
		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		BusTicketsPage busTicketsPage = new BusTicketsPage(driver);

		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusTicketsLink();
		logger.info("Bus Tickets link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Tickets link was clicked");
		
		busTicketsPage.clickOnCancelTicketButton();
		logger.info("Cancel Ticket was clicked");
		extentTest.log(LogStatus.INFO, "Cancel Ticket was clicked");
		
		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("ActualTitle :"+actualTitle);
		extentTest.log(LogStatus.INFO, "ActualTitle :"+actualTitle);
		
		Assert.assertTrue(actualTitle.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header");
		// ----------------------- Test Ends --------------------------------------------------
	}

	@Test()
	public void whenUserClicksOnPrintTicket() {

		String testName = "whenUserClicksOnPrintTicket";
		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		BusTicketsPage busTicketsPage = new BusTicketsPage(driver);

		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusTicketsLink();
		logger.info("Bus Tickets link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Tickets link was clicked");
		
		busTicketsPage.clickOnPrintTicket();;
		logger.info("Print Ticket was clicked");
		extentTest.log(LogStatus.INFO, "Print Ticket was clicked");
		
		String actualResult = driver.findElement(By.xpath("//*[@class = 'header']")).getText().toLowerCase();
		logger.info("ActualTitle :"+actualResult);
		extentTest.log(LogStatus.INFO, "ActualTitle :"+actualResult);
		
		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header");
		// ----------------------- Test Ends --------------------------------------------------

	}

	@Test()
	public void whenUserEnterValidInfoInSearchBus() {

		String testName = "whenUserEnterValidInfoInSearchBus";
		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String expectedResult = testData.get("Expected Result");
		String from = testData.get("From");
		String to = testData.get("To");
		String dateVal = testData.get("Date");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);


		// Test
		BusTicketsPage busTicketsPage = new BusTicketsPage(driver);

		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusTicketsLink();
		logger.info("Bus Tickets link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Tickets link was clicked");
		
		busTicketsPage.enterSrcData(from);
		logger.info(from+" location was entered");
		extentTest.log(LogStatus.INFO, from+" location was entered");
		
		busTicketsPage.enterDestData(to);
		logger.info(to+" location was entered");
		extentTest.log(LogStatus.INFO, to+" location was entered");
		
		busTicketsPage.enterDate(dateVal);
		logger.info(dateVal+" date was entered");
		extentTest.log(LogStatus.INFO, dateVal+" date was entered");
		
		busTicketsPage.clickOnSearchBusesButton();
		logger.info("Search Buses was clicked");
		extentTest.log(LogStatus.INFO, "Search Buses was clicked");
		
		String actualResult = driver.getTitle().toLowerCase();
		logger.info("ActualTitle :"+actualResult);
		extentTest.log(LogStatus.INFO, "ActualTitle :"+actualResult);
		
		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected title");
		// ----------------------- Test Ends --------------------------------------------------
	}
}
