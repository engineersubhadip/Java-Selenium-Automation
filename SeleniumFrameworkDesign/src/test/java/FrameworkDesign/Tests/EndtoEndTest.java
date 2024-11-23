package FrameworkDesign.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import FrameworkDesign.PageObjects.BillingPage;
import FrameworkDesign.PageObjects.CartVerification;
import FrameworkDesign.PageObjects.LandingPage;
import FrameworkDesign.PageObjects.ProductCatalogue;
import FrameworkDesign.TestComponent.BaseTest;

public class EndtoEndTest extends BaseTest{

		@Test
		public void endToEndTest() throws IOException, InterruptedException {
//			User Credentials :-

			String userEmail = "r1@abc.com";
			String userPassword = "Test@1234";
			String userPurchase = "adidas";
			
//			Login Page :-
			
			loginPage.loginApplication(userEmail, userPassword);

//			Product Catalogue Page :-
			
			ProductCatalogue productcatalogue = new ProductCatalogue(driver);
			
			productcatalogue.addProductToCart(userPurchase);
			
			Assert.assertEquals(productcatalogue.cartVerification(), "Product Added To Cart"); 
		
			
//			Verification of Cart and Place Order :-
			
			CartVerification cartverification = new CartVerification(driver);
			
			Assert.assertEquals(cartverification.verifyCart(userPurchase),true);
			
			cartverification.selectCountry("ind", "India");
			
			cartverification.checkoutClick();
			
//			Billing Page :-
			
			BillingPage billingpage = new BillingPage(driver);
			
			Assert.assertEquals(billingpage.getConfirmMessage(), "Thankyou for the order.".toLowerCase());
		}
//		
	
}
