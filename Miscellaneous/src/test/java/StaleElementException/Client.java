package StaleElementException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		
		driver.get("https://www.pavantestingtools.com/");
		
		WebElement target = driver.findElement(By.xpath("//a[contains(@href,'miscellaneous')]"));
		
		target.click();
		
		Thread.sleep(4000);
		
		driver.navigate().back();
		
		System.out.println("We Came back");
		
		try {
			target.click();			
		} catch (Exception e) {
			target = driver.findElement(By.xpath("//a[contains(@href,'miscellaneous')]"));
			target.click();
		}
		
//		If you are working on a list , then you need to re-fetch the list inside catch
	}

}
