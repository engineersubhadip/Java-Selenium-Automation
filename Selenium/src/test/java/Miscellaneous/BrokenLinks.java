package Miscellaneous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().deleteAllCookies();
		
//		1. Capture the URL
		
		String soapUIURL = driver.findElement(By.xpath("//a[contains(@href,'brokenlink')]")).getAttribute("href");
		
//		2. Use .openConnection() of the URL Class to send the captured URL to the network.
		
		HttpURLConnection conn =  (HttpURLConnection)new URI(soapUIURL).toURL().openConnection();
		
//		3. Mention the type of Request.
		
		conn.setRequestMethod("HEAD");
		
//		4. Make the call.
		
		conn.connect();
		
//		5. Capture the status Code.
		
		int respCode =  conn.getResponseCode();
		
		System.out.println(respCode);
	}

}
