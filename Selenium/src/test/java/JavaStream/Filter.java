package JavaStream;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Filter {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String userInput = "app";
		
		driver.findElement(By.cssSelector("#search-field")).sendKeys(userInput);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody //tr")));
		
		List<WebElement> productList =  driver.findElements(By.xpath("//tbody //tr/td[1]"));
		
		
		List<String> productName =  productList.stream().filter(currEle -> currEle.getText().toLowerCase().contains(userInput)).map(currEle -> currEle.getText()).collect(Collectors.toList());
		
		productName.forEach(currEle -> System.out.println(currEle));
		
		Thread.sleep(2500);
		
		driver.close();

	}

}
