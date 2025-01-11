package baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	public static WebDriver driver;
	public Properties properties;
	public Logger logger;
	
	@BeforeClass(groups = {"sanity", "regression", "datadriven", "master"})
	@Parameters({"browser"})
	public synchronized void setUp(String browserName) throws FileNotFoundException, IOException {
		
		logger = LogManager.getLogger(System.getProperty("user.dir")+"\\src\\test\\resources\\log4j2.xml");
		
		properties = new Properties();
		properties.load(
				new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties"));
		
		String url = properties.getProperty("browserURL");
		
		if (browserName.toLowerCase().contains("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.toLowerCase().contains("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();
		} else {
			return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	@AfterClass(groups = {"sanity", "regression", "datadriven", "master"})
	public void tearDown () {
		driver.quit();
	}
	
	public String getRandomString () {
		
		String result = "";
		
		for (int i=0; i<10; i++) {
			int currASCII = 97 + (int)(Math.random()*(122-97+1));
			char currChar = (char)currASCII;
			result += currChar;
		}
		return result;
	}
	
	public String getRandomNumber () {
		
		String result = "";
		
		for (int i=0; i<10; i++) {
			int currASCII = 48 + (int)(Math.random()*(57-48+1));
			char currChar = (char)currASCII;
			result += currChar;
		}
		return result;
	}
	
	public String getRandomAlpha () {
		String result = getRandomString() + getRandomNumber();
		return result;
	}
	
	public static String takeScreenshot () throws IOException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date dt = new Date();
		String fileName = format.format(dt);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File targetSourceFile = new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName+".png");
		FileUtils.copyFile(src, targetSourceFile);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+fileName+".png";
		return targetFilePath;
	}
}
