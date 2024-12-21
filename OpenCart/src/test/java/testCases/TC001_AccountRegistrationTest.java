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
import utilities.GenerateRandomString;

public class TC001_AccountRegistrationTest {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verfiy_account_registration() throws InterruptedException { // This test-case is referring to 2 page object classes.
		
		HomePage homePage = new HomePage(driver);
		homePage.waitForTitleToLoad("Your Store");
		homePage.clickMyAccount();
		homePage.clickRegister(); // till here we are clicking on the Register link
		
//		Inside Account Registration Page :
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		regPage.waitForTitleToLoad("Register Account");
		
		String firstName = GenerateRandomString.getString();
		regPage.enterFirstName(firstName);
		
		String lastName = GenerateRandomString.getString();
		regPage.enterLastName(lastName);
		
		String userEmail = GenerateRandomString.getString();
		regPage.enterEmail(userEmail+"@gmail.com");
		
		String userTelephoneNumber = GenerateRandomString.getNumberString();
		regPage.enterTelephoneNumber(userTelephoneNumber);
		
		String userPassword = GenerateRandomString.getString();
		regPage.enterUserPassword(userPassword);
		regPage.enterConfirmPassword(userPassword);
		
		regPage.clickSubscriptionAgree();
		
		regPage.clickPrivacyAgree();
		
		regPage.clickContinue();
		
//		Validation Part :-
		
		Assert.assertEquals(regPage.validateConfirmationMessage(), "Your Account Has Been Created!");
	}
}
