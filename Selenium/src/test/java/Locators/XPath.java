package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
//		driver.get("https://demo.wpeverest.com/user-registration/online-event-registration-form/");
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		//a[@title="Cart"]/child::img[1]
		
		driver.findElement(By.xpath("//a[@title=\"Cart\"]/child::img[1]")).click(); // Add to cart button :- Airtel SDET
		
//		1. Capturing userID xPath :- (single attribute)
		
//		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("subhadipDas");
		
//		2. Capturing userID xPath :- (Multiple attributes)
		
//		driver.findElement(By.xpath("//input[@type='email'][@name='user_email']")).sendKeys("nanditaDas");
		
//		3. Capturing xpath with "and" operator :-
		
//		driver.findElement(By.xpath("//input[@id=\"user_email\" and @type=\"email\"]")).sendKeys("dummyInput");
		
//		4. Capturing xpath with "or" operator :-
		
//		driver.findElement(By.xpath("//input[@type=\"email\" or @name=\"incorrectValue\"]")).sendKeys("helloPost");
		
//		5. Capturing xpath with "contains()" method :-
		
//		driver.findElement(By.xpath("//input[contains(@class,\"input-email ur-frontend\")]")).sendKeys("helloAgain");
		
//		6. Capturing inner Text :-
		
		
		
	}

}
