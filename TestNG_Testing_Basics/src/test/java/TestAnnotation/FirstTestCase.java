package TestAnnotation;

import org.testng.annotations.Test;


/*
 * 1. Open the App
 * 2. Login into the App
 * 3. Logut from the App
 */

public class FirstTestCase {
	
	@Test
	public void openApp() {
		System.out.println("Opening the App...");
	}
	
	@Test
	public void loginApp() {
		System.out.println("Logging into the App...");
	}
	
	@Test
	public void logoutApp() {
		System.out.println("Logging out from the App...");
	}
}
