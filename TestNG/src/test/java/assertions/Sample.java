package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample {
	
	@Test
	public void checkTitle() {
		String exp_title = "ShopCart";
		String act_title = "ShopCart";
		
//		if (exp_title.equals(act_title)) {
//			System.out.println("Test Passed");
//		}else {
//			System.out.println("Test Failed");
//		}
		
		Assert.assertEquals(exp_title, act_title);
		
		int arr1[]= {12,13,14};
		int arr2[]= {12,15,14};
		
		Assert.assertEquals(arr1, arr2);
	}
}
