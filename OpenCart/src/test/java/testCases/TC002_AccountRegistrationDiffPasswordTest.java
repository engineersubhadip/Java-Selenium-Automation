package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC002_AccountRegistrationDiffPasswordTest extends BaseTest {

	@Test
	public void validate_incorrect_password_message() throws InterruptedException {

		HomePage homePage = new HomePage(driver);

		homePage.waitForTitleToLoad("Your Store");
		homePage.clickMyAccount();
		homePage.clickRegister();

		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);

		regPage.waitForTitleToLoad("Register Account");

		String firstName = getRandomString();
		regPage.enterFirstName(firstName);

		String lastName = getRandomString();
		regPage.enterLastName(lastName);

		String email = getRandomString();
		regPage.enterEmail(email+"@gmail.com");

		String telephoneNumber = getRandomNumberString();
		regPage.enterTelephoneNumber(telephoneNumber);

		String userPassword = getRandomString();
		regPage.enterUserPassword(userPassword);

		String confirmPassword = getRandomString();
		regPage.enterConfirmPassword(confirmPassword);
		
		regPage.clickPrivacyAgree();
		
		regPage.clickContinue();
		
//		Validation Part :-

		Assert.assertEquals(regPage.validateIncorrectPasswordMessage(),
				"Password confirmation does not match password!");
	}
}
