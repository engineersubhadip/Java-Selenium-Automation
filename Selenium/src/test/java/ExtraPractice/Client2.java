package ExtraPractice;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Client2 {

	static void addItemToCart(List<WebElement> productList, HashSet<String> shoppingItem, WebDriver driver) {
		
		int itemShopped = 0;
		
		for (int i = 0; i < productList.size(); i++) {
			WebElement currItem = productList.get(i);
			String currItemDescription = currItem.getText().split(" ")[0];
			
			if (shoppingItem.contains(currItemDescription)) {
				driver.findElements(By.xpath("//div[@class='product'] //div[@class='product-action']/child::button")).get(i).click();
				itemShopped ++;
			}
			
			if (itemShopped == shoppingItem.size()) {
				break;
			}
		}
	}

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		Thread.sleep(2000);

		HashSet<String> shoppingItem = new HashSet<>();

		shoppingItem.add("Cucumber");
		shoppingItem.add("Brocolli");
		shoppingItem.add("Beetroot");

		List<WebElement> productList = driver.findElements(By.xpath("//h4[@class='product-name']"));

//		We will make this below code generic :-

//		for (int i=0; i<productList.size(); i++) {
//			WebElement currEle = productList.get(i);
//			if (currEle.getText().contains("Cucumber")) {
//				System.out.println(currEle.getText());
//				System.out.println("Yes");
//				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
//				break;
//			}
//		}

//		Line 49 optimally :-

		addItemToCart(productList, shoppingItem, driver);
	}

}
