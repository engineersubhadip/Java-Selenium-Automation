package Practice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Client {
	
	@BeforeClass
	public void openApp() {
		System.out.println("Opening the App");
		Assert.assertTrue(false);
	}
	
	@Test(priority=1) 
	public void login() { //skipped
		System.out.println("Logging in the App..");
	}
	
	@Test(priority=2)
	public void search() { //skipped
		System.out.println("Search in the App..");
	}
	
	@AfterClass 
	public void tearDown() { //skipped
		System.out.println("Closing the App");
	}
}
