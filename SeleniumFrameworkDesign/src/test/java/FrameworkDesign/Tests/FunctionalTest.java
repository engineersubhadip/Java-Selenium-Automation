package FrameworkDesign.Tests;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameworkDesign.PageObjects.BillingPage;
import FrameworkDesign.PageObjects.CartVerification;
import FrameworkDesign.PageObjects.OrdersPage;
import FrameworkDesign.PageObjects.ProductCatalogue;
import FrameworkDesign.TestComponent.BaseTest;

public class FunctionalTest extends BaseTest{


		String userPurchase = "adidas";
		
		@Test(dataProvider="data")
		public void endToEndTest(String userEmail, String userPassword) throws IOException, InterruptedException {
			
//			Login Page :-
			
			ArrayList<Object> object = loginPage.loginApplication(userEmail, userPassword);
			
			ProductCatalogue productcatalogue = (ProductCatalogue) object.get(0);
			
//			Product Catalogue Page :-
			
			CartVerification cartverification = productcatalogue.addProductToCart(userPurchase);
			
			Assert.assertEquals(productcatalogue.cartVerification(), "Product Added To Cart"); 
		
			
//			Verification of Cart and Place Order :-
			
			Assert.assertTrue(cartverification.verifyCart(userPurchase));
			
			cartverification.selectCountry("ind", "India");
			
			BillingPage billingpage = cartverification.checkoutClick();
			
//			Billing Page :-
			
			Assert.assertEquals(billingpage.getConfirmMessage(), "Thankyou for the order.".toLowerCase());
		}

		@Test(dependsOnMethods= {"endToEndTest"}, dataProvider="data")
		public void findProductTest(String userEmail, String userPassword) throws InterruptedException {
			
//			Login Page :-
			
			ArrayList<Object> object =  loginPage.loginApplication(userEmail, userPassword);
			
			OrdersPage orderspage = (OrdersPage) object.get(1);
			
//			Orders Page :-
			
			Assert.assertTrue(orderspage.checkProduct(userPurchase));
		}
		
		
		@DataProvider(name="data") 
		public Object[][] getData() {
			return new Object[][] {{"r1@abc.com","Test@1234"},{"shetty@gmail.com","Iamking@000"}};
		}
}
