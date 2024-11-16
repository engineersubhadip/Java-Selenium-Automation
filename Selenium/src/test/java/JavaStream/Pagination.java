package JavaStream;

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

public class Pagination {
	
	static List<String> captureAllVegetables(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='pagination pull-right']")));
		
//		WebElement nextButton = driver.findElement(By.xpath("//ul[@class='pagination pull-right'] //a[@aria-label='Next']/parent::*"));
		
		List<String> result = new ArrayList<>();
		
		while (true) {
		    List<WebElement> currList = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
		    for (WebElement currEle : currList) {
		        result.add(currEle.getText());
		    }
		    
		    // Locate and wait until nextButton is clickable before proceeding
		    WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='pagination pull-right'] //a[@aria-label='Next']/parent::*")));
		    
		    // Check if the button is disabled by inspecting its class attribute
		    if (nextButton.getAttribute("class").contains("disabled")) {
		        break;
		    }
		    
		    // Click the next button if it's enabled and clickable
		    nextButton.click();
		    Thread.sleep(500); // Allow some time for the next page to load
		}


		return result;
	}

	
	static List<String> sortOriginalList(List<String> vegList) {
		
		List<String> result =  vegList.stream().sorted().collect(Collectors.toList());
		return result;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='pagination pull-right']")));
		
//		Capture all the vegetable name in their original order :-		
		
		List<String> originalOrder = captureAllVegetables(driver, wait); // original list of vegetables
		
//		Click on the First Button :-
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//ul[@class='pagination pull-right']/li[1]/a")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(@class,'sort-descending')]")).click();
		
		Thread.sleep(2000);
		
		List<String> UISortedOrder = captureAllVegetables(driver, wait);
		
		
		List<String> originalSortedOrder = sortOriginalList(originalOrder);

		Assert.assertTrue(UISortedOrder.equals(originalSortedOrder));

		Thread.sleep(2000);
	
		driver.close();
	}

}
