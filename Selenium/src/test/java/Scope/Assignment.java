package Scope;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		Task 1 :-
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='checkBoxOption2']"));
		String checkBoxText = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		
		checkBox.click(); // clicking on the Check-box
		
		String finalCheckBoxText = checkBoxText.trim();
		
//		Task 2 :-
		
		Select selectDropDown = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
		
		selectDropDown.selectByVisibleText(finalCheckBoxText); // selecting drop down value dynamically
		
//		Task 3 :-
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(finalCheckBoxText); // entering the text dynamically in alert box
		
//		Task 4 :-
		
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
//		Task 5 :-
		
		String alertText =  driver.switchTo().alert().getText();
		
		String targetText = alertText.split(",")[0].split(" ")[1];
		
		if (targetText.equals(finalCheckBoxText)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
