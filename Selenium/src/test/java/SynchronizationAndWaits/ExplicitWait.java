package SynchronizationAndWaits;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ExplicitWait {

	static void findTargetElement(WebDriver driver, List<WebElement> arr) {

		for (int i = 0; i < arr.size(); i++) {
			String currElementDescription = arr.get(i).getText();
			if (currElementDescription.equals("Cucumber - 1 Kg")) {
				driver.findElements(By.xpath("//button[contains(text(),'ADD TO')]")).get(i).click();
				break;
			}
		}
	}
	
	static void clickTargetElement(WebDriver driver, List<WebElement> arr, String targetElement) {
		
		for (int i=0; i<arr.size(); i++) {
			String currEleDescription = arr.get(i).getText();
			if (currEleDescription.contains(targetElement)) {
				driver.findElements(By.xpath("//button[contains(text(),'ADD TO')]")).get(i).click();
			}
		}
	}
	
	static void buyItems(WebDriver driver, List<WebElement> arr, String shoppingList[]) {
		
		int itemsFound = 0;
		
		for (int i=0; i<arr.size(); i++) {
			String currItem = arr.get(i).getText();
			for (int j=0; j<shoppingList.length; j++) {
				String refItem = shoppingList[j];
				if (currItem.contains(refItem)) {
					driver.findElements(By.xpath("//div[@class='product-action']/child::button")).get(i).click();
					itemsFound ++;
				}
				
			}
			if (itemsFound == shoppingList.length) {
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // tackle proceed to checkout
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // tackle proceed to checkout  
		
		String shoppingList[] = {"Beetroot","Cucumber","Brocolli"};
		List<WebElement> productDescription = driver
		.findElements(By.xpath("//div[@class='product']/child::h4[@class='product-name']"));
		
		buyItems(driver, productDescription, shoppingList);
		
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click(); // clicking on Cart button
		
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click(); // clicking on proceed to checkout
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy"); // appling the promo code
		
		driver.findElement(By.xpath("//div[@class='promoWrapper']/button")).click(); // Click on Apply
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText(), "Code applied ..!"); // validating coupon text
		
		driver.findElement(By.xpath("//div[@class='products']/div/button")).click(); // click on place order
	}

}
