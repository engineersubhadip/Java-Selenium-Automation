package FrameworkDesign;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EndtoEndTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
	}
}
