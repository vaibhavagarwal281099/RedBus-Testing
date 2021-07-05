package in.redbus.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BusTicketsPage {

	public WebDriver driver;

	public BusTicketsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Element and Flow for searching buses in Bus Tickets page
	@FindBy(how = How.XPATH, using = "//*[text() = 'Print/SMS Ticket']")
	private WebElement printTicketButton;
	
	@FindBy(how = How.XPATH, using = "//*[text() = 'Cancel Ticket']")
	private WebElement cancelTicketButton;
	
	@FindBy(how = How.ID, using = "txtSource")
	private WebElement srcField;
	
	@FindBy(how = How.ID, using = "txtDestination")
	private WebElement destField;
	
	@FindBy(how = How.ID, using = "txtOnwardCalendar")
	private WebElement calendarDate;
	
	@FindBy(how = How.XPATH, using = "//*[text() = 'Search Buses']")
	private WebElement searchButton;
	
	
	public void clickOnPrintTicket() {
		
		printTicketButton.click();
	}
	
	public void clickOnCancelTicketButton() {
		
		cancelTicketButton.click();
	}
	
	public void enterSrcData(String location) {
		
		srcField.sendKeys(location);
		
		srcField.sendKeys(Keys.DOWN);
		srcField.sendKeys(Keys.UP);
		srcField.sendKeys(Keys.ENTER);
		
	}
	
	public void enterDestData(String location) {
		
		destField.sendKeys(location);

		destField.sendKeys(Keys.DOWN);
		destField.sendKeys(Keys.UP);
		destField.sendKeys(Keys.ENTER);
		
	}
	
	public void enterDate(String dateVal) {

		calendarDate.click();		
		calendarDate.sendKeys(dateVal);
	}

	public void clickOnSearchBusesButton() {
		
		
		searchButton.click();
	}
	
}
