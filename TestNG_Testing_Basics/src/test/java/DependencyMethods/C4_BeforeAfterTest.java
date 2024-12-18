package DependencyMethods;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C4_BeforeAfterTest {
	
	@AfterTest
	public void at() {
		System.out.println("After test from C4");
	}
	
	
	@Test
	public void login () {
		System.out.println("Login from C4");
	}
	
	@Test
	public void logout () {
		System.out.println("Logout from C4");
	}
}
