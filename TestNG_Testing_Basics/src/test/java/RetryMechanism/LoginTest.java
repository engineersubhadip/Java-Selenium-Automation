package RetryMechanism;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	/*
	@Test(retryAnalyzer = RetryMechanism.RetryAnalyzer.class)
	public void TC001_LoginTest () throws InterruptedException {
		Assert.assertEquals(true, false);
	}
	*/
	
	@Test
	public void TC001_LoginTest () throws InterruptedException {
		Assert.assertEquals(true, false);
	}
}
