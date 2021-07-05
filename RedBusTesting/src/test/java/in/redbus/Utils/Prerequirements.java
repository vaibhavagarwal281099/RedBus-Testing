package in.redbus.Utils;

import java.util.HashMap;

import in.redbus.Pages.BusHirePage;
import in.redbus.Pages.*;
import in.redbus.Tests.BaseTest;

public class Prerequirements extends BaseTest {

	public static void preRequirementForTripSummary() throws InterruptedException {

		// Worksheet Name used by all tests
		String sheetName = prop.getProperty("busHirePageSheetName");
		String testName = "whenUserEntersValidInformationForOutstation";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String pickUpLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String numberOfPassengers = testData.get("Number of Passengers");
		String fromDateAndTimeVal = testData.get("From Date and Time");
		String tillDateAndTimeVal = testData.get("Till Date and Time");
		//String expectedResult = testData.get("Expected Result");

		// log all data
		CommonUtils.logTestData(sheetName, testName);

		// Test
		BusHirePage busHirePage = new BusHirePage(driver);

		HomePage homePage = new HomePage(driver);

		homePage.clickOnBusHireLink();;
//		logger.info("Bus Hire link was clicked");

		busHirePage.clickOnOutstationMenu();
//		logger.info("OutStation Menu was selected");

		busHirePage.enterPickUpLocation(pickUpLocation);
//		logger.info(pickUpLocation+" location was entered");

		busHirePage.enterDropLocation(destinationLocation);
//		logger.info(destinationLocation+" location was entered");

		busHirePage.enterDateAndTimeForOutstation(fromDateAndTimeVal, tillDateAndTimeVal);;
//		logger.info(fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");

		busHirePage.enterNumberOfPassengers(numberOfPassengers);
//		logger.info(numberOfPassengers+" was entered");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		busHirePage.clickOnProceedButtonOnOutstationMenu();
//		logger.info("Proceed Button was clicked");
	}
}
