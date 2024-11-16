package DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticDropDownWithoutSelect {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.manage().window().maximize();

		WebElement dropDown = driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
		dropDown.click();
		
		int dropDownSize = driver.findElements(By.xpath("//div[@id='divpaxOptions']/child::div[@class='ad-row']")).size();
		System.out.println("Dropdown contains "+dropDownSize+" elements.");
		
		WebElement adultPlus = driver.findElement(By.xpath("//span[@id='hrefIncAdt']"));

		for (int i = 0; i < 4; i++) {
			adultPlus.click();
		}

		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		
//		After selecting 5 adults I want to see what text is getting printed 
		
		String finalText = dropDown.getText(); // taking from line 15 as text inside it is dynamic
		System.out.println(finalText);
	}

}
