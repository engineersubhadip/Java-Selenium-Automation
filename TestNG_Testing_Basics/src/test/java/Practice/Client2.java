package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 1. Open App
 2. Test Logo
 3. Login
 4. Logout
 */

public class Client2 {

	WebDriver driver;
	WebDriverWait wait;

	@Test(priority=1)
	public void openApp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.titleContains("OrangeHRM"));
	}

	
	@Test(priority=2)
	public void testLogo() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));
		WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
		Assert.assertEquals(logo.isDisplayed(),true);
	}
	
	@Test(priority=3)
	public void login() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[contains(@class,'oxd-button oxd-button')]")).click();
	}
	
	@Test(priority=4)
	public void logout() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(@class,'bi-caret-down-fill oxd-userdropdown-icon')]")));
		driver.findElement(By.xpath("//i[contains(@class,'bi-caret-down-fill oxd-userdropdown-icon')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='oxd-dropdown-menu'] //li")));
		driver.findElement(By.xpath("(//ul[@class='oxd-dropdown-menu'] //li)[4] //a")).click();
	}
}
