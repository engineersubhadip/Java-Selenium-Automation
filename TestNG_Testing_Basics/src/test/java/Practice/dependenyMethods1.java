package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * 1. Open App
 * 2. Login
 * 3. Search
 * 4. Adv Search
 * 5. Logout
 * 
 * Pointers :-
 * 1. dependsOnMethods only applicable in @Tests -> Meaning one @Test will depend on another @Test
 * 2. If we do not provide any dependencyMethods, then testNG will execute everything even if one @Test gets failed.
 * 3. Using dependsOnMethods, if one @Test gets failed/skipped then the Child @Test will DEFINATELY BE SKIPPED.
 */


public class dependenyMethods1 {
	
	@Test(priority=1)
	public void openApp() {
		System.out.println("Opening the App..");
	}
	
	@Test(priority=2, dependsOnMethods = {"openApp"})
	public void login() {
		System.out.println("Logging in the App..");
	}
	
	@Test(priority=3 , dependsOnMethods = {"login"})
	public void search() {
		System.out.println("Doing Search..");
	}
	
	@Test(priority=4, dependsOnMethods = {"login","search"})
	public void advSearch() {
		System.out.println("Doing Advance Search..");
		Assert.assertTrue(false);
	}
	
	@Test(priority=5, dependsOnMethods = {"login"})
	public void logout() {
		System.out.println("Logging out from the App..");
	}
}
