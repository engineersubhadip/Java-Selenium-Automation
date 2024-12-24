package Practice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C2 {
	
	@AfterTest
	public void at() {
		System.out.println("After Test from C2");
	}
	@Test
	public void login() {
		System.out.println("Logging into the App from C2..");
	}
	
	@Test
	public void search() {
		System.out.println("Searching in the App from C2...");
	}
}
