package Practice;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C4 {
	
	@BeforeTest
	public void bt2() {
		System.out.println("Before Test from C4");
	}
	@Test
	public void bye() {
		System.out.println("Bye from C4");
	}
}
