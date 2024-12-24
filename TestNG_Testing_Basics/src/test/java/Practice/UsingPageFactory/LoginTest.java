package Practice.UsingPageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	@Parameters({"browser"})
	
	public void setUp(String br) {
		
		if (br.toLowerCase().contains("chrome")) {
			driver = new ChromeDriver();			
		}else if (br.toLowerCase().contains("edge")) {
			driver = new EdgeDriver();
		}else {
			return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
	public void loginFunctionality() throws InterruptedException {
		
		wait.until(ExpectedConditions.titleContains("OrangeHRM"));
		
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("Admin");
		lp.enterPassword("admin123");
		lp.clickSubmitBtn();
		
		Thread.sleep(2500);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
