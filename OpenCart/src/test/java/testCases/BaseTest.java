package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public static String getRandomString() {
		
		String result = "";
		for (int i=0; i<8; i++) {
			int currASCII = 97 + (int)(Math.random() * (122-97 + 1));
			char currChar = (char)currASCII;
			result += currChar;
		}
		
		return result;
	}	

	public static String getRandomNumberString() {
		
		String result = "";
		for (int i=0; i<10; i++) {
			int currASCII = 48 + (int)(Math.random() * (57-48 + 1));
			char currChar = (char)currASCII;
			result += currChar;
		}
		
		return result;
	}

	public static String getRandomAlphanumeric() {
		String result = getRandomString() + getRandomNumberString();
		return result;
	}
	
}
