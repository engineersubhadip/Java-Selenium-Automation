package Practice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C44 {
	
	@AfterTest
	public void at() {
		System.out.println("After test from C44");
	}
	
	@Test
	public void login() {
		System.out.println("Login from C44..");
	}
	
	@Test
	public void logout() {
		System.out.println("logout from C44..");
	}
}
