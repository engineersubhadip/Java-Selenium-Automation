package Day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-lazy-image-loading");
		
		driver.get("https://demo.opencart.com/");
		
//		NAME Attribute :-
		
//		WebElement searchBox = driver.findElement(By.name("search"));
//		
//		searchBox.sendKeys("MacBook");
		
		driver.findElement(By.name("search")).sendKeys("MacBook"); // single line 
		
		
//		ID Attribute :-
		
//		boolean flag = driver.findElement(By.id("logo")).isDisplayed();
//		
//		System.out.println(flag);
//		
//		driver.quit();
		
//		boolean flag = driver.findElement(By.id("logo")).isDisplayed(); // single line
		
//		System.out.println("Display Status : "+flag);
		
		
//		Link Text/Partial Link Text :-
		
//		driver.findElement(By.linkText("Tablets")).click();
		
		
//		className Attribute :-
		
		List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
		
		System.out.println("Number of Header Links : "+headerLinks.size());
		
		List<WebElement> totalTags = driver.findElements(By.tagName("a")); // total links in the webpage
		
		System.out.println("Total Number of Links "+totalTags.size());
		
		List<WebElement> totalImages = driver.findElements(By.tagName("img"));
		
		System.out.println("Total Number of Images "+totalImages.size());
		
		List<WebElement> arr1 = driver.findElements(By.tagName("qrt"));
		
		System.out.println(arr1); // empty list
		
		WebElement result = driver.findElement(By.name("qrt")); // No such element exception
//		
	}

}
