package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;

public class TC003_ValidUserLoginTest extends BaseTest {
	
	@Test
	public void validate_valid_user_credentials() {
		
		logger.info("**** Starting TC003_ValidUserLoginTest execution ****");
		
		try {
		HomePage homePage = new HomePage(driver);
		homePage.waitForTitleToLoad("Your Store");
		logger.info("Inside Home Page");
		homePage.clickMyAccount();
		logger.info("Clicked My Account");
		homePage.clickLogin();
		logger.info("Clicked Login Link");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.waitForTitleToLoad("Account Login");
		logger.info("Inside Login Page");
		logger.info("Entering user credentials");
		
		loginPage.enterUserEmail(super.validUserEmail);
		loginPage.enterUserPassword(super.validPassword);
		loginPage.clickLoginButton();
		
		logger.info("Clicked on Continue button");

//		Validation Part :-
		
		String confirmMessage = loginPage.checkConfirmationMessage();
		logger.info("Starting validation");
		
		if (confirmMessage.equals("My Account")) {
			Assert.assertTrue(true);
			logger.info("Validation successfull");
		}else {
			logger.error("Validation failure");
			Assert.assertTrue(false);
		}
		} catch(Exception e) {
			logger.error("Error Message -> "+e.getMessage());
			Assert.fail();
		}
		
		logger.info("**** Finished TC003_ValidUserLoginTest execution ****");
	}
}
