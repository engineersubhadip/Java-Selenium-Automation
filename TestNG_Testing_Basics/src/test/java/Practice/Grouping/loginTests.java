package Practice.Grouping;

/*
 Steps to be performed :-
 1. During Manual Testing, identify the @Tests and segregate them in their respective groups.
 2. Grouping concept is driven ONLY VIA XML FILE.
 */

import org.testng.annotations.Test;

public class loginTests {
	
	@Test(priority = 1, groups = {"sanity"})
	public void loginViaEmail() {
		System.out.println("Logging via Email..");
	}
	
	@Test(priority = 2, groups = {"sanity"})
	public void loginViaFacebook() {
		System.out.println("Logging via Facebook..");
	}
}
