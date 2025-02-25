package FileUploads;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Client {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		
		driver.get("https://practice.expandtesting.com/upload");
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//input[@id='fileInput']"))).click().build().perform();
		
		Thread.sleep(2000);
		
		new ProcessBuilder("K:\\Scaler\\FileUploadScript.exe").start();
	}

}
