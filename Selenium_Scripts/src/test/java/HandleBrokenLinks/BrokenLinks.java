package HandleBrokenLinks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * If we send a request to the server
 * Based on the response code sent by the server, we will judge if it is a broken link or not
 * Status Code >= 400 :- Broken Link
 * Else :- Working Link
 */

public class BrokenLinks {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		wait.until(ExpectedConditions.titleContains("Dead Link City - The Museum of Dead Links"));
		
		WebElement brokenLink = driver.findElement(By.xpath("//a[contains(@href,404)]"));
		
		
	}

}
