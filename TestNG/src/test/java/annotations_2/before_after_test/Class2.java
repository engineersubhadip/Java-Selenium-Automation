package annotations_2.before_after_test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Class2 {
	
	@Test
	public void fun3() {
		System.out.println("Fun3 from Class2");
	}
	
	@Test
	public void fun4() {
		System.out.println("Fun4 from Class2");
	}
	
	@AfterTest
	public void at() {
		System.out.println("After Test Execution.");
	}
}
