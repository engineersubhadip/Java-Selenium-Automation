package Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * Login
 * Search
 * Adv Search
 * Logout
 * 
 * BeforeAfterClass is specific to a particular Class.
 * BeforeClass is executed only once before the execution of any of the @Test
 * AfterClass is executed only once after the execution of any of the @Test
 */

public class BeforeAfterClass {
	
	@BeforeClass
	public void login() {
		System.out.println("Logging into the App...");
	}
	
	@Test(priority=1)
	public void search() {
		System.out.println("Searching into the App...");
	}
	
	@Test(priority=2)
	public void advSearch() {
		System.out.println("Performing Adv Search...");
	}
	
	@AfterClass
	public void logout() {
		System.out.println("Logging out from the App...");
	}
}
