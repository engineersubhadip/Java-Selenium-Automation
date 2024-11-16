package JavaStream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// Capture Item Price on 1st page

public class ItemPrice {
	
	static int getPrice(WebDriver driver, String name) {
		List<WebElement> table = driver.findElements(By.xpath("//tr/td[1]"));
		String price = "";
		
		for (int i = 0; i<table.size(); i++) {
			if (table.get(i).getText().contains(name)) {
				price = driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
				break;
			}
		}
		
		Integer value = Integer.parseInt(price);
		
		return value;
	}
	
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		List<WebElement> vegWebEle = driver.findElements(By.xpath("//tr/td[1]"));
		
		vegWebEle.stream().filter(currEle -> currEle.getText().contains("Rice")).collect(Collectors.toList()).forEach(currEle -> System.out.println(getPrice(driver, currEle.getText())));
		
	}

}
