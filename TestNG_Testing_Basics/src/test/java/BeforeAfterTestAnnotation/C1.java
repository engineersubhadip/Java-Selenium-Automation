package BeforeAfterTestAnnotation;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
