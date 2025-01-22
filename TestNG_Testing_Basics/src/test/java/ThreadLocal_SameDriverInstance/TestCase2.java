package ThreadLocal_SameDriverInstance;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {
	
	@Test
	public void testCase2 () {
		try {
			driver.navigate().to("https://www.nykaa.com/");
			Thread.sleep(3000);
			System.out.println("From Test Case 2 "+driver.getTitle());
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("From test case 2 "+e.getMessage());
			Assert.fail();
		}
	}
}
