package ExecutingSpecificMethodsInsideClass;

import org.testng.annotations.Test;

/*
 * If we have to run specific methods for a particular Class, this is driven via XML
 */

public class loginTests {
	
	@Test
	public void loginViaEmail() {
		System.out.println("Logging in via Email..");
	}
	
	@Test
	public void loginViaFacebook() {
		System.out.println("Logging in via Facebook..");
	}
	
	@Test
	public void loginViaSSHKey() {
		System.out.println("Logging in via SSH Key..");
	}
	
	@Test
	public void loginViaX() {
		System.out.println("Logging in via X..");
	}
}
