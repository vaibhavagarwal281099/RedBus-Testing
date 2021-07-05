package in.redbus.Pages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import in.redbus.PageUtil.HelperClass;

// includes flow and elements required for search page
public class SearchPage {

	public WebDriver driver;

	public SearchPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Element and Flow for searching buses in search page

	@FindBy(how = How.ID, using = "src")
	private WebElement from;

	@FindBy(how = How.ID, using = "dest")
	private WebElement to;

	@FindBy(how = How.ID, using = "onward_cal")
	private WebElement date;

	@FindBy(how = How.XPATH, using = "rb-calendar_onward_cal")
	private WebElement calendar ;

//	@FindBy(how = How.XPATH, using = "//*[text()='Search Buses']")
//	private WebElement searchBusesButton;

	@FindBy(how = How.ID, using = "search_btn")
	private WebElement searchBusesButton;

	public void enterFromLocation(String fromLocation) {

		from.sendKeys(fromLocation);


		// select first item from the list
		//wait
		from.sendKeys(Keys.DOWN);
		from.sendKeys(Keys.UP);
		from.sendKeys(Keys.ENTER);
	}

	public void enterToLocation(String toLocation) {

		to.sendKeys(toLocation);


		// select first item from the list
		//wait
		to.sendKeys(Keys.DOWN);
		to.sendKeys(Keys.UP);
		from.sendKeys(Keys.ENTER);
	}

	public void enterDate(String dateVal) throws InterruptedException {
		
		Thread.sleep(1000);
		// wait
		date.click();
//		date.sendKeys(dateVal);
		HelperClass.selectDateThroughCalendarOnSearchPage(driver, date, dateVal);

	}

	public void clickOnSearchBusesButton() throws InterruptedException  {

		searchBusesButton.click();

//		new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).
//		until(ExpectedConditions.elementToBeClickable(searchBusesButton));

		// wait
		
		// wait
		Thread.sleep(5000);

	}
}
