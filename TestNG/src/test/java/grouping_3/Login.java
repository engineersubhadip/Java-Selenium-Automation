package grouping_3;

import org.testng.annotations.Test;

public class Login {
	
	@Test(priority=1 , groups={"sanity"})
	public void loginEmail() {
		System.out.println("Log-in with Email...");
	}
	
	@Test(priority=2, groups={"sanity"})
	public void loginFacebook() {
		System.out.println("Log-in with Facebook...");
	}
	
	@Test(priority=3, groups={"sanity"})
	public void loginTwitter() {
		System.out.println("Log-in with Twitter...");
	}
}
