package DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestivedropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
		
		Thread.sleep(2000);
		
		List<WebElement> suggestion =  driver.findElements(By.xpath("//ul[@id='ui-id-1']/child::*/a")); // getting all the list of webelements for keyword ("ind") 
		
//		target is to click on india :-
		
		for (int i=0; i<suggestion.size(); i++) {
			WebElement currEle = suggestion.get(i);
			if (currEle.getText().equals("India")) {
				currEle.click();
				break;
			}
		}
	}

}
