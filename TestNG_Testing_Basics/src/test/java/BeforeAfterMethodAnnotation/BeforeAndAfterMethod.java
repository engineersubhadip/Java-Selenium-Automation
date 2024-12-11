package BeforeAfterMethodAnnotation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * 1. Login -> @BeforeMethod
 * 2. Search -> @Test
 * 3. Logout -> @AfterMethod
 * 4. Login
 * 5. Adv.Seach -> @Test
 * 6. Logout
 */

public class BeforeAndAfterMethod {
	
	@BeforeMethod
	public void login() {
		System.out.println("Logging into the App...");
	}
	
	@Test(priority=1)
	public void search() {
		System.out.println("Searching into App..");
	}
	
	@Test(priority=2)
	public void advSearch() {
		System.out.println("Adv Search into App...");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logging out from the App...");
	}
	
}
