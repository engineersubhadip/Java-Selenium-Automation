package DataDrivenAndParallelExecutionCombo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginFeature {

	WebDriver driver;
	WebDriverWait wait;
	Properties properties;

	@BeforeClass
	public void setUp() throws IOException { // responsible for setting up the browser config.

		properties = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\java\\DataDrivenAndParallelExecutionCombo\\browserConfig.properties");
		properties.load(file);

		String browserURL = properties.getProperty("browserURL");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get(browserURL);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void testCredential() { // actual test

		wait.until(ExpectedConditions.titleContains("OrangeHRM"));

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[contains(@class,'orangehrm-login-button')]")).click();

		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//i[contains(@class,'oxd-userdropdown-icon')]")));
			Thread.sleep(1500);
			driver.findElement(By.xpath("//i[contains(@class,'oxd-userdropdown-icon')]")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='oxd-dropdown-menu'] //li")));
			
			driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu'] //li/a[contains(@href,'logout')]")).click();
			
		} catch (Exception e) {
			Assert.fail();
		}
	}

	
	@AfterClass
	public void tearDown() { // closing browser
		driver.quit();
	}

}
