package pageObjectModel.usingPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage_PageObjectClass {
//	1. Constructor 
//	2. Locator 
//	3. Action Methods
	
	WebDriver driver ;
	
	public LoginPage_PageObjectClass(WebDriver driver) {
		this.driver = driver;
	}
	
//	Locators :-
	
	By userName_Loc = By.xpath("//input[@placeholder='Username']");
	By password_Loc = By.xpath("//input[@placeholder='Password']");
	By submit_Loc = By.xpath("//button[normalize-space()='Login']");
	
//	Actions :-
	
	public void setUserName(String userName) {
		
		driver.findElement(userName_Loc).sendKeys(userName);
	}
	
	public void setPassword(String userPassword) {
		driver.findElement(password_Loc).sendKeys(userPassword);
	}
	
	public void clickSubmit() {
		driver.findElement(submit_Loc).click();
	}
}
