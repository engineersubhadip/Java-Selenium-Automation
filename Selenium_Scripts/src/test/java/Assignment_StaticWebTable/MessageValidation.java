package Assignment_StaticWebTable;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MessageValidation {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://blazedemo.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.titleContains("BlazeDemo"));

		Select fromSelect = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));

		fromSelect.selectByVisibleText("San Diego");

		Select destSelect = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));

		destSelect.selectByVisibleText("Berlin");

		WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Find Flights']"));

		submitBtn.click();
		
//		Actual Story :-

		wait.until(ExpectedConditions.titleContains("BlazeDemo - reserve"));

		WebElement table = driver.findElement(By.xpath("//table[@class='table']"));
		
		WebElement targetBtn = null;

		int rowCount = table.findElements(By.xpath("//tr")).size();

		int colCount = table.findElements(By.xpath("//th")).size();
		
		Double minPrice = Double.MAX_VALUE;
		
		for (int r = 1; r <= rowCount; r++) {
			try {
				
			WebElement chooseFlightOption = table.findElement(By.xpath("./tbody//tr["+r+"]//td[1] //input"));
			String price = table.findElement(By.xpath("./tbody//tr["+r+"]//td[6]")).getText();
			String priceStr = price.split("[$]")[1];
			Double ticketPrice = Double.parseDouble(priceStr);

			if (ticketPrice < minPrice) {
				minPrice = ticketPrice;
				targetBtn = chooseFlightOption;
			}
			} catch(Exception e) {
			}
		}
		
		targetBtn.click();
		
		wait.until(ExpectedConditions.titleContains("BlazeDemo Purchase"));
		
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		wait.until(ExpectedConditions.titleContains("BlazeDemo Confirmation"));
		
		String result = driver.findElement(By.xpath("//h1")).getText();
		
		Assert.assertEquals(result, "Thank you for your purchase today!");
		
		System.out.println("Ending Test case.");
		
		Thread.sleep(1000);
		driver.quit();
	}

}
