package ThreadSafety_ExtentReport;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tLocalDriver = new ThreadLocal<>();
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp (String browserName) {
		
		if (browserName.toLowerCase().contains("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.toLowerCase().contains("edge")) {
			driver = new EdgeDriver();
		} else {
			return;
		}
		
		tLocalDriver.set(driver);
		
		tLocalDriver.get().manage().deleteAllCookies();
		tLocalDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		tLocalDriver.get().manage().window().setSize(new Dimension(1440,900));
		tLocalDriver.get().manage().window().maximize();
		tLocalDriver.get().get("https://tutorialsninja.com/demo/index.php?route=common/home");
	}
	
	@AfterClass
	public void tearDown () {
		tLocalDriver.get().quit();
		tLocalDriver.remove();
	}
}
