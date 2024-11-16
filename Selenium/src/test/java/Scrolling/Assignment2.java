package Scrolling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(driver.findElement(By.xpath("//input[@id='autocomplete']"))).click().sendKeys("unit").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='ui-id-1']")));
		
		Thread.sleep(1500);
		
//		Approach 3 :- Via Down Arrow :-
		
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ENTER);
		
//		Approach 1 :- HardCoded Index Value (Not a good solution) (via Mouse
		
		a.moveToElement(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[4]"))).click().build().perform();
//		
//		Approach 2 :- Selecting it Dynamically :-
		
		List<WebElement> countryList =  driver.findElements(By.xpath("//ul[@id='ui-id-1'] //li"));
		
		for (WebElement currEle : countryList) {
			if (currEle.getText().contains("United States")) {
				currEle.click();
				break;
			}
		}
		
		String autoSuggestBoxValue =  driver.findElement(By.xpath("//input[@id='autocomplete']")).getAttribute("value");
		
		if (autoSuggestBoxValue.contains("United States")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		driver.close();
	}

}
