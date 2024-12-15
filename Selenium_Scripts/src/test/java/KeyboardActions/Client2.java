package KeyboardActions;

import java.time.Duration;
import java.util.Set;

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

		String currWindow = driver.getWindowHandle();

		wait.until(ExpectedConditions.titleContains("nopCommerce demo store"));

		WebElement regLink = driver.findElement(By.xpath("//a[contains(@href,'register')]"));

		Actions a = new Actions(driver);

		a.moveToElement(regLink).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();

		Set<String> windowHandles = driver.getWindowHandles();

		String tarWindow = windowHandles.stream().filter(currEle -> {
			if (currEle.equals(currWindow)) {
				return false;
			} else {
				return true;
			}
		}).toList().get(0);

		driver.switchTo().window(tarWindow);

		wait.until(ExpectedConditions.titleContains("nopCommerce demo store. Register"));

		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Clothes");
		
		Thread.sleep(1000);
		
		driver.close();

		driver.switchTo().window(currWindow);

		a.moveToElement(driver.findElement(By.xpath("//div[@class='header-logo']"))).contextClick().build().perform();
		
		Thread.sleep(1000);
		
		driver.close();
	}

}
