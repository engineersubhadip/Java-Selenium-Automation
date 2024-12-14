package MouseHover;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Client {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo-opencart.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.titleContains("Your Store"));
		
		WebElement desktop = driver.findElement(By.xpath("//li[@class='nav-item dropdown'][1]"));
		
//		This Mac Option is not visible in the UI. Unless we hover on the desktop option, we will not be able 
//		to see the MAC option. That is why we will capture the XPath of Mac via SelectorHub
		
		WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (0)']"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(desktop).moveToElement(mac).build().perform();
	}

}
