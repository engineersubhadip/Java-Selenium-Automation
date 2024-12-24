package Practice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C22 {
	
	@AfterTest
	public void at() {
		System.out.println("After test from C22");
	}
	
	@Test
	public void login() {
		System.out.println("Login from C22..");
	}
	
	@Test
	public void logout() {
		System.out.println("Logout from C22..");
	}
}
