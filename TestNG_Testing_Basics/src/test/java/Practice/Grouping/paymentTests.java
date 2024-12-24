package Practice.Grouping;

import org.testng.annotations.Test;

public class paymentTests {
	
	@Test(priority = 1, groups = {"sanity", "regression", "functional"})
	public void payViaEuros() {
		System.out.println("Paying via Euros..");
	}
	
	@Test(priority = 2, groups = {"sanity", "regression", "functional"})
	public void payViaRupees() {
		System.out.println("Paying via Rupees..");
	}
}
