package ExtentReports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	static WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	@Parameters({"browser","os"})
	public void setUp (String browserName, String os) {
		
		if (browserName.toLowerCase().contains("chrome")) {
			driver = new ChromeDriver();			
		}else if (browserName.toLowerCase().contains("edge")) {
			driver = new EdgeDriver();
		}else {
			return;
		}
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}


	@AfterClass
	void closeApp() throws InterruptedException {
		driver.quit();
	}


	public static String captureScreenShot () throws IOException {
		
		System.out.println("Inside Scrrenshot");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date dt = new Date();
		String fileName = df.format(dt);
		
		String targetFile = System.getProperty("user.dir")+"/screenshots/pic_"+fileName+".png";
		
		FileUtils.copyFile(src, new File(targetFile));
		
		return targetFile;
	}
}
