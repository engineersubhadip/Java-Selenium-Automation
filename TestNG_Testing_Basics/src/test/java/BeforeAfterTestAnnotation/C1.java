package BeforeAfterTestAnnotation;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * To use beforeTest and AfterTest we  need to have 2 Classes at least
 */

public class C1 {
	@Test
	public void abc() {
		System.out.println("This is abc from C1");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("This is Before Test from C1");
	}
}
