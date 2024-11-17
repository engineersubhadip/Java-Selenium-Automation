package annotations_2.combinedAnnotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Class2 {
	@Test
	public void fun3() {
		System.out.println("Fun 3 from Class 2");
	}
	
	@Test
	public void fun4() {
		System.out.println("Fun 4 from Class 2");
	}
	
	@AfterTest
	public void at() {
		System.out.println("After Test Execution of Test Module 1");
	}
}
