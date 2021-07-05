package in.redbus.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


    @FindBy(how = How.ID, using = "signin-block")
    public WebElement login_icon;

 


    @FindBy(how = How.ID, using = "signInLink")
    public WebElement signInLink;

 

  
    @FindBy(how = How.ID, using = "g_id_onload")
    public WebElement googleSignIn;

 

   
    @FindBy(how = How.XPATH, using = "//*[@id=\"credentials-picker\"]/div[1]/div[1]")
    public WebElement user_acc;

 

    
    @FindBy(how = How.ID, using = "mobileNoInp")
    public WebElement ph_number;

 

 
    @FindBy(how = How.CLASS_NAME, using = "modalIframe")
    public WebElement iframe_1;

 


    @FindBy(how = How.CLASS_NAME, using = "ahT6S ")
    public WebElement google_page;
 

	
}
