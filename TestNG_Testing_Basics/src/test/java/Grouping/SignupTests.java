package Grouping;

import org.testng.annotations.Test;

public class SignupTests {
	
	@Test(priority=1, groups= {"regression"})
	public void signupViaEmail() {
		System.out.println("Sign Up via Email");
	}
	
	@Test(priority=2, groups= {"regression"})
	public void signupViaFacebook() {
		System.out.println("Sign Up via Facebook");
	}
}
