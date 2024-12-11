package BeforeAfterClassAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * 1. Login -> @BeforeClass
 * 2. Search -> @Test
 * 3. Adv. Search -> @Test
 * 4. Logout -> @AfterClass
 */

public class BeforeAfterClass {
	
	@BeforeClass
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
	
	@AfterClass
	public void logout() {
		System.out.println("Logging out from the App...");
	}
}
