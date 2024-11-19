package dataProvidersAndParallelTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AssignmentEndtoEnd {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void setUp(String browser, String url) {
		
		if (browser.toLowerCase().contains("chrome")) {
			driver = new ChromeDriver();
		}else if (browser.toLowerCase().contains("edge")) {
			driver = new EdgeDriver();
		}else if (browser.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();
		}else {
			return; // make sure to stop the script execution
		}
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	
	@Test(dataProvider = "loginData")
	public void loginFunctionality(String userName, String passWord) throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		
		passwordField.click();
		
		passwordField.sendKeys(passWord);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		WebElement dashboard = driver.findElement(By.xpath("//h6[contains(@class,'oxd-text')]"));
		
		boolean status = dashboard.isDisplayed();
		
		if (status) {
			driver.findElement(By.xpath("//i[contains(@class,'bi-caret-down-fill')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	}
	
	
	@DataProvider(name = "loginData")
	public Object [][] loginTestData() {
		
		Object [][] data = new Object[5][2];
		
		data[0][0] = "Rorshack44";
		data[0][1] = "test98";
		
		data[1][0] = "Araghya";
		data[1][1] = "ui55";
		
		data[2][0] = "Admin";
		data[2][1] = "admin123";
		
		data[3][0] = "Shirin93";
		data[3][1] = "admin123";
		
		data[4][0] = "Admin";
		data[4][1] = "admin123";
		
		return data;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
