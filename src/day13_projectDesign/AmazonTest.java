package day13_projectDesign;

import pages.AmazonPage;
import utils.Driver;
import utils.PropertiesReader;

public class AmazonTest {
	public static void main(String[] args) {
		
		
		AmazonPage amazonPage = new AmazonPage();
		
		//Go to Amazon.com.
		Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
		
		//Click on sign in.
		amazonPage.SignInLink.click();
		
		//Verify you are in the Sign in Page
		if (amazonPage.signInText.isDisplayed()) {
			System.out.println("We are on Sign in page.");
		}else {
			System.out.println("We are not on the Sign in page.");
		}
		
		//Navigate back and navigate forward
		Driver.getDriver().navigate().back();
		Driver.getDriver().navigate().forward();
		
		//Verify you are on the sign in page (either by sign in text or email field)
		if (amazonPage.signInPageEmail.isDisplayed()) {
			System.out.println("We are on Sign in page, second time.");
		}else {
			System.out.println("We are not on the Sign in page, second time.");
		}
		
		//Click on create new account and verify you are on new account create page
		amazonPage.createAccountBtn.click();
		
		if(amazonPage.createAccountPageText.isDisplayed()) {
			System.out.println("We are on Account page.");
		}else {
			System.out.println("We are not on the Account page.");
		}
		
		//Navigate back, verify you are on the sign in page.
		Driver.getDriver().navigate().back(); //PS. you already did the following part above.
		
		if (amazonPage.signInPageEmail.isDisplayed()) {
			System.out.println("We are on Sign in page, third time.");
		}else {
			System.out.println("We are not on the Sign in page, third time.");
		}
		//Navigate forward, verify you are on the create account page.
		Driver.getDriver().navigate().forward();
		if(amazonPage.createAccountPageText.isDisplayed()) {
			System.out.println("We are on Account page, second time.");
		}else {
			System.out.println("We are not on the Account page, second time.");
		}
		
		//Click on the continue button without filling out the form.
		amazonPage.accountPage_ContinueBtn.click();
		//Verify error messages are displayed and get text to verify.
		String nameErrorMessage = PropertiesReader.getProperty("nameErrorMessage");
		
		if (amazonPage.accountPage_NameErrorMessage.getText().trim().equals(nameErrorMessage)) {
			System.out.println("Name Error Message Is Fine.");
		}else {
			System.out.println("Name Error is not fine.");
		}
		
		String emailOrPhoneErrorMessage = PropertiesReader.getProperty("emailOrPhoneErrorMessage");
		
		if (amazonPage.accountPage_emailErrorMessage.getText().trim().equals(emailOrPhoneErrorMessage)) {
			System.out.println("Email Error Message Is Fine.");
		}else {
			System.out.println("Email Error is not fine.");
		}
		
		String passwordMessage = PropertiesReader.getProperty("passwordErrorMessage");
		
		if (amazonPage.accountPage_passwordErrorMessage.getText().trim().equals(passwordMessage)) {
			System.out.println("Password Error Message Is Fine.");
		}else {
			System.out.println("Password Error is not fine.");
		}
		
		Driver.quitDriver();
		
		
		
	}

}
