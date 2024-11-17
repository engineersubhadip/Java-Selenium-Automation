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
		
		Actions a = new Actions(driver);
		
		a.dragAndDropBy(minSlider, xMin+100, 0).build().perform();
	}

}
