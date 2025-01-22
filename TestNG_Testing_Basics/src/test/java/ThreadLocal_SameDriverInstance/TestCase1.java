package ThreadLocal_SameDriverInstance;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {
	
	@Test
	public void testCase1 () {
		try {
			driver.navigate().to("https://www.flipkart.com/");
			Thread.sleep(3000);
			System.out.println("From Test case 1 "+driver.getTitle());
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("From Test case 1"+e.getMessage());
			Assert.fail();
		}
	}
}
