package ExtraPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StreamPractice {
	
	static List<String> captureProductNames(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		
		List<String> productName = new ArrayList<>();
		
		while (true) {
//			Capture the products in the current Page :-
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[1]")));
			
			List<WebElement> arr = driver.findElements(By.xpath("//tr/td[1]"));
			
			List<String> name = arr.stream().map(currEle -> currEle.getText()).collect(Collectors.toList());
			
			for (String currName : name) {
				productName.add(currName);
			}
			
//			Capture the Next Button :-
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='pagination pull-right'] //a[@aria-label='Next']/parent::*")));
			
			WebElement nextButton = driver.findElement(By.xpath("//ul[@class='pagination pull-right'] //a[@aria-label='Next']/parent::*"));
			
			if (nextButton.getAttribute("class").contains("disabled")) {
				break;
			}
			nextButton.click();
		}
		
		return productName;
	}
	
	static List<String> sortName(List<String> name) {
		
		List<String> sortedList =  name.stream().sorted().collect(Collectors.toList());
		
		return sortedList;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
//		1. Check if products are sorted properly
		
		List<String> originalOrder = captureProductNames(driver, wait); // captured the originalOrder
		
		List<String> expectedSortedOrder = sortName(originalOrder);
		
//		2. Click on the "First" Button to get to the First Page and Click on Sort Button to sort the UI
		
		Thread.sleep(2500);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='First']")));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='First']")));
		
		driver.findElement(By.xpath("//a[@aria-label='First']")).click(); // clicked on First Button
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='sort-icon sort-descending']")));
		
		driver.findElement(By.xpath("//span[@class='sort-icon sort-descending']")).click(); // clicked on the sort button
		
		Thread.sleep(2500);
		
		List<String> uiOrder = captureProductNames(driver, wait);
		
		Assert.assertTrue(expectedSortedOrder.equals(uiOrder)); // FINAL CHECK OF ORDER
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
