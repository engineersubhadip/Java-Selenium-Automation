package Practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Login
 * Search
 * Logout
 * Login
 * Adv Search
 * Logout
 * 
 * Before and After Method is specific to particular Class.
 * They are executed multiple times before and after starting/ending of each @Test
 */


public class BeforeAfterMethod {
	
	@BeforeMethod
	public void Login() {
		System.out.println("Logging into App.");
	}
	
	@Test(priority=1)
	public void Search() {
		System.out.println("Searching in the App");
	}
	
	@Test(priority=2)
	public void AdvSearch() {
		System.out.println("Adv Search in the App");
	}
	
	@AfterMethod
	public void Logout() {
		System.out.println("Logging out from the App");
	}
}
