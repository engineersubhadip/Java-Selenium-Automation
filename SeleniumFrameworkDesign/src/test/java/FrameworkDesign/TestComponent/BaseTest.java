package FrameworkDesign.TestComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import FrameworkDesign.PageObjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage loginPage;
	
	public void initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("K:\\Selenium Java Automation\\SeleniumFrameworkDesign\\src\\main\\java\\FrameworkDesign\\Resources\\GlobalData.properties");
		prop.load(fis);
		
		String browserName =  prop.getProperty("browser");
		
		if (browserName.toLowerCase().contains("chrome")) {
			driver = new ChromeDriver();
		}else if (browserName.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();
		}else if (browserName.toLowerCase().contains("edge")) {
			driver = new EdgeDriver();
		}else {
			return ;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public  LandingPage launchApp() throws IOException {
		
		initializeDriver();
		loginPage = new LandingPage(driver);
		loginPage.goTo();
		
		return loginPage;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
