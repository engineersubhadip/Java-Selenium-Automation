package ExtentReports;

import java.io.IOException;
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

public class OrangeHRMTest extends BaseTest {

	@Test(priority = 1)
	void checkLogo() throws IOException {
		wait.until(ExpectedConditions.titleContains("OrangeHRM"));
		boolean logoStatus = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']"))
				.isDisplayed();
		super.captureScreenShot();
		Assert.assertEquals(logoStatus, true);
	}

	@Test(priority = 2)
	void login() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin124");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		super.captureScreenShot();
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//i[contains(@class,'oxd-icon bi-caret-down')]")));
		driver.findElement(By.xpath("//i[contains(@class,'oxd-icon bi-caret-down')]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'logout')]")));

		driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
		
		Thread.sleep(2000);
	}

}
