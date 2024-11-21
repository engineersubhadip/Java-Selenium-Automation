package FrameworkDesign;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandaloneTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/client");

//		User Credentials :-

		String userEmail = "r1@abc.com";
		String userPassword = "Test@1234";

//		Login Page :-

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userEmail']")));

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(userEmail);

		driver.findElement(By.xpath("//input[@id='userPassword']")).click();

		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys(userPassword);

		driver.findElement(By.xpath("//input[@id='login']")).click();

//		Products Page :-

		List<WebElement> productList = driver.findElements(
				By.xpath("//section[@id='products']/div[@class='container']/div[2] //div[@class='card']"));

//		Adding adidas to my cart :-

		productList.stream()
				.filter(currEle -> currEle.findElement(By.xpath("div[@class='card-body'] //h5")).getText().toLowerCase()
						.contains("adidas")).limit(1)
				.forEach(currEle -> currEle.findElement(By.xpath("div[@class='card-body'] //button[2]")).click());
		
		
	}
}
