package HandleBrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * A Broken link is a link which does not have a resource in the Server
 * If we send a request to the server
 * Based on the response code sent by the server, we will judge if it is a broken link or not
 * Status Code >= 400 :- Broken Link
 * Else :- Working Link
 * 
 * 1. Steps :-
 * A. Capture all the links by their tagName
 * B. Use filter to filter out the elements whose href is null || href.isEmpty() == true 
 * The above line will ensure we are only sending the valid links
 */

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		wait.until(ExpectedConditions.titleContains("Example Errors - Benchmark Site for Dead Link Checking Tools"));
		
//		1. Capure the link/s you want to verify :-
		
		List<WebElement> links =  driver.findElements(By.tagName("a"));

		List<String> validLink =  links.stream().filter(currEle -> {
			String currURL = currEle.getAttribute("href");
			if (currURL == null || currURL.isEmpty()) {
				return false;
			}else {
				return true;
			}
		}).map(currEle -> currEle.getAttribute("href")).toList();
		
//		2. Hit the link/s to the Server :-
		
		int countBrokenLinks = 0;
		
		for (String currLinkString : validLink) {
			try {
//			A. Convert the String to URL
			URL currURL = new URL(currLinkString);
//			B. Open the connection to the Server
			HttpURLConnection connection = (HttpURLConnection) currURL.openConnection();
//			C. Send Request to the Server
			connection.connect();
//			D. Capture the Response Code
			int responseCode =  connection.getResponseCode();
			if (responseCode >= 400) {
				countBrokenLinks ++;
			}
			System.out.println("Response Code "+responseCode);
			} catch(Exception e) {
			}
		}
		
		System.out.println("countBrokenLinks -> "+countBrokenLinks);
	}

}
