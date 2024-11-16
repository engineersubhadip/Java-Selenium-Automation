package Day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XPathLocator {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		
		driver.manage().window().maximize();
		
//		driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys("Tshirt"); // absolute xPath
		
//		xpath with single attribute :-  (Working)
		
		
//		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Laptop"); // relative xpath
		
//		driver.findElement(By.xpath("//img[@title=\"MacBook\"]")).click(); // using relative xpath to click the MacBook
		
//		xpath with multiple attributes :-(working)
		
//		driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("Toffee");
		
		
//		capturing the inner text (working)
		
//		String text = driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
//		System.out.println(text);
		
		
		
//		xpath with innertext (working)
		
//		driver.findElement(By.linkText("Tablets")).click();
		
//		driver.findElement(By.xpath("//a[text()='Tablets']")).click();
		
		
//		driver.findElement(By.xpath("//a[text()='MacBook']")).click(); // getting ElementClickInterceptedException
		
//		WebElement res = driver.findElement(By.linkText("MacBook"));// getting ElementClickInterceptedException
//		res.click();//// getting ElementClickInterceptedException
		
//		xpath with contains :- (Working)
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Sear')]")).sendKeys("toffee");
		
	}

}
