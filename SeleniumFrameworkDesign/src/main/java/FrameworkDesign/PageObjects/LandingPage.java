package FrameworkDesign.PageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkDesign.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver ;
	
	public LandingPage (WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElements :-
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement userPassword;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement submitBtn;

	
	@FindBy(xpath="//div[@id='toast-container'] //div[@aria-label='Incorrect email or password.']")
	WebElement incorrectLogin;
	
	By incorrectLoginBy =  By.xpath("//div[@id='toast-container'] //div[@aria-label='Incorrect email or password.']");
	
//	Actions :-
	
	public ArrayList<Object> loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submitBtn.click();
		
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		OrdersPage orderspage = new OrdersPage(driver);
		
		ArrayList<Object> objects = new ArrayList<>();
		objects.add(productcatalogue);
		objects.add(orderspage);
		
		return objects;
	}
	
	public void goTo() {
		this.driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() {
		
		waitForElementToAppear(incorrectLoginBy);
		
		String incorrectMessage = incorrectLogin.getText();
		
		return incorrectMessage;
	}
}
