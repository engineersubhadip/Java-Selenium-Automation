package FrameworkDesign.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import FrameworkDesign.PageObjects.BillingPage;
import FrameworkDesign.PageObjects.CartVerification;
import FrameworkDesign.PageObjects.LandingPage;
import FrameworkDesign.PageObjects.ProductCatalogue;
import FrameworkDesign.TestComponent.BaseTest;

public class ErrorValidations extends BaseTest{

		@Test
		public void loginErrorValidation() throws IOException, InterruptedException {
//			User Credentials :-

			String userEmail = "r16@abc.com";
			String userPassword = "Test@1234";
			
//			Login Page :-
			
			loginPage.loginApplication(userEmail, userPassword);
			
			Assert.assertEquals(loginPage.getErrorMessage(), "Incorrect email or password.");
		}
		
		@Test
		public void productErrorValidation() throws IOException, InterruptedException {
//			User Credentials :-

			String userEmail = "r1@abc.com";
			String userPassword = "Test@1234";
			String userPurchase = "adidas";
			
//			Login Page :-
			
			loginPage.loginApplication(userEmail, userPassword);

//			Product Catalogue Page :-
			
			ProductCatalogue productcatalogue = new ProductCatalogue(driver);
			
			productcatalogue.addProductToCart(userPurchase);
			
			CartVerification cartverification = new CartVerification(driver);
			
			Assert.assertEquals(cartverification.verifyCart(userPurchase),true); 
		
		}

	
}
