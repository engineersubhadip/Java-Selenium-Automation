package Miscellaneous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Assignment {
	
	static void getLinkStatus(WebDriver driver, List<WebElement> links) throws MalformedURLException, IOException, URISyntaxException {
		
		SoftAssert a = new SoftAssert();
		
		for (WebElement currLink : links) {
//			1. Capturing the URL.
			
			String url = currLink.getAttribute("href");
			
//			2. Connecting the URL to the Internet and use HttpURLConnection to manage the network conditions.
			
			HttpURLConnection conn =  (HttpURLConnection)new URI(url).toURL().openConnection();
			
//			3. Metion the type of Request.
			
			conn.setRequestMethod("HEAD");
			
//			4. Send the Request to the Server.
			
			conn.connect();
			
//			5. Capture the response Code from the server.
			
			int respCode =  conn.getResponseCode();
			
			a.assertTrue(respCode<400,"Faulty Link "+currLink.getText()+" respCode "+respCode);
		}
		
		a.assertAll();
	}
	
	
	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='gf-BIG'] //a")));
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='gf-BIG'] //a"));
		
		getLinkStatus(driver, links);
		
		driver.close();
	}

}
