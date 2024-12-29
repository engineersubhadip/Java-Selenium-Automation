package RetryMechanism;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	/*
	@Test(retryAnalyzer = RetryMechanism.RetryAnalyzer.class)
	public void TC001_LoginTest () throws InterruptedException {
		Assert.assertEquals(true, false);
	}
	*/
	
	@BeforeMethod
	public void bt () {
		System.out.println("Inside Before Method");
	}
	
	
	@Test
	public void TC001_LoginTest () throws InterruptedException {
		System.out.println("Inside Test Case");
		Assert.assertEquals(true, false);
	}
}
