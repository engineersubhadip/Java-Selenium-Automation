package ThreadSafe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestCase1 extends Parent {

	@Test
	public void captureTitle() throws InterruptedException {
		driver = new ChromeDriver();
		setDriver(driver);
		driver = getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
//		String result = driver.getTitle();
		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Selenium Training",Keys.ENTER);
//		driver
		Thread.sleep(3000);
//		System.out.println(result);
	}
	
	@AfterClass
	public void tearDown() {
		tLocal.remove();
		driver.quit();
	}
}