package ExtentReports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * 1. Open the App
 * 2. Test logo presence
 * 3. Login
 * 4. Close
 */

public class OrangeHRMTest {

	WebDriver driver;
	WebDriverWait wait;

	@Test(priority = 1)
	void openApp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 2)
	void checkLogo() {
		wait.until(ExpectedConditions.titleContains("OrangeHRM"));
		boolean logoStatus = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']"))
				.isDisplayed();
		Assert.assertEquals(logoStatus, true);
	}

	@Test(priority = 3)
	void login() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test(priority = 4)
	void closeApp() throws InterruptedException {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//i[contains(@class,'oxd-icon bi-caret-down')]")));
		driver.findElement(By.xpath("//i[contains(@class,'oxd-icon bi-caret-down')]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'logout')]")));

		driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}
}
