package DependencyMethods;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
1. If we put Assertions in the BeforeClass, and it fails. Then all the @Test will be skipped.
 */

public class PuttingAssertionsInBeforeClass {
	
	@BeforeClass
	public void openApp() {
		System.out.println("Opening the App.");
		Assert.assertTrue(false);
		System.out.println("After opening");
	}
	
	@Test(priority=1)
	public void login() {
		System.out.println("Logging into the App");
	}
	
	@Test(priority=2)
	public void search() {
		System.out.println("Performing searching");
	}
	
	@Test(priority=3)
	public void logout() {
		System.out.println("logging out from the App");
	}
}
