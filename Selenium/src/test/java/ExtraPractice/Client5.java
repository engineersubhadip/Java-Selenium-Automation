package ExtraPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//	Hover on Fashion Tag

public class Client5 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		List<WebElement> imgTags = driver.findElements(By.xpath("//div[@class='_3ETuFY']/div[@class='_2GaeWJ']/img"));
		
		WebElement target = null;
		
		for (WebElement currEle : imgTags) {
			if (currEle.getAttribute("alt").contains("Fashion")) {
				target = currEle;
				break;
			}
		}
		
		Actions a = new Actions(driver);
		
		a.moveToElement(target).build().perform();
		
//		Hover on Men's Bottom Wear :-
		
		Thread.sleep(2000);
		
		a.moveToElement(driver.findElement(By.xpath("//div[@class='_16rZTH']/object/a[3]"))).build().perform();
		
//		Click on Men's Kurtas on the side Pane :-
		
		Thread.sleep(2000);
		
		a.moveToElement(driver.findElement(By.xpath("//div[@class='_31z7R_']/object/a[5]"))).click().build().perform();
	}

}
