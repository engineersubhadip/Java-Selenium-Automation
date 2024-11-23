package FrameworkDesign;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import FrameworkDesign.PageObjects.BillingPage;
import FrameworkDesign.PageObjects.CartVerification;
import FrameworkDesign.PageObjects.LandingPage;
import FrameworkDesign.PageObjects.ProductCatalogue;

public class EndtoEndTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

//		User Credentials :-

		String userEmail = "r1@abc.com";
		String userPassword = "Test@1234";
		String userPurchase = "adidas";
		
//		Login Page :-

		LandingPage loginPage = new LandingPage(driver);
		
		loginPage.goTo();
		loginPage.loginApplication(userEmail, userPassword);

//		Product Catalogue Page :-
		
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		
		productcatalogue.addProductToCart("ADIDAS ORIGINAL");
		
		Assert.assertEquals(productcatalogue.cartVerification(), "Product Added To Cart"); 
	
		
//		Verification of Cart and Place Order :-
		
		CartVerification cartverification = new CartVerification(driver);
		
		Assert.assertEquals(cartverification.verifyCart(userPurchase),1);
		
		cartverification.selectCountry("ind", "India");
		
		cartverification.checkoutClick();
		
//		Billing Page :-
		
		BillingPage billingpage = new BillingPage(driver);
		
		Assert.assertEquals(billingpage.getConfirmMessage(), "Thankyou for the order.".toLowerCase());
		
		driver.quit();
	}
}
