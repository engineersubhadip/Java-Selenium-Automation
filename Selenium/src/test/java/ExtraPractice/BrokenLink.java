package ExtraPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLink {

	public static void main(String[] args)
			throws MalformedURLException, IOException, URISyntaxException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String parentID = driver.getWindowHandle();

		JavascriptExecutor js = (JavascriptExecutor) driver;

//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='courses-iframe']")));

		js.executeScript("window.scrollTo(0,2600)");

//		1. Capturing the URL

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'brokenlink')]")));

		String url = driver.findElement(By.xpath("//a[contains(@href,'brokenlink')]")).getAttribute("href");

//		2. Connecting the URL to the Internet (HttpURLConnection to manage the Network Conditions)
//		
		HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();

//		3. Mention the Request Type.

		conn.setRequestMethod("HEAD");
//		4. Request the Server.

		conn.connect();

//		5. Fetch the Response Code.
		int code = conn.getResponseCode();
		System.out.println("Code " + code);

		Thread.sleep(2000);
//		
		driver.close();
	}

}
