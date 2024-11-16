package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassLocators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
//		cssSelector :- 
//		tag[attribute="value"]
		
//		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("abc.gmail.com");

//		tag#id
//		driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
		
//		tag.class[attribute="value"]
		driver.findElement(By.cssSelector("input.inputtext[name='email']")).sendKeys("abc@gmail.com"); // userId
		driver.findElement(By.cssSelector("input.inputtext[name='pass']")).sendKeys("password"); // password
		driver.findElement(By.cssSelector("button[type='submit']")).click(); // logIn Button
		
		driver.quit();
		
		
		
		
		
		
	}

}
