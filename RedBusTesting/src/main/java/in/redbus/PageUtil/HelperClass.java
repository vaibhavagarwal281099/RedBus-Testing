package in.redbus.PageUtil;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HelperClass {

	public static List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
	
	// To select date through calendar on search page
	public static void selectDateThroughCalendarOnSearchPage(WebDriver driver, WebElement dateLocator, String dateVal) {

		// Date Format DD-MM YEAR
		String[] dateValue = dateVal.split("-");

		String date = dateValue[0];
		String monthYear = dateValue[1].toLowerCase();

		// selecting through table - if equal to month and year then select date
		String monthYearTitle;
		WebElement nextButton;
		WebElement calDate;
		boolean requiredDate = false;

		while(!requiredDate) {

			monthYearTitle = driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']//table//td[@class='monthTitle']")).getText().toLowerCase();
			if(monthYear.equals(monthYearTitle)) {

				calDate = driver.findElement(By.xpath("//*[text()='"+date+"']"));
				calDate.click();
				requiredDate = true;
			}
			else {

				nextButton = driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']//button[.='>']")); 
				nextButton.click();
			}
		}

	}

	// selecting proper frame
	public static int selectRequiredIframe(WebDriver driver, String xpathLocator) {

		int frameIndex = 0;
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));

		System.out.println("Total Frames : "+frames.size());
		for(int index = 0; index < frames.size(); index++) {

			driver.switchTo().frame(index);
			int numberOfElements = driver.findElements(By.xpath(xpathLocator)).size();

			// if element found then return frame index
			if(numberOfElements == 0) {

				driver.switchTo().defaultContent();
			}
			else {

				frameIndex = index;
				break;
			}
		}
		// return frame to default
		driver.switchTo().defaultContent();

		return frameIndex;
	}

	// Handling calendar ui at bus hire page 
	public static void selectDateAndTimeAtBusHirePage(WebDriver driver, String dateAndTime) throws Exception {

		
		if(dateAndTime.equals("")) {
			
			throw new Exception("Empty date and time");
		}
		// Date And Time Format DD-MM-YEAR-HH:MM AM/PM
		String[] dateAndTimeValue = dateAndTime.split("-");

		String date = dateAndTimeValue[0];
		int monthNumber = Integer.parseInt(dateAndTimeValue[1]); 
		String monthName = months.get(monthNumber-1);
		String YYYY = dateAndTimeValue[2];

		String time = dateAndTimeValue[3];

		// splitting the time
		String[] timeValue = time.split(":");
		String HH = timeValue[0];

		// splitting AM or PM
		String[] amOrpmList = timeValue[1].split(" ");
		String MM = amOrpmList[0];
		String AMorPM = amOrpmList[1];



		// handling exceptions for Minute
		//		int minuteVal = Integer.parseInt(MM);
		//		if(minuteVal != 0 || minuteVal != 15 || minuteVal != 30 || minuteVal != 45) {
		//			
		//			throw new Exception(MM+" minutes can't be selected");
		//		}


		// selecting through table - if equal to month and year then select date
		String monthYear = monthName.concat(" "+YYYY);
		String monthYearTitle;

		WebElement nextButton;
		//WebElement prevButton;
		WebElement okButton;

		WebElement calDay;
		WebElement calHH;
		WebElement calMM;
		WebElement calAMorPM;

		boolean requiredDate = false;
		try {

			Thread.sleep(500);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}


		while(!requiredDate) {

			monthYearTitle = driver.findElement(By.xpath("//div[@class='MuiPickersCalendarHeader-switchHeader']//p")).getText();
			if(monthYear.equals(monthYearTitle)) {
								
				
				// selecting day
				calDay = driver.findElement(By.xpath("//*[text() = '"+date+"' and @class = 'MuiTypography-root MuiTypography-body2 MuiTypography-colorInherit']"));
				calDay.click();
				
				// selecting time HH
				calHH = driver.findElement(By.xpath("//*[text() = '"+HH+"' and @class = 'MuiTypography-root MuiPickersClockNumber-clockNumber MuiTypography-body1']"));
				Actions actionHH =  new Actions(driver);
				actionHH.moveToElement(calHH).click().perform();
				
				
				try {

					Thread.sleep(500);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}

				// selecting time MM
				calMM = driver.findElement(By.xpath("//*[text() = '"+MM+"' and @class = 'MuiTypography-root MuiPickersClockNumber-clockNumber MuiTypography-body1']"));
				Actions actionMM =  new Actions(driver);
				actionMM.moveToElement(calMM).click().perform();
				

				// selecting time AMorPM
				calAMorPM = driver.findElement(By.xpath("//*[text() = '"+AMorPM+"']"));
				Actions actionAM =  new Actions(driver);
				actionAM.moveToElement(calAMorPM).click().perform();
	
				// click on ok button
				okButton = driver.findElement(By.xpath("//div[@class= 'MuiDialogActions-root MuiDialogActions-spacing']//button[2]"));
				okButton.click();
				
				requiredDate = true;
			}
			else {

				nextButton = driver.findElement(By.xpath("//div[@class='MuiPickersCalendarHeader-switchHeader']//button[2]")); 
				nextButton.click();
			}
		}


	}
}
