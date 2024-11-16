package Assertions;

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
		
//		1. Before clicking the checkBox I want to make sure it is not selected :- 
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
//		Will turn out to be :-
//		Assert.assertFalse(False);
//		Assert.assertFalse() will expect a False Condition inside it. Then the test will pass
//		and proceed to next step.
//		If, Assert.assertFalse(true) :- Then it will fail
		
		
//		2. click friends and family checkbox
		
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
//		* denotes regular expression (only valid for css selector)
//		For xPath use contains
		
		
//		3. After clicking I want to know if the checkBox is selected or not :-
		
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		

//		4. Printing the number of ChekBoxes present in the Page :-
		
		int checkBoxCount =  driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		System.out.println("Total Number of CheckBoxes : "+checkBoxCount);
		
		
//		5. I want to see if I have 5 adults in the passenger count or not :-
		
		WebElement dropDown = driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
		dropDown.click();
		
		Thread.sleep(1500);
		
		WebElement adultPlus = driver.findElement(By.xpath("//span[@id='hrefIncAdt']"));

		for (int i = 0; i < 4; i++) {
			adultPlus.click();
		}

		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		
		Assert.assertEquals(dropDown.getText(), "5 Adult");
		
	}

}