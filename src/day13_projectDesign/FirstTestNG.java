package day13_projectDesign;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AmazonPage;
import utils.Driver;
import utils.PropertiesReader;

public class FirstTestNG {
	
  @Test
  public void AmazonTest() {
	  
	  	AmazonPage amazonPage = new AmazonPage();
		
		//Go to Amazon.com.
		Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Click on sign in.
		amazonPage.SignInLink.click();
		
		//Verify you are in the Sign in Page
		//If the element is displayed the assertion will pass
		Assert.assertTrue(amazonPage.signInText.isDisplayed());
		System.out.println("Sign in text is displyed. true check");
		
		
		//Navigate back and navigate forward
		Driver.getDriver().navigate().back();
		Driver.getDriver().navigate().forward();
		
		//Verify you are on the sign in page (either by sign in text or email field)
		Assert.assertTrue(amazonPage.signInPageEmail.isDisplayed());
		System.out.println("Email field is displyed. true check");
		
		
		//Click on create new account and verify you are on new account create page
		amazonPage.createAccountBtn.click();
		
		Assert.assertTrue(amazonPage.createAccountPageText.isDisplayed());
		System.out.println("We are on Account page. true check");
		
		//Navigate back, verify you are on the sign in page.
		Driver.getDriver().navigate().back(); //PS. you already did the following part above.
		
		Assert.assertTrue(amazonPage.signInPageEmail.isDisplayed());
		System.out.println("We are on Sign in page, third time. true check");
		//Navigate forward, verify you are on the create account page.
		Driver.getDriver().navigate().forward();
		
		Assert.assertTrue(amazonPage.createAccountPageText.isDisplayed());
		System.out.println("We are on Account page, second time. true check");
		
		
		//Click on the continue button without filling out the form.
		amazonPage.accountPage_ContinueBtn.click();
		//Verify error messages are displayed and get text to verify.
		String nameErrorMessage = PropertiesReader.getProperty("nameErrorMessage");
		String nameActualMessage = amazonPage.accountPage_NameErrorMessage.getText().trim();
		Assert.assertEquals(nameActualMessage, nameErrorMessage);
		System.out.println("Name Error Message Is Fine. True check");
		
		
		
		String emailOrPhoneErrorMessage = PropertiesReader.getProperty("emailOrPhoneErrorMessage");
		Assert.assertEquals(amazonPage.accountPage_emailErrorMessage.getText().trim(), emailOrPhoneErrorMessage);
		System.out.println("Email Error Message Is Fine. True check");
		
		
		
		String passwordMessage = PropertiesReader.getProperty("passwordErrorMessage");
		
		Assert.assertEquals(amazonPage.accountPage_passwordErrorMessage.getText().trim(), passwordMessage);
		System.out.println("Password Error Message Is Fine. True check");
		
		
		Driver.quitDriver();
	  
  }
  
  @Test
  public void test2() {
	  System.out.println("Test 2");
  }
  @Test
  public void test3() {
	  System.out.println("Test 3");
}
  @Test
  public void test4() {
	  System.out.println("Test 4");
  }
}
