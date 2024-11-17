package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample {
	
	@Test
	public void checkTitle() {
		String exp_title = "ShopCart";
		String act_title = "ShopShop";
		
//		if (exp_title.equals(act_title)) {
//			System.out.println("Test Passed");
//		}else {
//			System.out.println("Test Failed");
//		}
		
		Assert.assertEquals(exp_title, act_title);
	}
}
