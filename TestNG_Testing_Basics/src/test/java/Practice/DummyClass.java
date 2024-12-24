package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DummyClass {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browserName) {
		
		if (browserName.toLowerCase().equals("chrome")) {
			driver = new ChromeDriver();			
		}else if (browserName.toLowerCase().equals("edge")) {
			driver = new EdgeDriver();
		}else {
			return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	@BeforeMethod
	public void navigateBack() {
		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=common/home");
	}
	
	@Test(dataProvider="dp")
	public void testing(String email, String password) throws InterruptedException {
		
		try {
		wait.until(ExpectedConditions.titleContains("Your Store"));
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']")));
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		wait.until(ExpectedConditions.titleContains("Account Login"));
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		wait.until(ExpectedConditions.titleContains("My Account"));
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
		Thread.sleep(500);
		}catch(Exception e) {
			System.out.println("Test case failed for -> "+e.getMessage());
			Assert.fail();
		}
	}

	@DataProvider(name="dp")
	String[][] getData() {
		String[][] data = {{"A","B"},{"s1994@g.com","test123"}};
		return data;
	}
}
