package grouping_3;

import org.testng.annotations.Test;

public class Register {
	
	@Test(priority=1, groups={"regression"})
	public void registerEmail() {
		System.out.println("Register with Email...");
	}
	
	@Test(priority=2, groups={"regression"})
	public void registerFacebook() {
		System.out.println("Register with Facebook...");
	}
	
	@Test(priority=3, groups={"regression"})
	public void registerTwitter() {
		System.out.println("Register with Twitter...");
	}
	
	
}
