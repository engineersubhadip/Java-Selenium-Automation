package CheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.manage().window().maximize();
		
//		click friends and family checkbox
		
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
//		* denotes regular expression (only valid for css selector)
//		For xPath use contains
		
		
//		After clicking I want to know if the checkBox is selected or not :-
		
		boolean checkBoxStatus = driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected();
		System.out.println("CheckBox selected ? "+checkBoxStatus);
		
//		Printing the number of ChekBoxes present in the Page :-
		
		int checkBoxCount =  driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		System.out.println("Total Number of CheckBoxes : "+checkBoxCount);
	}

}
