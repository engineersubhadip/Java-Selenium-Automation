package CheckBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
//		1(A). Check the checkBox1 and verify if it is checked/not
		
		WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
		checkBox1.click();
		
		Assert.assertTrue(checkBox1.isSelected());
		
//		1(B). Uncheck it again and verify if it is unchecked/not
		checkBox1.click();
		
		Assert.assertFalse(checkBox1.isSelected());
		
//		2. Count the number of CheckBoxes in the Screen :-
		
		int checkBoxCount = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		
		System.out.println(checkBoxCount);
	}

}
