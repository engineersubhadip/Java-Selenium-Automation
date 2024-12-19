package DataProviderAnnotation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test(dataProvider="dp")
	public void testLogin(String userName, String password) throws InterruptedException {

		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

		wait.until(ExpectedConditions.titleContains("Account Login"));

		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(2000);

		try {
			driver.findElement(By.xpath("(//div[@id='content']/h2)[1]")).isDisplayed();
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//a[@title='My Account']")).click();
			Thread.sleep(500);
			driver.findElement(
					By.xpath("//ul[@class='dropdown-menu dropdown-menu-right'] //li/a[contains(@href,'logout')]"))
					.click();
		} catch (Exception e) {
			Assert.fail();
		}
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name="dp")
	public Object[][] testData() {
		Object[][] data = { { "Test@abc.com", "123" }, { "subhadip911@gmail.com", "password" }, { "subhadip", "pass" },
				{ "subhadip911@gmail.com", "Test@123" }, { "pavan", "123" } };
		return data;
	}
}
