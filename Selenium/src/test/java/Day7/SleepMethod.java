package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SleepMethod {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(5000); // to handle NoSuchElementException
//		Before interacting with "//input[@name='username']" element, we are asking to wait for 5s
		
//		Enter userName :-
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("bond007"); // NoSuchElementException
//		Meaning the Script is unable to locate the webelement on the webpage
//		Synchronization issue

	}

}
