package RunningIncognitoMode;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Client {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");

		wait.until(ExpectedConditions.titleContains("nopCommerce demo store"));

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // For taking multiple SS, we need to
																				// re-write the step multiple times

		FileUtils.copyFile(src, new File("K:\\AutomationScreenShots\\fullPage.png"));

		Thread.sleep(2000);

		driver.quit();

	}

}
