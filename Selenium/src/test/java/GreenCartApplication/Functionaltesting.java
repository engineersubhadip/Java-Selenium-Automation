package GreenCartApplication;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Functionaltesting {

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

//		Clicking on Cucumber :-
//		driver.findElement(By.xpath("//div[@class='products']/div[3]/div[@class='product-action']/child::*")).click(); // not advisable
//		since if next day more products get added then div[3] might change its index

//		driver.findElement(
//				By.xpath("//h4[text()='Cucumber - 1 Kg']/following-sibling::div[@class='product-action']/child::*"))
//				.click(); // acceptable

//		2nd approach :- Via Iteration (Best Approach)
//		List<WebElement> productDescription = driver
//				.findElements(By.xpath("//div[@class='product']/child::h4[@class='product-name']"));

//		findTargetElement(driver, productDescription); // clicking on Cucumber's Add to Cart
		
//		Adding any commodity in cart
//		List<WebElement> productDescription = driver
//				.findElements(By.xpath("//div[@class='product']/child::h4[@class='product-name']"));
		
//		clickTargetElement(driver, productDescription, "Carrot");
		
//		Adding a list of commodities to the cart
		
		String shoppingList[] = {"Beetroot","Mushroom","Tomato","Mango"};
		List<WebElement> productDescription = driver
		.findElements(By.xpath("//div[@class='product']/child::h4[@class='product-name']"));
		
		buyItems(driver, productDescription, shoppingList);
	}

}
