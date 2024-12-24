package Practice.WithoutPageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
	public void loginFunctionality() throws InterruptedException {
		wait.until(ExpectedConditions.titleContains("OrangeHRM"));
		
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName("Admin");
		lp.enterPassword("admin123");
		lp.clickSubmitBtn();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
