package Practice.UsingPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @FindBy -> This annotation locates a particular WebElement in my page using the locator which we pass as an input parameter
 * This always returns a WebElement.
 * PageFactory.initElements(driver, this) -> This piece of code will make sure that the driver which we pass in the constructor
 * is applicable to all the @FindBy annotations internally.
 */


public class LoginPage {
//	1. Constructor
//	2. WebElements/Locators
//	3. Action methods
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	2. 
	
	@FindBy(xpath="//input[@placeholder='Username']") private WebElement userName;
	@FindBy(xpath="//input[@placeholder='Password']") private WebElement password;
	@FindBy(xpath="//button[normalize-space()='Login']") private WebElement submitBtn;
	
//	3.
	
	public void enterUsername(String userName) {
		this.userName.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickSubmitBtn() {
		this.submitBtn.click();
	}
}
