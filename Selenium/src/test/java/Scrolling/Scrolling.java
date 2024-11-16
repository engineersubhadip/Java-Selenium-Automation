package Scrolling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrolling {
	
	static int getSum(WebDriver driver, List<WebElement> priceArr) {
		int totalSum = 0;
		
		for (WebElement currEle : priceArr) {
			String currPrice = currEle.getText();
			int price = Integer.parseInt(currPrice);
			totalSum += price;
		}
		
		return totalSum;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,550)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=600");
		
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=0");
		
		List<WebElement> priceArr =  driver.findElements(By.cssSelector("div[class='tableFixHead'] table[id='product'] tbody tr td:nth-child(4)"));
		
		int totalPrice = getSum(driver, priceArr);
		
		System.out.println("The total Price is "+totalPrice);
		
		String dispPrice = driver.findElement(By.cssSelector("div[class='totalAmount']")).getText();
		
		int dispPriceVal = Integer.parseInt(dispPrice.split(":")[1].trim());
		
		Assert.assertEquals(dispPriceVal, totalPrice);
	}

}
