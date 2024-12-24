package Practice;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {
	@BeforeTest
	public void bt() {
		System.out.println("Before Test from C1");
	}
	@Test
	public void advSearch() {
		System.out.println("Adv Search from C1...");
	}
}
