package Day6;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
//		get(url) :- Launches the URL in the Browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
//		getTitle() :- Returns the title of the WebPage
		String pageTitle = driver.getTitle();
		System.out.println("Page Title : "+pageTitle);
		
//		getCurrentUrl() :- Returns the current URL of the WebPage
		String pageUrl = driver.getCurrentUrl();
		System.out.println("Page Url : "+pageUrl);
		
//		getPageSource() :- Returns the page source of the WebPage
		String pageSource = driver.getPageSource();
//		System.out.println("Page Source : "+pageSource);
		
//		getWindowHandle() :- Returns the single page handle
//		String pageHandle = driver.getWindowHandle();
//		System.out.println("Page Handle : "+pageHandle);
		
//		getWindowHandles() :- Returns the multiple page handles
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Window Handles : "+windowHandles);
	}

}
