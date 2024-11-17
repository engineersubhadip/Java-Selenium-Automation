package annotations_2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * 1. Login
 * 2. Search
 * 3. Logout
 * 4. Login
 * 5. Adv Search
 * 6. Logout
 */

public class Before_After_Method {
	
	@BeforeMethod
	public void login() {
		System.out.println("Logging in the Application...");
	}
	
	@Test
	public void search() {
		System.out.println("This is the Search Functionality.");
	}
	
	@Test
	public void advSearch() {
		System.out.println("This is the Advance Seach Functionality.");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logging out of the Application...");
	}
}
