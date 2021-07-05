package in.redbus.Utils;

import java.util.HashMap;

import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

import in.redbus.Tests.BaseTest;

// includes common utilities required by all project

public class CommonUtils extends BaseTest {

	// Show Test Data
	public static void logTestData(String worksheetName, String testCaseName) {


		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(worksheetName, testCaseName);

		// Print all data
//		logger.info("----------------------------------------------------------------------");
		extentTest.log(LogStatus.INFO, "--------------------------- Test Data -------------------------------");

//		logger.info("Test Data For Worksheet Name "+worksheetName+" And For Test Case "+testCaseName);
		extentTest.log(LogStatus.INFO, "Test Data For Worksheet Name "+worksheetName+" And For Test Case "+testCaseName);

		for (HashMap.Entry<String, String> entry : testData.entrySet()) {

			if(entry.getKey() != "" && entry.getValue() != "") {
//				logger.info(entry.getKey() + " : " + entry.getValue().toString());
				extentTest.log(LogStatus.INFO, entry.getKey() + " : " + entry.getValue().toString());

			}
		}

//		logger.info("----------------------------------------------------------------------");
		extentTest.log(LogStatus.INFO, "----------------------------------------------------------------------");

	}
	
	// function toCheckExecutionRequired
	public static void toCheckExecutionRequired(String executionRequired) {
		
		// if execution required field is no
		if(executionRequired.equals("no")) {
			
			extentTest.log(LogStatus.WARNING, "Execution Required : "+executionRequired.toUpperCase());
//			logger.info("Execution required is no , skipping the test");
			throw new SkipException("Skipping this exception");
		}
		
		// if execution required field is empty
		if(executionRequired.equals("")) {
			
			extentTest.log(LogStatus.WARNING, "Execution Required : "+executionRequired.toUpperCase());
//			logger.info("Execution required is empty , skipping the test");
			throw new SkipException("Skipping this exception");
		}
	}
	
	
}
