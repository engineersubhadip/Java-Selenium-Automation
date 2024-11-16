package ExtraPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Client3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(2200);
		
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("skirt");
		
		Thread.sleep(1500);
		
		List<WebElement> productList =  driver.findElements(By.xpath("//div[@class='YGcVZO _2VHNef']"));
		
		for (int i=0; i<productList.size(); i++) {
			if (productList.get(i).getText().contains("skirt kurti")) {
				productList.get(i).click();
				break;
			}
		}
	}

}
