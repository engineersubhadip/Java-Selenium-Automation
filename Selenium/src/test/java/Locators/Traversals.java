package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Traversals {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
//		Parent-Child Traversal:-
		
		System.out.println(driver.findElement(By.xpath("//header[contains(@class,'jumbotron')]/div/button")).getText());
		
		
//		Following-Sibling Traversal :-
		
		System.out.println(driver.findElement(By.xpath("//header[contains(@class,'jumbotron')]/div/button[1]/following-sibling::button[1]")).getText());
	
		
//		Child-Parent Traversal:-
		
		System.out.println(driver.findElement(By.xpath("//header[contains(@class,'jumbotron')]/div/button[1]/parent::div")).getText());
	}

}
