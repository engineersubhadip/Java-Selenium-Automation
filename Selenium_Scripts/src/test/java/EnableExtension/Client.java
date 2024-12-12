package EnableExtension;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Install CRX Extractor -> This will extract the CRX files for the Plugins we want
 * Capture the CRX file for our desired extension we want to enable (Download it)
 * Pass the CRX File path to the Chrome Options Class
 */

public class Client {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("K:\\CRX Files\\uBlock.crx"));
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://text-compare.com/");
	}

}
