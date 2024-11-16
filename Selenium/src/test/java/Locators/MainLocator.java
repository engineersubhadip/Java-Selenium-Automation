package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MainLocator {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
//		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("inputUsername")).sendKeys("Rituparna"); // ID Locator
		driver.findElement(By.name("inputPassword")).sendKeys("academy123"); // name Locator
		
		driver.findElement(By.className("signInBtn")).click(); // className locator
		
		// CSS Selector :-
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); // tagName.className
		
		driver.findElement(By.linkText("Forgot your password?")).click(); // linkText Locator)
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rituparna");
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("ndnandita@gmail.com");
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("dasritu@gmail.com"); // xpath via index
		
//		driver.findElement(By.cssSelector("input[@type='text']:nth-child(2)")).sendKeys("dasritu@gmail.com"); // css selector via index
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("732876"); // travelling from parent to child
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		String userPassword =  grabPassword(driver);
		
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Rituparna");
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(userPassword);
		
		driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();
		
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();  // Click "Go to Login" button :- ElementClickInterceptedException
		
		
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText(), "You are successfully logged in."); // assertions to validate success message
		
		driver.findElement(By.xpath("//button[@class='logout-btn']")).click(); // clicked logout btn
		
		driver.close();
		
	}
	
	static String grabPassword(WebDriver driver) {
		
		String message = driver.findElement(By.xpath("//form/p")).getText();
		String password = message.split(" ")[4];
		System.out.println("Password "+password);
		
		String ans = "";
		
		for (int i=0; i<password.length(); i++) {
			char currChar = password.charAt(i);
			int currASCII = (int)currChar;
			
			if ((currASCII >= 65 && currASCII <= 90) || (currASCII >= 97 && currASCII <= 122)) {
				ans += currChar;
			}
		}
		return ans;
	}

}
