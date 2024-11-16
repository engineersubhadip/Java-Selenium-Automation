package Day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SolutionAssignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.demoblaze.com/index.html");
		
		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("Total Links : "+totalLinks.size());
		
		List<WebElement> totalImages = driver.findElements(By.tagName("img"));
		
		System.out.println("Total Images : "+totalImages.size());
		
//		driver.findElement(By.linkText("Monitors")).click();
		
		List<WebElement> listHeader = driver.findElements(By.className("nav-item"));
		
		listHeader.get(2).click();

	}

}
