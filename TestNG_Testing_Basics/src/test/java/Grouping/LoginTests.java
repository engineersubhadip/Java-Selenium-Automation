package Grouping;

import org.testng.annotations.Test;

public class LoginTests {
	
	@Test(priority=1, groups= {"sanity"})
	public void loginViaEmail() {
		System.out.println("Login via Email..");
	}
	
	@Test(priority=2, groups= {"sanity"})
	public void loginViaFacebook() {
		System.out.println("Login via Facebook..");
	}
}
