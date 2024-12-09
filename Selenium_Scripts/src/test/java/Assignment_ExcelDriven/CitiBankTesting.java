package Assignment_ExcelDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiBankTesting {

	public static void main(String[] args) throws IOException {
//		A. Loading the Driver configurations from the Properties File :-
		
//		1. Create a Properties object :-
		Properties properties = new Properties();
		
//		2. Open the Properties file in reading mode :-
//		FileInputStream file = new FileInputStream("K:\\Selenium Java Automation\\Selenium_Scripts\\src\\test\\java\\testdata\\assignmentConfig.properties");
		
//		3. Load the Properties file :-
//		properties.load(file);
		
//		4. Extract out the relevant details :-
		String url = properties.getProperty("appURL");
		
//		B. Initialize our driver : -
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(url); // App is launched
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,450)");
		
//		C. Locators/WebElements of the targeted fields :-
		
		
	}

}

