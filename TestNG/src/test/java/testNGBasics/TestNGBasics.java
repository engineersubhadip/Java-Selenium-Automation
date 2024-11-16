package testNGBasics;

import org.testng.annotations.Test;

/*
 * 1. Open the Application
 * 2. Go to the Login Page
 * 3. Logout from the Application
 */

public class TestNGBasics {
	
	@Test(priority=1)
	public void openApplication() { 
		System.out.println("Open the Application");
	}
	
	@Test(priority=2)
	public void login() {
		System.out.println("Log-in the Application");
	}
	
	@Test(priority=3)
	public void logout() {
		System.out.println("Log-out the Application");
	}
	
}
