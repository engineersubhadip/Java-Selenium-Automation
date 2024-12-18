package DependencyMethods;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * 1. Open App
 * 2. Login
 * 3. Search
 * 4. Adv Search
 * 5. Logout
 * 
 * dependsOnMethods -> Only works for @Test annotation. Meaning one @Test will be dependent on another @Test
 * If one @Test fails/skips, then all the dependent Methods will also be skipped
 * 
 * Without dependenyMethods, if one @Test fails, then the other @Test will still be executed
 */

public class HappyPath {
	
	@Test(priority=1)
	public void openApp() {
		System.out.println("Opening the App");
	}
	
	@Test(dependsOnMethods= {"openApp"},priority=2)
	public void login() {
		System.out.println("Logging in the App");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods= {"login"},priority=3)
	public void search() {
		System.out.println("Searching in the App");
	}
	
	@Test(dependsOnMethods= {"login"},priority=4)
	public void advSearch() {
		System.out.println("Adv Search in the App");
	}
	
	@Test(dependsOnMethods= {"login"},priority=5)
	public void logout() {
		System.out.println("Logging out from the App");
	}
}
