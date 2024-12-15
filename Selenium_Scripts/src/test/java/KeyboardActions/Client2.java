package KeyboardActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Open Registration link in a new tab
 * Do actions on the new Tab
 */

public class Client2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.titleContains("nopCommerce demo store"));

		WebElement regLink = driver.findElement(By.xpath("//a[contains(@href,'register')]"));

		Actions a = new Actions(driver);

		a.moveToElement(regLink).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
		
//		Best way to handle :- Switching between windows:-
		
		List<String> windowHandles = new ArrayList (driver.getWindowHandles());

		String parentWindow = windowHandles.get(0); // Index 0 will always give parent window
		
		String childWindow = windowHandles.get(1); // from 1 onwards we have child windows

		driver.switchTo().window(childWindow);

		wait.until(ExpectedConditions.titleContains("nopCommerce demo store. Register"));

		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Clothes");
		
		Thread.sleep(1000);
		
		driver.close();

		driver.switchTo().window(parentWindow);

		a.moveToElement(driver.findElement(By.xpath("//div[@class='header-logo']"))).contextClick().build().perform();
		
		Thread.sleep(1000);
		
		driver.close();
	}

}
