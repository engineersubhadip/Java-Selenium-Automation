package Practice.Grouping;

import org.testng.annotations.Test;

public class signupTests {
	
	@Test(priority = 1, groups = {"regression"})
	public void signupViaEmail() {
		System.out.println("Sign up via Email..");
	}
	
	@Test(priority = 2, groups = {"regression"})
	public void signupViaFacebook() {
		System.out.println("Sign up via Facebook..");
	}
}
