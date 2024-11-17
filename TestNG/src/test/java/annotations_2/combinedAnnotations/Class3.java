package annotations_2.combinedAnnotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Class3 {
	
	@BeforeMethod
	public void bm() {
		System.out.println("Before Method from Class 3");
	}
	
	@Test
	public void fun5() {
		System.out.println("Fun 5 from Class 3");
	}
	
	@Test
	public void fun6() {
		System.out.println("Fun 6 from Class 3");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("After Method from Class 3");
	}
	
	@AfterSuite
	public void bs() {
		System.out.println("After Suite Execution...");
	}
	
	@AfterTest
	public void at() {
		System.out.println("After Test execution for Test Module 2");
	}
}
