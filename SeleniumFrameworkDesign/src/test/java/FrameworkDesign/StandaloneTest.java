package FrameworkDesign;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/client");

//		User Credentials :-

		String userEmail = "r1@abc.com";
		String userPassword = "Test@1234";
		String userPurchase = "adidas";
		
//		Login Page :-

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userEmail']")));

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(userEmail);

		driver.findElement(By.xpath("//input[@id='userPassword']")).click();

		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys(userPassword);

		driver.findElement(By.xpath("//input[@id='login']")).click();

//		Products Page :-
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='products']/div[@class='container']")));
		
		List<WebElement> productList = driver.findElements(
				By.xpath("//section[@id='products']/div[@class='container']/div[2] //div[@class='card']"));

//		Adding adidas to my cart :-

		productList.stream()
				.filter(currEle -> currEle.findElement(By.xpath("div[@class='card-body'] //h5")).getText().toLowerCase()
						.contains(userPurchase)).limit(1)
				.forEach(currEle -> currEle.findElement(By.xpath("div[@class='card-body'] //button[2]")).click());
		
//		Capture the Green Message after adding to cart :-
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container'] //div[@aria-label='Product Added To Cart']")));
		
		String alertMsg = driver.findElement(By.xpath("//div[@id='toast-container'] //div[@aria-label='Product Added To Cart']")).getText();
		
		
		Assert.assertEquals(alertMsg, "Product Added To Cart");
		
		driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
		
//		Verify the Products added in the Cart Section :-
		
		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cart'] //li //h3"));
		
		int cartProductCount = cartProducts.stream().filter(currEle -> currEle.getText().toLowerCase().contains(userPurchase)).collect(Collectors.toList()).size();
		
		Assert.assertEquals(cartProductCount, 1);
		
		driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
		
		WebElement autoBox = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		
		autoBox.click();
		
		autoBox.sendKeys("ind");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'ng-star-inserted')] //button")));
		
		List<WebElement> countryList = driver.findElements(By.xpath("//section[contains(@class,'ng-star-inserted')] //button"));
		
		try {
			countryList.stream().filter(currEle -> currEle.getText().equalsIgnoreCase("India")).forEach(currEle -> currEle.click());			
		}catch(StaleElementReferenceException e) {
			WebElement placeOrderButton = driver.findElement(By.xpath("//div[@class='actions']/a"));
			placeOrderButton.click();
		}

//		Billing Page :-
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		
		String confirmMsg = driver.findElement(By.tagName("h1")).getText();
		
		Assert.assertEquals(confirmMsg.toLowerCase(), "Thankyou for the order.".toLowerCase());
		
		driver.quit();
	}
}
