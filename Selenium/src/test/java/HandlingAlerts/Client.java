package HandlingAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Rituparna");
//		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
//		To handle alert :-
//		We need to switch the context of the driver from browser to alert.
		
//		1. Only 1 option Alert (OK) :-
		
//		1(A). We have to grab the alert text :-
		
//		Thread.sleep(1500);
		
//		String res = driver.switchTo().alert().getText();
		
//		if (res.contains("Rituparna")) {
//			Assert.assertTrue(true);
//		} else {
//			Assert.assertTrue(false);
//		}
		
//		1(B). We also need to accept the alert on the page :-
		
//		Thread.sleep(1500);
		
//		driver.switchTo().alert().accept(); 
		
		
//		2. 2 Option Alerts (OK and Cancel) :-
		
//		2(A) :- We want to click Cancel :-
		
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		
		Thread.sleep(1500);
		
		driver.switchTo().alert().dismiss();
	}

}
