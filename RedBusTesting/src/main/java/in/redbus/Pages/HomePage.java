package in.redbus.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Element and Flow for searching buses in home page

	@FindBy(how = How.XPATH, using = "//*[@class = \"redbus-logo home-redirect\"]")
	private WebElement redBusLogo;

	@FindBy(how = How.ID, using = "redBus")
	private WebElement busTicketsLink;

	@FindBy(how = How.ID, using = "cars")
	private WebElement rPoolLink;

	@FindBy(how = How.ID, using = "redBus Bus Hire")
	private WebElement busHireLink;

	@FindBy(how = How.LINK_TEXT, using = "Help")
	private WebElement helpLink;


	public void clickOnRedBusLogo() {

		redBusLogo.click();
	}

	public void clickOnBusTicketsLink() {

		busTicketsLink.click();
	}

	public void clickOnBusHireLink() {

		busHireLink.click();
	}

	public void clickOnRPoolLink() {

		rPoolLink.click();
	}

	public void clickOnHelpLink() {

		helpLink.click();
	}
}
