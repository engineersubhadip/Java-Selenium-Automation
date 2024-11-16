package DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
//		locate the input box :-
		
		Thread.sleep(1200);
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("MacBook");
		
//		Choose macbook air m3 :-
		
		Thread.sleep(1200);
		
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='YGcVZO _2VHNef']"));

		for (WebElement currProduct : productList) {
			if (currProduct.getText().contains("macbook air m3")) {
				currProduct.click();
				break;
			}
		}
	}

}
