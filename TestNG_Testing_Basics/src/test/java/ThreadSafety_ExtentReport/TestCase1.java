package ThreadSafety_ExtentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {
	
	@Test
	public void testCase1 () {
		WebDriverWait wait = new WebDriverWait(tLocalDriver.get(), Duration.ofSeconds(10));
		try {
			tLocalDriver.get().findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']")));
			tLocalDriver.get().findElement(By.xpath("//a[normalize-space()='Register']")).click();
			wait.until(ExpectedConditions.titleContains("Register Account"));
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("I am failing from "+this.getClass().getName());
			System.out.println("Reason "+e.getMessage());
			Assert.fail();
		}
	}
}
