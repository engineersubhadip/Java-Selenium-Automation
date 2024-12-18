package DependencyMethods;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C3_BeforeAfterTest {
	
	@BeforeTest
	public void bt() {
		System.out.println("Before test from C3");
	}
	
	@Test
	public void login () {
		System.out.println("Login from C3");
	}
	
	@Test
	public void logout () {
		System.out.println("Logout from C3");
	}
	
}
