package DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamicdropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.manage().window().maximize();
		
		WebElement departure = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
		departure.click();
		
//		driver.findElement(By.xpath("//a[@value='BLR']")).click(); // departure city
		
//		Thread.sleep(2000);
		
//		Dynamic Dropdown Selection :- Via Indexing
		
//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); // arrival city
		
//		Dynamic Dropdown Selection :- Without Indexing (Best Approach) [parent-child xpath]
		
//		1. You capture the whole From/Arrival Box's XPath.
//		2. Give Space.
//		3. Provide Xpath of From/Arrival City.
		
//		Selenium will look for the Child Xpath inside the Scope of the Parent XPath
		
		driver.findElement(By.xpath("//table[@id='citydropdown'] //a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
	}

}
