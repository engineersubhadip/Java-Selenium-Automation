package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildParentTraversal {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		Sibling to Sibling Traversal :-
//		Travel from "Practice" to "Login"
		
		String result = driver.findElement((By.xpath("//header/div/button[1]/following-sibling::button[1]"))).getText();
		System.out.println(result);
		
//		Child to Parent Traversal :-
//		Travel from "Practice" to Parent and then from Parent to "Login"
		
		String result2 = driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText();
		System.out.println(result2);
	}

}
