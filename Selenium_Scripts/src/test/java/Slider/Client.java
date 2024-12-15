package Slider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * For Horizontal Slider, increase/decrease X-axis; Y-axis will be const
 * For vertical Slider, increase/decrease Y-axis; X-axis will be const
 */



public class Client {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.titleContains("jQuery UI Price Range Slider Demo"));
		
		WebElement leftSlider = driver.findElement(By.xpath("//div[@id='slider-range'] //span[1]"));
		
		WebElement rightSlider = driver.findElement(By.xpath("//div[@id='slider-range'] //span[2]"));
		
		int leftX =  leftSlider.getLocation().getX();
		int leftY =  leftSlider.getLocation().getY();
		
		int rightX =  rightSlider.getLocation().getX();
		int rightY =  rightSlider.getLocation().getY();
		
		System.out.println("LeftX -> "+leftX+" RightX -> "+rightX);
		
		Actions a = new Actions(driver);
		
		a.dragAndDropBy(leftSlider, 100, leftY).build().perform(); // 100 denotes how much I want to increase leftX by, leftY is const
		
		a.dragAndDropBy(rightSlider, -200, rightY).build().perform(); // -200 denotes how much I want to decrease rightX by, rightY is const
		
		System.out.println(leftSlider.getLocation().getX());
		
		System.out.println(rightSlider.getLocation().getX());
		
	}

}
