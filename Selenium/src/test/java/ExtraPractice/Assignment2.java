// YET TO COMPLETE :-

package ExtraPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/?tag=googmantxtmob170-21&ascsubtag=_k_Cj0KCQjw7Py4BhCbARIsAMMx-_LG-WM16e5Z2hjnX2RKjSb0VRnyLIsF9hu7LACH6SE7aJL45d1bHHkaAsqXEALw_wcB_k_");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		int linkCount = driver.findElements(By.tagName("a")).size();
		System.out.println(linkCount);
		
		driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
		
		Thread.sleep(2000);
		
		List<WebElement> categoryList =  driver.findElements(By.xpath("//child::ul[@class='hmenu hmenu-visible']/child::*"));
		
		for (int i=0; i<categoryList.size(); i++) {
			WebElement currEle = categoryList.get(i);
			if (currEle.getText().contains("Echo & Alexa")) {
				currEle.click();
				break;
			}
		}
		
		Thread.sleep(2500);
		driver.findElement(By.xpath("//ul[contains(@class,'hmenu-visible')]/child::li/a[contains(text(),'Meet')]")).click();
		
//		List<WebElement> currentCategory =  driver.findElements(By.xpath("//ul[contains(@class,'hmenu-visible')]/child::li"));
//		
//		for (int i=0; i<currentCategory.size(); i++) {
//			WebElement currEle = currentCategory.get(i);
//			if (currEle.getText().contains("Meet Alexa")) {
//				System.out.println("Entered the domain");
//				Thread.sleep(5000);
//				currEle.click();
//				break;
//			}
//		}
		
	}

}
