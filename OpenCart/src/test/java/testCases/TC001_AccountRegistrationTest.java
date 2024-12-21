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
	public void verfiy_account_registration() { // This test-case is referring to 2 page object classes.
		
		HomePage homePage = new HomePage(driver);
		homePage.waitForTitleToLoad("Your Store");
		homePage.clickMyAccount();
		homePage.clickRegister(); // till here we are clicking on the Register link
		
//		Inside Account Registration Page :
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		regPage.waitForTitleToLoad("Register Account");
		regPage.enterFirstName("Subhadip");
		regPage.enterLastName("Das");
		regPage.enterEmail("subhadip46@gmail.com");
		regPage.enterTelephoneNumber("212885632");
		regPage.enterUserPassword("test1234");
		regPage.enterConfirmPassword("test1234");
		regPage.clickSubscriptionAgree();
		regPage.clickPrivacyAgree();
		regPage.clickContinue();
		
//		Validation Part :-
		
		Assert.assertEquals(regPage.validateConfirmationMessage(), "Your Account Has Been Created!");
	}
}
