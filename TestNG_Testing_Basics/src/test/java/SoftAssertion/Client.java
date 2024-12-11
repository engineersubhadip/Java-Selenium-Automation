package SoftAssertion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Client {
	
	@Test
	public void softAssert() {
		System.out.println(1);
		System.out.println(2);
		
		SoftAssert sf = new SoftAssert();
		
		sf.assertEquals(23, 44);
		
		System.out.println(3);
		System.out.println(4);
		
		sf.assertAll();
	}
}
