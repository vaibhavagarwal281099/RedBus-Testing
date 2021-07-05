package in.redbus.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TripSummaryPage {

	public WebDriver driver;
	
	public TripSummaryPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Element and Flow for searching buses in search page
	
	@FindBy(how = How.XPATH, using = "//*[@class='headerlabelsummary']")
	private WebElement tripHeaderSummaryLabel;
	
	@FindBy(how = How.XPATH, using = "//*[@id='customer_name']")
	private WebElement nameField;
	
	@FindBy(how = How.XPATH, using = "//*[@id='customer_email']")
	private WebElement emailField;
	
	@FindBy(how = How.XPATH, using = "//*[@id='customer_mobile']")
	private WebElement mobileField;
	
	@FindBy(how = How.XPATH, using = "//*[@id='req_notes']")
	private WebElement additionalInfo;
	
	@FindBy(how = How.XPATH, using = "//*[@id='proceedButtonSummary']")
	private WebElement proceedButton;
	
	
	public void enterName(String name) throws InterruptedException {
		
		Thread.sleep(1000);
		nameField.sendKeys(name);
	}
	
	public void enterEmail(String email) {
		
		emailField.sendKeys(email);
	}
	
	public void enterMobile(String phoneNo) {
		
		mobileField.sendKeys(phoneNo);
	}
	
	public void enterAdditionalInfo(String info) {
		
		additionalInfo.sendKeys(info);
	}
	
	public void clickOnProceedButton() {
		
		proceedButton.click();
	}
	
	public String fetchHeaderSummary() throws InterruptedException {
		
		Thread.sleep(2000);
		
	 String text =	tripHeaderSummaryLabel.getText().toLowerCase();
	 return text;
	}
}
