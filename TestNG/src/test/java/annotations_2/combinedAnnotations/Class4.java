package annotations_2.combinedAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class4 {
	
	@BeforeClass
	public void bc() {
		System.out.println("Before Class 4..");
	}
	
	@AfterClass
	public void ac() {
		System.out.println("After Class 4..");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("Before Test Execution for Test Module 2");
	}
	@Test
	public void fun7() {
		System.out.println("Fun 7 from Class 4");
	}
	
	@Test
	public void fun8() {
		System.out.println("Fun 8 from Class 4");
	}
}
