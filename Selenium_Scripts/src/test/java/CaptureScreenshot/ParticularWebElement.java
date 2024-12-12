package CaptureScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParticularWebElement {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");

		wait.until(ExpectedConditions.titleContains("nopCommerce demo store"));
		
		WebElement logo =  driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		
		File logoIMG =  logo.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(logoIMG, new File("K:\\AutomationScreenShots\\logo.png"));
		
		driver.quit();
	}

}
