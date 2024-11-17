package annotations_2.before_after_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1 {
	
	@BeforeTest
	public void bt() {
		System.out.println("Before test execution.");
	}
	
	@Test
	public void fun1() {
		System.out.println("Fun1 from Class1");
	}
	
	@Test
	public void fun2() {
		System.out.println("Fun2 from Class1");
	}
}
