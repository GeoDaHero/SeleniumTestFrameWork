package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class AmazonPage {
	
	
	public AmazonPage() {
		//Initialize the Element
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	@FindBy(linkText = "Sign in securely")
	public WebElement SignInLink;
	
	@FindBy(xpath = "//h1[contains(text(), 'Sign in')]")
	public WebElement signInText;
	
	@FindBy(id = "ap_email")
	public WebElement signInPageEmail;
	
	@FindBy(id = "continue")
	public WebElement signInPageContinueBtn;
	
	@FindBy(id = "createAccountSubmit")
	public WebElement createAccountBtn;
	
	@FindBy(xpath = "//h1[contains(text(), 'Create account')]")
	public WebElement createAccountPageText;
	
	@FindBy(id = "continue")
	public WebElement accountPage_ContinueBtn;
	
	@FindBy(xpath = "//div[contains(text(), 'Enter your name')])")
	public WebElement accountPage_NameErrorMessage;
	
	@FindBy(xpath = "//div[contains(text(), 'Enter your email')])")
	public WebElement accountPage_emailErrorMessage;
			
	@FindBy(xpath = "//div[contains(text(), 'Minimum 6 characters required')])")
	public WebElement accountPage_passwordErrorMessage;
	

}
