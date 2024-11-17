package annotations_2.combinedAnnotations;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1 {
	
	@BeforeSuite
	public void bs() {
		System.out.println("Before Suite Execution...");
	}
	@Test
	public void fun1() {
		System.out.println("Fun 1 from Class 1");
	}
	
	@Test
	public void fun2() {
		System.out.println("Fun 2 from Class 1");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("Before Test Execution for Test Module 1");
	}
}
