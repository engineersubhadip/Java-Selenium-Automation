package annotations_2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * 1. Login
 * 2. Search
 * 3. Advance Search
 * 4. Logout 
 */


public class Before_After_Class {
	
	@BeforeClass
	public void login() {
		System.out.println("Logging in the Application...");
	}
	
	@Test(priority=1)
	public void search() {
		System.out.println("Search Functionality.");
	}
	
	@Test(priority=2)
	public void advanceSearch() {
		System.out.println("Advance Search Functionality");
	}
	
	@AfterClass
	public void logout() {
		System.out.println("Logging off the Application...");
	}
}
