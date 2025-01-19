package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IDAndName {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");;
		driver.findElement(By.id("inputUsername")).sendKeys("Rituparna");
		driver.findElement(By.name("inputPassword")).sendKeys("Test@123");
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[contains(@class,'signInBtn')]")));
		
//		CSS Selector :-
		
		System.out.println(driver.findElement(By.cssSelector(".error")).getText()); // Using Class Name
		System.out.println(driver.findElement(By.cssSelector("*[class='error']")).getText()); // Using attribute
		System.out.println(driver.findElement(By.cssSelector(".error[class='error']")).getText()); // Using class name and attribute
		
	}

}
