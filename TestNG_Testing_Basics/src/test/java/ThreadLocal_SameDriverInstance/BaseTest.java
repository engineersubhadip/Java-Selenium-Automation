package ThreadLocal_SameDriverInstance;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	public WebDriver driver;
	private DriverManagement driverManager;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browserName) {
		driverManager = DriverManagement.getInstance();
		System.out.println("Printing singletonDriver object "+driverManager);
		driverManager.setDriver(browserName);
		
		driver = driverManager.getDriver();
		System.out.println("Current Driver Object "+driver);
		driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
	}
	
	@AfterClass
	public void tearDown() {
		driverManager.quitDriver();
	}
}
