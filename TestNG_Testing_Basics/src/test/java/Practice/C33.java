package Practice;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C33 {
	
	@BeforeTest
	public void bt() {
		System.out.println("Before test from C33");
	}
	
	@Test
	public void login() {
		System.out.println("Login from C33..");
	}
	
	@Test
	public void logout() {
		System.out.println("Logout from C33..");
	}
}
