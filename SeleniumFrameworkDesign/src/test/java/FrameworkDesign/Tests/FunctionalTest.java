package FrameworkDesign.Tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameworkDesign.PageObjects.BillingPage;
import FrameworkDesign.PageObjects.CartVerification;
import FrameworkDesign.PageObjects.OrdersPage;
import FrameworkDesign.PageObjects.ProductCatalogue;
import FrameworkDesign.TestComponent.BaseTest;

public class FunctionalTest extends BaseTest{

		
		@Test(dataProvider="data", groups= {"purchase"})
		public void endToEndTest(HashMap<String, String> data) throws IOException, InterruptedException {
			
//			Login Page :-
			
			ArrayList<Object> object = loginPage.loginApplication(data.get("userEmail"), data.get("userPassword"));
			
			ProductCatalogue productcatalogue = (ProductCatalogue) object.get(0);
			
//			Product Catalogue Page :-
			
			CartVerification cartverification = productcatalogue.addProductToCart(data.get("userPurchase"));
			
			Assert.assertEquals(productcatalogue.cartVerification(), "Product Added To Cart"); 
		
			
//			Verification of Cart and Place Order :-
			
			Assert.assertTrue(cartverification.verifyCart(data.get("userPurchase")));
			
			cartverification.selectCountry("ind", "India");
			
			BillingPage billingpage = cartverification.checkoutClick();
			
//			Billing Page :-
			
			Assert.assertEquals(billingpage.getConfirmMessage(), "Thankyou for the order.".toLowerCase());
		}

		@Test(dependsOnMethods= {"endToEndTest"}, dataProvider="data")
		public void findProductTest(HashMap<String, String> data) throws InterruptedException {
			
//			Login Page :-
			
			ArrayList<Object> object =  loginPage.loginApplication(data.get("userEmail"), data.get("userPassword"));
			
			OrdersPage orderspage = (OrdersPage) object.get(1);
			
//			Orders Page :-
			
			Assert.assertTrue(orderspage.checkProduct(data.get("userPurchase")));
		}
		
		
		@DataProvider(name="data") 
		public Object[][] getData() {
			
			HashMap<String, String> hashMap1 = new HashMap<>();
			
			hashMap1.put("userEmail","r1@abc.com");
			hashMap1.put("userPassword","Test@1234");
			hashMap1.put("userPurchase","adidas");
			
			HashMap<String, String> hashMap2 = new HashMap<>();
			
			hashMap2.put("userEmail","shetty@gmail.com");
			hashMap2.put("userPassword","Iamking@000");
			hashMap2.put("userPurchase","iphone");
			
			return new Object[][] {{hashMap1},{hashMap2}};
		}
}
