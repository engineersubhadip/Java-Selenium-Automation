package ExtraPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Select value from the AutoSuggest Drop Down via Down Arrow in FlipKart

public class Client4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='Pke_EE']")));
		
		WebElement autoSuggestBox = driver.findElement(By.xpath("//input[@class='Pke_EE']"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(autoSuggestBox).click().build().perform();
		
		Thread.sleep(1000);
		
		autoSuggestBox.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		autoSuggestBox.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		autoSuggestBox.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		autoSuggestBox.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		autoSuggestBox.sendKeys(Keys.ENTER);
	}

}
