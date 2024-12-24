package Practice;
/*
 1. Open App
 2. Login
 3. Logout
 */

import org.testng.annotations.Test;

public class Client1 {
	
	@Test
	public void openApp() {
		System.out.println("Opening the App...");
	}
	
	@Test
	public void login() {
		System.out.println("Logging into the App...");
	}
	
	@Test
	public void logout() {
		System.out.println("Logging out from the App...");
	}
}
