package in.redbus.Tests;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.redbus.Pages.TripSummaryPage;
import in.redbus.Utils.CommonUtils;
import in.redbus.Utils.Prerequirements;

public class TripSummaryPageTest extends BaseTest {


	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("tripSummaryPageSheetName");

	

	@Test()
	public void whenUserEntersValidDetail() throws InterruptedException {
		
		String testName = "whenUserEntersValidDetail";
		
		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");
		
		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String name = testData.get("Name");
		String email = testData.get("EmailID");
		String phone = testData.get("MobileNumber");
		String additionalInfo = testData.get("AdditionalInfo");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		
		// log all data
		CommonUtils.logTestData(sheetName, testName);
		
		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		TripSummaryPage tripSummaryPage = new TripSummaryPage(driver);
		
		// Test
		Prerequirements.preRequirementForTripSummary();
		logger.info("Prerequirement for trip summary was executed successfully");
		extentTest.log(LogStatus.INFO, "Prerequirement for trip summary was executed successfully");
		
		tripSummaryPage.enterName(name);
		logger.info(name+" was entered in name field");
		extentTest.log(LogStatus.INFO, name+" was entered in name field");
		
		tripSummaryPage.enterEmail(email);;
		logger.info(email+" was entered in email field");
		extentTest.log(LogStatus.INFO, email+" was entered in email field");
		
		tripSummaryPage.enterMobile(phone);;
		logger.info(phone+" was entered in mobile number field");
		extentTest.log(LogStatus.INFO, phone+" was entered in mobile number field");
		
		tripSummaryPage.enterAdditionalInfo(additionalInfo);
		logger.info(additionalInfo+" was entered in additionalInfo field");
		extentTest.log(LogStatus.INFO, additionalInfo+" was entered in additionalInfo field");
		
		tripSummaryPage.clickOnProceedButton();
		logger.info("Proceed button on trip summary page was clicked");
		extentTest.log(LogStatus.INFO, "Proceed button on trip summary page was clicked");
		
		// ----------------------- Test Ends --------------------------------------------------

	}
	
	
	@Test()
	public void whenUserEntersInvalidMobileNumber() throws InterruptedException {
		
		String testName = "whenUserEntersInvalidMobileNumber";
		// ----------------------- Test Starts --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName,  testName+" started");
		
		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String name = testData.get("Name");
		String email = testData.get("EmailID");
		String phone = testData.get("MobileNumber");
		String additionalInfo = testData.get("AdditionalInfo");
		String expectedResult = testData.get("Expected Result").toLowerCase();
		String executionRequired = testData.get("Execution Required").toLowerCase();
		
		// log all data
		CommonUtils.logTestData(sheetName, testName);
		
		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		// Test
		Prerequirements.preRequirementForTripSummary();
		logger.info("Prerequirement for trip summary was executed successfully");
		extentTest.log(LogStatus.INFO, "Prerequirement for trip summary was executed successfully");
		
		TripSummaryPage tripSummaryPage = new TripSummaryPage(driver);
		
		tripSummaryPage.enterName(name);
		logger.info(name+" was entered in name field");
		extentTest.log(LogStatus.INFO, name+" was entered in name field");
		
		tripSummaryPage.enterEmail(email);;
		logger.info(email+" was entered in email field");
		extentTest.log(LogStatus.INFO, email+" was entered in email field");
		
		tripSummaryPage.enterMobile(phone);;
		logger.info(phone+" was entered in mobile number field");
		extentTest.log(LogStatus.INFO, phone+" was entered in mobile number field");
		
		tripSummaryPage.enterAdditionalInfo(additionalInfo);
		logger.info(additionalInfo+" was entered in additionalInfo field");
		extentTest.log(LogStatus.INFO, additionalInfo+" was entered in additionalInfo field");
		
		tripSummaryPage.clickOnProceedButton();
		logger.info("Proceed button on trip summary page was clicked");
		extentTest.log(LogStatus.INFO, "Proceed button on trip summary page was clicked");
		
		String actualResult = tripSummaryPage.fetchHeaderSummary();
		logger.info(actualResult+" was fetched from trip summary header");
		extentTest.log(LogStatus.INFO, actualResult+" was fetched from trip summary header");
		
		Assert.assertTrue(actualResult.contains(expectedResult), "Assertion on the trip summary header");
		// ----------------------- Test Ends --------------------------------------------------

	}
	
	}
