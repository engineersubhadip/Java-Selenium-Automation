package pageObjectModel.usingPageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	@Parameters({"browser","url"})
	
	public void setUp(String browserName, String url) {
		
		if (browserName.toLowerCase().contains("chrome")) {
			this.driver = new ChromeDriver();
		}else if (browserName.toLowerCase().contains("edge")) {
			this.driver = new EdgeDriver();
		}else if (browserName.toLowerCase().contains("firefox")) {
			this.driver = new FirefoxDriver();
		}else {
			return;
		}	
		
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get(url);
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void login() {
		LoginPage_PageObjectClass lp = new LoginPage_PageObjectClass(this.driver);
		
		lp.setUserName("Admin");
		
		lp.setPassword("admin123");
		
		lp.clickSubmit();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
