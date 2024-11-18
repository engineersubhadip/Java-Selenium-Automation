package dataProvidersAndParallelTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="dp")
	public void testLogin(String userName, String passWord) throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-email']")));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(userName);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='input-password']")));
		driver.findElement(By.xpath("//input[@id='input-password']")).click();
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(passWord);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		
		if (status) {
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	}
	
	@DataProvider(name="dp", indices= {1,2})
	public Object[][] loginData() {
		Object data[][] = new Object[4][2];
		data[0][0] = "sun87";
		data[0][1] = "test123";
		data[1][0] = "peter99";
		data[1][1] = "rorshack@77";
		data[2][0] = "s12@abc.com";
		data[2][1] = "test123";
		data[3][0] = "rorshack@77";
		data[3][1] = "sun87";
		
		
		return data;
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
	}
	
}
