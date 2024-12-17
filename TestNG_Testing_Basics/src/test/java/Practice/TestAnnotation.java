package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAnnotation {
	
	@Test
	public void setUp() {
		System.out.println("Inside set up method");
		Assert.assertEquals(true, false);
		System.out.println("Clocking out from Set Up Method");
	}
	
	@Test
	public void zeroOut() {
		System.out.println("Inside zero out method");
	}
}
