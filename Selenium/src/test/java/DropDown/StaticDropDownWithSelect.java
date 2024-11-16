package DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDownWithSelect {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		Select selectDropDown = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']")));
		
//		select option based on index :-
		
//		selectDropDown.selectByIndex(3); // to select USD
		
//		Check if we have selected USD currency or not
		
//		WebElement usd = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']/child::option[@value='USD']"));
		
//		if (selectDropDown.getFirstSelectedOption().equals(usd)) {
//			System.out.println(true);
//		}
		
//		select option based on visible text :-
		
		selectDropDown.selectByVisibleText("AED");
		
	}

}
