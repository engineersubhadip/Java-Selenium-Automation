package dataProvidersAndParallelTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParamTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority=1)
	public void testLogo() {
		WebElement companyLogo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']"));
		boolean status = companyLogo.isDisplayed();
		if (status) {
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	}
	
	@Test(priority=2)
	public void testTitle() {
		String pageTitle = driver.getTitle();
		if (pageTitle.contains("OrangeHRM")) {
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	}
	
	@Test(priority=3)
	public void testURL() {
		String pageURL = driver.getCurrentUrl();
		
		if (pageURL.contains("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")) {
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
