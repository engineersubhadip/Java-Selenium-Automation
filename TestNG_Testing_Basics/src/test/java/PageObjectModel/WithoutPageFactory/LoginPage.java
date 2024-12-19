package PageObjectModel.WithoutPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
//	1. Part one Constructor :- Used to initialize the WebDriver
	WebDriver driver;
	
	LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	2. Part Two :- Locators
	
	By userNameLoc = By.xpath("//input[@name='username']");
	By passwordLoc = By.xpath("//input[@name='password']");
	By submitBtnLoc = By.xpath("//button[contains(@class,'orangehrm-login-button')]");
	
//	3. Part Three :- Action Methods
	
	public void setUserName(String userName) {
		driver.findElement(userNameLoc).sendKeys(userName);
	}
	
	public void setPassword(String userPassword) {
		driver.findElement(passwordLoc).sendKeys(userPassword);
	}
	
	public void clickSubmitBtn() {
		driver.findElement(submitBtnLoc).click();
	}
}
