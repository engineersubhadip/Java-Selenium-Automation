package ThreadSafety_ExtentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 extends BaseTest {
	@Test
	public void testCase3() {
		
		WebDriverWait wait = new WebDriverWait(tLocalDriver.get(), Duration.ofSeconds(10));
		try {
			tLocalDriver.get().findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("iPhone",Keys.ENTER);
			Thread.sleep(2000);
			Assert.fail();
		} catch (Exception e) {
			System.out.println("Test case failed " + this.getClass().getName());
			System.out.println("Reason " + e.getMessage());
			Assert.fail();
		}
	}
}
