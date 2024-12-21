package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseTest{
	
	@Test
	public void verfiy_account_registration() throws InterruptedException { // This test-case is referring to 2 page object classes.
		
		HomePage homePage = new HomePage(driver);
		homePage.waitForTitleToLoad("Your Store");
		homePage.clickMyAccount();
		homePage.clickRegister(); // till here we are clicking on the Register link
		
//		Inside Account Registration Page :
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		regPage.waitForTitleToLoad("Register Account");
		
		String firstName = getRandomString();
		regPage.enterFirstName(firstName);
		
		String lastName = getRandomString();
		regPage.enterLastName(lastName);
		
		String userEmail = getRandomString();
		regPage.enterEmail(userEmail+"@gmail.com");
		
		String userTelephoneNumber = getRandomNumberString();
		regPage.enterTelephoneNumber(userTelephoneNumber);
		
		String userPassword = getRandomAlphanumeric();
		regPage.enterUserPassword(userPassword);
		regPage.enterConfirmPassword(userPassword);
		
		regPage.clickSubscriptionAgree();
		
		regPage.clickPrivacyAgree();
		
		regPage.clickContinue();
		
//		Validation Part :-
		
		Assert.assertEquals(regPage.validateConfirmationMessage(), "Your Account Has Been Created!");
	}
}
