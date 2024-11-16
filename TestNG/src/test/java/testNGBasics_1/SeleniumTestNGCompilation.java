package testNGBasics_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
1. Open the Application
3. Login the Application
2. Check the Logo presence
4. Logout from the Application
*/


public class SeleniumTestNGCompilation {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Test(priority=1)
	public void openApplication() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test(priority=3)
	public void login() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='username']")));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin"); // filling in userName
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
		driver.findElement(By.xpath("//input[@name='password']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123"); // filling in passWord
		
		driver.findElement(By.xpath("//button[contains(@class,'oxd-button--medium oxd-button')]")).click(); // click on Submit button
	}
	
	@Test(priority=2)
	public void checkLogo() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));
		boolean flag =  driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
//		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void logout() {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='oxd-userdropdown-tab'] //i")));
		
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab'] //i")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='oxd-dropdown-menu'] // a[contains(@href,'logout')]")));
		
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu'] // a[contains(@href,'logout')]")).click();
	}
	
}
