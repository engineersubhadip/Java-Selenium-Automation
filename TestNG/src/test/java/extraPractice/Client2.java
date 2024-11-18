package extraPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * 1. Open Google
 * 2. Search Selenium WebDriver
 * 3. Click on Search Button
 * 4. Verify the first result contains the term "Selenium WebDriver"
 */
public class Client2 {
	
	WebDriver driver;
	WebDriverWait wait;
	String parentWindowID;
	
	private String userInput = "WebDriver";
	
	@BeforeClass
	public void openURL() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();		
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void searchFunctionality() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textArea[@class='gLFyf']")));
		parentWindowID = driver.getWindowHandle(); // above wait usage is :- Once the page fully loads I am capturing the parent window handle
		
		WebElement inputBox = driver.findElement(By.xpath("//textArea[@class='gLFyf']"));
		inputBox.sendKeys(userInput);
		inputBox.sendKeys(Keys.ENTER);
	}
	
	@Test
	public void verifyRecord() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dURPMd']")));
		
		List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class='dURPMd'] //h3"));
		String actualResult = searchResult.get(0).getText();
		
		Assert.assertEquals(userInput, actualResult);
	}
	
	@AfterClass
	public void closeURL() {
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
