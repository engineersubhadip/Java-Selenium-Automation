package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrameAssignment2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
//		Write inside Frame 1
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame")));
		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("I am inside Frame 1");
		
//		Switch to Frame 2
		
		driver.switchTo().defaultContent(); // come out of Frame1
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_2.html']")));
		
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("I am inside Frame 2");
		
		driver.switchTo().defaultContent(); // come out of Frame2
		
//		Interact with Nested iFrame :-
		
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		
		driver.switchTo().frame(frame3);
		
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("I am inside Frame 3");
		
		WebElement iFrame = driver.findElement(By.xpath("//iFrame"));
		
		driver.switchTo().frame(iFrame);
		
		
	}

}
