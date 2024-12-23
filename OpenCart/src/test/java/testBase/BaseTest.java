package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	public WebDriver driver;
	public Logger logger;
	public Properties properties;
	
	@BeforeClass
	@Parameters({ "browser", "operatingSystem" })

	public void setUp(String browser, String operatingSystem) throws IOException {

		logger = LogManager.getLogger(this.getClass()); // this.getClass() -> will dynamically capture the current
														// class(test case) we are running.
		// line 21 will load the log4j2.xml file

		if (browser.toLowerCase().contains("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.toLowerCase().contains("edge")) {
			driver = new EdgeDriver();
		} else if (browser.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();
		} else {
			return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		Loading Config.properties file :-
		
		properties = new Properties();
		FileInputStream file = new FileInputStream("K:\\Selenium Java Automation\\OpenCart\\src\\test\\resources\\config.properties");
		
		properties.load(file);
		
		String browserURL = properties.getProperty("browserURL"); // reading value from properties file
		
		driver.get(browserURL);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public static String getRandomString() {

		String result = "";
		for (int i = 0; i < 8; i++) {
			int currASCII = 97 + (int) (Math.random() * (122 - 97 + 1));
			char currChar = (char) currASCII;
			result += currChar;
		}

		return result;
	}

	public static String getRandomNumberString() {

		String result = "";
		for (int i = 0; i < 10; i++) {
			int currASCII = 48 + (int) (Math.random() * (57 - 48 + 1));
			char currChar = (char) currASCII;
			result += currChar;
		}

		return result;
	}

	public static String getRandomAlphanumeric() {
		String result = getRandomString() + getRandomNumberString();
		return result;
	}

}
