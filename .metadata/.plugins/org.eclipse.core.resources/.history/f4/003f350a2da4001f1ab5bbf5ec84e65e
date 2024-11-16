package Calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.manage().window().maximize();
		
		
//		1. Selecting Departure Location and Arrival Location:-
		
		WebElement departure = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
		departure.click();
		
		driver.findElement(By.xpath("//table[@id='citydropdown'] //a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		
//		2. Selecting Friends and Family CheckBox :-
		Thread.sleep(1500);
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
//		3(A). Selecting Round-Trip radio button :-
		
		Thread.sleep(1500);
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='Trip_1']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='Trip_1']")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='Trip_1']")).isSelected());
		
//		3(B). Selecting One-way radio button :-
		
		Thread.sleep(2000);
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='Trip_0']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='Trip_0']")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='Trip_0']")).isSelected());
		
		
//		3(C) . Making sure Round-trip went off :-
		
		Thread.sleep(1500);
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='Trip_1']")).isSelected());
		
		
//		4:- Selecting the departure date :- (Select the current date) 
		
//		Using Parent - Child Relationship (One which we learned in Dynamic Dropdown)
		
		
		Assert.assertFalse(driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar'] //td[contains(@class,'ui-datepicker-today')]/child::a")).isSelected());
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
		
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar'] //td[contains(@class,'ui-datepicker-today')]/child::a")).click();
		
//		We should not pick arrival date as it is a one way ticket
		
		
//		5. Selecting 4 Adults :-
		
		Thread.sleep(1500);
		
		WebElement dropDown = driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
		dropDown.click();

		Thread.sleep(1500);

		WebElement adultPlus = driver.findElement(By.xpath("//span[@id='hrefIncAdt']"));
		
		for (int i = 0; i < 4; i++) {
			Thread.sleep(1000);
			adultPlus.click();
		}
		
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();

		Assert.assertEquals(dropDown.getText(), "5 Adult");
		
	}

}
