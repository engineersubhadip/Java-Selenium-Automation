package ExtraPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Client1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		
//		Select DropDown :-
		
		Select selectDropDown = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']")));
		
		System.out.println(selectDropDown.getFirstSelectedOption().getText());
		
//		Auto-suggestive DropDown :-
		
		driver.findElement(By.xpath("//input[@id='autosuggest']")).click();		
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("au");
		
		Thread.sleep(1500);
		
		List<WebElement> countryList = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		
		for (WebElement currEle : countryList) { 
			if (currEle.getText().equals("Macau")) {
				currEle.click();
				break;
			}
		}
		
		if(driver.findElement(By.xpath("//input[@id='autosuggest']")).getText().length() > 0) {
			Assert.assertTrue(true);
		}
		
	}

}
