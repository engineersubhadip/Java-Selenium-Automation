package Practice.WithoutPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
//	1. Constructor :- Used for instantiating the webdriver
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	2. Locators :-

	private By userNameLoc = By.xpath("//input[@placeholder='Username']");
	private By passwordLoc = By.xpath("//input[@placeholder='Password']");
	private By submitBtnLoc = By.xpath("//button[normalize-space()='Login']");
	
//	Action Methods :-
	
	public void enterUserName(String userName) {
		driver.findElement(userNameLoc).sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordLoc).sendKeys(password);
	}
	
	public void clickSubmitBtn() {
		driver.findElement(submitBtnLoc).click();
	}
}
