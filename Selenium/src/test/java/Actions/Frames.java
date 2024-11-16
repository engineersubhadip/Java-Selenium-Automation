package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
//		Finding out how many frames are there in my page :-
		
		int frameCount =  driver.findElements(By.xpath("//iframe")).size();
		
		System.out.println(frameCount);
		
//		Switch to Frame based on WebElement :-
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		
		Actions a = new Actions(driver);
		
		a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
	}

}
