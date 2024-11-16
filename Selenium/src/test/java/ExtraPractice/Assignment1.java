package ExtraPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/?tag=googmantxtmob170-21&ascsubtag=_k_Cj0KCQjw7Py4BhCbARIsAMMx-_LG-WM16e5Z2hjnX2RKjSb0VRnyLIsF9hu7LACH6SE7aJL45d1bHHkaAsqXEALw_wcB_k_");
		driver.manage().window().maximize();
		
		Thread.sleep(1500);
		
//		Part - 1:-
		
		Select allDropDown = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
		
//		Selecting by index :- (Selecting Books Category)
		
//		allDropDown.selectByIndex(12);
		
//		Selecting by value :- (Selecting All Categories)
		
		allDropDown.selectByValue("search-alias=stripbooks");
		
//		Part - 2:-
		Thread.sleep(1750);
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		
		searchBox.sendKeys("hit");
		
		Thread.sleep(1350);
		
		List<WebElement> options =  driver.findElements(By.xpath("//div[@class='s-suggestion-container']/child::div[@class='s-suggestion s-suggestion-ellipsis-direction']/child::*"));
		
		for (WebElement currOption : options) {
			System.out.println(currOption.getText());
			if (currOption.getText().equalsIgnoreCase("chhiker's guide to galaxy") == true) {
				currOption.click();
				break;
			}
		}
	}

}
