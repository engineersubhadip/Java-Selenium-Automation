package Submenu;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Submenu {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.flipkart.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String parentID = driver.getWindowHandle();
		
		Actions a = new Actions(driver);
		
//		//div[@class='_3ETuFY'] // img[contains(@alt,'Beauty, Toys & More')]
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_3ETuFY'] // img[contains(@alt,'Beauty, Toys & More')]")));
		
		a.moveToElement(driver.findElement(By.xpath("//div[@class='_3ETuFY'] // img[contains(@alt,'Beauty, Toys & More')]"))).build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_16rZTH'] //a[contains(@href,'babycare')]")));
		
		a.moveToElement(driver.findElement(By.xpath("//div[@class='_16rZTH'] //a[contains(@href,'babycare')]"))).build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_31z7R_'] //a[contains(@href,'baby-wipes')]")));
		
		Thread.sleep(2000);
		
		a.moveToElement(driver.findElement(By.xpath("//div[@class='_31z7R_'] //a[contains(@href,'baby-wipes')]"))).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='WOvzF4'] //div[@class='ZWmcSB']")));
		
		a.moveToElement(driver.findElement(By.xpath("//div[@class='WOvzF4'] //div[@class='ZWmcSB']"))).contextClick().build().perform();
	}

}
