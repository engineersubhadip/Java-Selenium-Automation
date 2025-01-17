package ThreadSafety_ExtentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {
	
	@Test
	public void testCase2 () {
		WebDriverWait wait = new WebDriverWait(tLocalDriver.get(), Duration.ofSeconds(10));
		try {
			tLocalDriver.get().findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']")));
			tLocalDriver.get().findElement(By.xpath("//a[normalize-space()='Login']")).click();
			wait.until(ExpectedConditions.titleContains("Account Login"));
			Assert.assertTrue(false);
		} catch (Exception e) {
			System.out.println("Test case failed "+this.getClass().getName());
			System.out.println("Reason "+e.getMessage());
			Assert.fail();
		}
	}
}
