package extraPractice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// Verify Google Home Page Title :-

public class Client1 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void openURL() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
	}
	
	@Test
	public void verifyTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterClass
	public void closeURL() throws InterruptedException {
		System.out.println("Closing the HomePage");
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
