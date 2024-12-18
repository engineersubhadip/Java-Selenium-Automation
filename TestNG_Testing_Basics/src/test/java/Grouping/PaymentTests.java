package Grouping;

import org.testng.annotations.Test;

/*
 If a test case belongs to multiple categories provide a separate name for that
 */

public class PaymentTests {
	
	@Test(priority=1, groups= {"sanity","regression","functional"})
	public void paymentInRupees() {
		System.out.println("Payment in rupees");
	}
	
	@Test(priority=2, groups= {"sanity","regression","functional"})
	public void paymentInDollars() {
		System.out.println("Payment in dollars");
	}
}
