package HandlingAlerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

// Sending texts in alert

public class Client2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("(//ul //button)[3]")).click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("Prometheus is harvesting the Autumn Crops.");
		
		Thread.sleep(2000);
		
		alert.accept();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//ul //button)[2]")).click();
		
		Thread.sleep(2000);
		alert.accept();
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
