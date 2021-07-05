package in.redbus.Tests;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.redbus.Pages.BusHirePage;

import in.redbus.Pages.HomePage;
import in.redbus.Utils.CommonUtils;

public class BusHirePageTest extends BaseTest{

	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("busHirePageSheetName");

	// test case for valid outstation info
	@Test()
	public void whenUserEntersValidInformationForOutstation() throws InterruptedException {

		String testName = "whenUserEntersValidInformationForOutstation";

		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String pickUpLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String numberOfPassengers = testData.get("Number of Passengers");
		String fromDateAndTimeVal = testData.get("From Date and Time");
		String tillDateAndTimeVal = testData.get("Till Date and Time");
		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		BusHirePage busHirePage = new BusHirePage(driver);

		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusHireLink();;
		logger.info("Bus Hire link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Hire link was clicked");

		busHirePage.clickOnOutstationMenu();
		logger.info("OutStation Menu was selected");
		extentTest.log(LogStatus.INFO, "OutStation Menu was selected");

		busHirePage.enterPickUpLocation(pickUpLocation);
		logger.info(pickUpLocation+" location was entered");
		extentTest.log(LogStatus.INFO, pickUpLocation+" location was entered");

		busHirePage.enterDropLocation(destinationLocation);
		logger.info(destinationLocation+" location was entered");
		extentTest.log(LogStatus.INFO, destinationLocation+" location was entered");

		busHirePage.enterDateAndTimeForOutstation(fromDateAndTimeVal, tillDateAndTimeVal);;
		logger.info(fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");
		extentTest.log(LogStatus.INFO, fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");

		busHirePage.enterNumberOfPassengers(numberOfPassengers);
		logger.info(numberOfPassengers+" was entered");
		extentTest.log(LogStatus.INFO, numberOfPassengers+" was entered");

		busHirePage.clickOnProceedButtonOnOutstationMenu();
		logger.info("Proceed Button was clicked");
		extentTest.log(LogStatus.INFO, "Proceed Button was clicked");

		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabelsummary']")).getText().toLowerCase();
		logger.info("Actual Result : "+actualResult);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualResult);

//		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");

		// ----------------------- Test Ends --------------------------------------------------
	}

	// test case for invalid from location
	@Test()
	public void whenUserDoesNotEnterFromLocationForOutstation() throws InterruptedException {

		String testName = "whenUserDoesNotEnterFromLocationForOutstation";
		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		//String pickUpLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String numberOfPassengers = testData.get("Number of Passengers");
		String fromDateAndTimeVal = testData.get("From Date and Time");
		String tillDateAndTimeVal = testData.get("Till Date and Time");
		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		BusHirePage busHirePage = new BusHirePage(driver);

		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusHireLink();;
		logger.info("Bus Hire link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Hire link was clicked");

		busHirePage.clickOnOutstationMenu();
		logger.info("OutStation Menu was selected");
		extentTest.log(LogStatus.INFO, "OutStation Menu was selected");

		// doesn't enter from location

		busHirePage.enterDropLocation(destinationLocation);
		logger.info(destinationLocation+" location was entered");
		extentTest.log(LogStatus.INFO, destinationLocation+" location was entered");

		busHirePage.enterDateAndTimeForOutstation(fromDateAndTimeVal, tillDateAndTimeVal);;
		logger.info(fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");
		extentTest.log(LogStatus.INFO, fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");

		busHirePage.enterNumberOfPassengers(numberOfPassengers);
		logger.info(numberOfPassengers+" was entered");
		extentTest.log(LogStatus.INFO, numberOfPassengers+" was entered");

		busHirePage.clickOnProceedButtonOnOutstationMenu();
		logger.info("Proceed Button was clicked");
		extentTest.log(LogStatus.INFO, "Proceed Button was clicked");

		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabel']")).getText().toLowerCase();
		logger.info("Actual Result : "+actualResult);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");
		// ----------------------- Test Ends --------------------------------------------------
	}

	// test case for invalid to location
	@Test()
	public void whenUserDoesNotEnterToLocationForOutstation() throws InterruptedException {

		String testName = "whenUserDoesNotEnterToLocationForOutstation";
		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String pickUpLocation = testData.get("Pickup Location");
		//String destinationLocation = testData.get("Destination Location");
		String numberOfPassengers = testData.get("Number of Passengers");
		String fromDateAndTimeVal = testData.get("From Date and Time");
		String tillDateAndTimeVal = testData.get("Till Date and Time");
		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		BusHirePage busHirePage = new BusHirePage(driver);

		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusHireLink();;
		logger.info("Bus Hire link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Hire link was clicked");

		busHirePage.clickOnOutstationMenu();
		logger.info("OutStation Menu was selected");
		extentTest.log(LogStatus.INFO, "OutStation Menu was selected");

		busHirePage.enterPickUpLocation(pickUpLocation);
		logger.info(pickUpLocation+" location was entered");
		extentTest.log(LogStatus.INFO, pickUpLocation+" location was entered");

		// doesn't enter to location

		busHirePage.enterDateAndTimeForOutstation(fromDateAndTimeVal, tillDateAndTimeVal);;
		logger.info(fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");
		extentTest.log(LogStatus.INFO, fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");

		busHirePage.enterNumberOfPassengers(numberOfPassengers);
		logger.info(numberOfPassengers+" was entered");
		extentTest.log(LogStatus.INFO, numberOfPassengers+" was entered");

		busHirePage.clickOnProceedButtonOnOutstationMenu();
		logger.info("Proceed Button was clicked");
		extentTest.log(LogStatus.INFO, "Proceed Button was clicked");

		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabel']")).getText().toLowerCase();
		logger.info("Actual Result : "+actualResult);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");
		// ----------------------- Test Ends --------------------------------------------------
	}

	// test case for invalid from date and time
	@Test()
	public void whenUserDoesNotEnterFromDateAndTimeForOutstation() throws InterruptedException {

		String testName = "whenUserDoesNotEnterFromDateAndTimeForOutstation";
		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String pickUpLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String numberOfPassengers = testData.get("Number of Passengers");
		String fromDateAndTimeVal = testData.get("From Date and Time");
		String tillDateAndTimeVal = testData.get("Till Date and Time");
		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// log all data
		CommonUtils.logTestData(sheetName, testName);
		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		BusHirePage busHirePage = new BusHirePage(driver);

		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusHireLink();;
		logger.info("Bus Hire link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Hire link was clicked");

		busHirePage.clickOnOutstationMenu();
		logger.info("OutStation Menu was selected");
		extentTest.log(LogStatus.INFO, "OutStation Menu was selected");

		busHirePage.enterPickUpLocation(pickUpLocation);
		logger.info(pickUpLocation+" location was entered");
		extentTest.log(LogStatus.INFO, pickUpLocation+" location was entered");

		busHirePage.enterDropLocation(destinationLocation);
		extentTest.log(LogStatus.INFO, destinationLocation+" location was entered");
		logger.info(destinationLocation+" location was entered");

		busHirePage.enterDateAndTimeForOutstation(fromDateAndTimeVal, tillDateAndTimeVal);;
		logger.info(fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");
		extentTest.log(LogStatus.INFO, fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");

		busHirePage.enterNumberOfPassengers(numberOfPassengers);
		logger.info(numberOfPassengers+" was entered");
		extentTest.log(LogStatus.INFO, numberOfPassengers+" was entered");

		busHirePage.clickOnProceedButtonOnOutstationMenu();
		logger.info("Proceed Button was clicked");
		extentTest.log(LogStatus.INFO, "Proceed Button was clicked");

		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabel']")).getText().toLowerCase();
		logger.info("Actual Result : "+actualResult);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");
		// ----------------------- Test Ends --------------------------------------------------
	}

	// test case for invalid till date and time
	@Test()
	public void whenUserDoesNotEnterTillDateAndTimeForOutstation() throws InterruptedException {

		String testName = "whenUserDoesNotEnterTillDateAndTimeForOutstation";
		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String pickUpLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String numberOfPassengers = testData.get("Number of Passengers");
		String fromDateAndTimeVal = testData.get("From Date and Time");
		String tillDateAndTimeVal = testData.get("Till Date and Time");
		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		BusHirePage busHirePage = new BusHirePage(driver);

		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusHireLink();;
		logger.info("Bus Hire link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Hire link was clicked");

		busHirePage.clickOnOutstationMenu();
		logger.info("OutStation Menu was selected");
		extentTest.log(LogStatus.INFO, "Bus Hire link was clicked");

		busHirePage.enterPickUpLocation(pickUpLocation);
		logger.info(pickUpLocation+" location was entered");
		extentTest.log(LogStatus.INFO, pickUpLocation+" location was entered");

		busHirePage.enterDropLocation(destinationLocation);
		logger.info(destinationLocation+" location was entered");
		extentTest.log(LogStatus.INFO, destinationLocation+" location was entered");

		busHirePage.enterDateAndTimeForOutstation(fromDateAndTimeVal, tillDateAndTimeVal);;
		logger.info(fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");
		extentTest.log(LogStatus.INFO, fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");

		busHirePage.enterNumberOfPassengers(numberOfPassengers);
		logger.info(numberOfPassengers+" was entered");
		extentTest.log(LogStatus.INFO, numberOfPassengers+" was entered");

		busHirePage.clickOnProceedButtonOnOutstationMenu();
		logger.info("Proceed Button was clicked");
		extentTest.log(LogStatus.INFO, "Proceed Button was clicked");

		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabel']")).getText().toLowerCase();
		logger.info("Actual Result : "+actualResult);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");
		// ----------------------- Test Ends --------------------------------------------------

	}

	// test case for passenger number greater than 60
	@Test()
	public void whenUserEntersPassengerNumberGreaterThan60ForOutstation() throws InterruptedException {

		String testName = "whenUserEntersPassengerNumberGreaterThan60ForOutstation";
		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String pickUpLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String numberOfPassengers = testData.get("Number of Passengers");
		String fromDateAndTimeVal = testData.get("From Date and Time");
		String tillDateAndTimeVal = testData.get("Till Date and Time");
		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		BusHirePage busHirePage = new BusHirePage(driver);

		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusHireLink();;
		logger.info("Bus Hire link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Hire link was clicked");

		busHirePage.clickOnOutstationMenu();
		logger.info("OutStation Menu was selected");
		extentTest.log(LogStatus.INFO, "OutStation Menu was selected");

		busHirePage.enterPickUpLocation(pickUpLocation);
		logger.info(pickUpLocation+" location was entered");
		extentTest.log(LogStatus.INFO, pickUpLocation+" location was entered");

		busHirePage.enterDropLocation(destinationLocation);
		logger.info(destinationLocation+" location was entered");
		extentTest.log(LogStatus.INFO, destinationLocation+" location was entered");

		busHirePage.enterDateAndTimeForOutstation(fromDateAndTimeVal, tillDateAndTimeVal);;
		logger.info(fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");
		extentTest.log(LogStatus.INFO, fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");

		busHirePage.enterNumberOfPassengers(numberOfPassengers);
		logger.info(numberOfPassengers+" was entered");
		extentTest.log(LogStatus.INFO, numberOfPassengers+" was entered");

		busHirePage.clickOnProceedButtonOnOutstationMenu();
		extentTest.log(LogStatus.INFO, "Proceed Button was clicked");
		logger.info("Proceed Button was clicked");

		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabel']")).getText().toLowerCase();
		logger.info("Actual Result : "+actualResult);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");
		// ----------------------- Test Ends --------------------------------------------------
	}

	// test case for LocalMenu
	@Test()
	public void whenUserClickedOnLocalMenu() {

		String testName = "whenUserClickedOnLocalMenu";
		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// Test
		BusHirePage busHirePage = new BusHirePage(driver);

		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusHireLink();;
		logger.info("Bus Hire link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Hire link was clicked");

		busHirePage.clickOnLocalMenu();
		logger.info("Local Menu was selected");
		extentTest.log(LogStatus.INFO, "Local Menu was selected");

		
		try {
			
			Thread.sleep(5000);
		}
		catch(Exception e){
			
		}
		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabel']")).getText().toLowerCase();
		logger.info("Actual Result : "+actualResult);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");
		// ----------------------- Test Ends --------------------------------------------------
	}

//	 test case for AirportMenu
	@Test()
	public void whenUserClickedOnAirportMenu() {

		String testName = "whenUserClickedOnAirportMenu";
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
		BusHirePage busHirePage = new BusHirePage(driver);

		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusHireLink();;
		logger.info("Bus Hire link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Hire link was clicked");

		busHirePage.clickOnAirportMenu();
		logger.info("Airport Menu was selected");
		extentTest.log(LogStatus.INFO, "Airport Menu was selected");
		
		// wait
		new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).
		until(ExpectedConditions.titleIs("Bus Hire: Rent Volvo, AC buses, Mini Buses, Tempo Travellers & Innova Cars - Book Online"));
		

		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabel']")).getText().toLowerCase();
		logger.info("Actual Result : "+actualResult);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");
		// ----------------------- Test Ends --------------------------------------------------
	}
}
