package JavaStream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Check if the item is present in any of the WebPage, if YES print its price

public class Pagination2 {
	
	static String getPrice(WebDriver driver, String userItem) throws InterruptedException {
		String itemPrice = "";
		
		while (true) {
			List<WebElement> currProducts = driver.findElements(By.xpath("//tr/td[1]"));
			
			List<WebElement> product = currProducts.stream().filter(currEle -> currEle.getText().contains(userItem)).collect(Collectors.toList());
			
			if (product.size() > 0) {
//				We have captured the product 
				itemPrice = product.get(0).findElement(By.xpath("following-sibling::td[1]")).getText();
				break;
			}else {
				WebElement nextButton = driver.findElement(By.xpath("//ul[@class='pagination pull-right'] //a[@aria-label='Next']/parent::*"));
				
				if (nextButton.isEnabled()) {
					nextButton.click();
					Thread.sleep(300);
				}else {
					break;
				}
			}
		}
		return itemPrice;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String itemPrice = getPrice(driver, "Mango");
		
		if (itemPrice.length() == 0) {
			System.out.println(0);
		}else {
			int price = Integer.parseInt(itemPrice);
			System.out.println(price);
		}
		
		Thread.sleep(2500);
		
		driver.close();
	}

}
