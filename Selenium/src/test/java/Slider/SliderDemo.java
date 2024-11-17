package Slider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement minSlider = driver.findElement(By.xpath("//div[@id='slider-range']/span[1]"));
		
		int xMin = minSlider.getLocation().getX();
		int yMin = minSlider.getLocation().getY();
		
		Actions a = new Actions(driver);
		
		a.dragAndDropBy(minSlider, 100, yMin).build().perform();
		
		int currXMin = minSlider.getLocation().getX();
		
		
		WebElement maxSlider = driver.findElement(By.xpath("//div[@id='slider-range']/span[2]"));
		
		int xMax = maxSlider.getLocation().getX();
		int yMax = maxSlider.getLocation().getY();
		
		System.out.println("Max Slider X Cord : "+xMax);
		a.dragAndDropBy(maxSlider, -350, yMax).build().perform();
		
		int currXMax = maxSlider.getLocation().getX();
		
		System.out.println("Max Slider current X Cord "+currXMax);
	}

}
