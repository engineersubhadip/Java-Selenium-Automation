package grouping_3;

import org.testng.annotations.Test;

public class Payment {
	
	@Test(priority=1, groups={"regression","sanity","functional"})
	public void payWithCard() {
		System.out.println("Paying with Card...");
	}
	
	@Test(priority=2, groups={"regression","sanity","functional"})
	public void payWithUPI() {
		System.out.println("Paying with UPI...");
	}
}
