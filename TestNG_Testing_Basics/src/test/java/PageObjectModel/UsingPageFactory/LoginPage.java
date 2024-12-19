package PageObjectModel.UsingPageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @FindBy locates a particular webelement in our webpage using the locator we passed as a parameter
 * It always returns a webElement
 * PageFactory.initElements(driver, this) -> This piece of code will make sure, this particular driver
 * which we are sending (driver,this) is applicable to all the @FindBy annotations internally.
 * Note this is the same driver which we are passing in the constructor 
 */
public class LoginPage {
	
//	1. Part one Constructor :- Used to initialize the WebDriver
	WebDriver driver;
	
	LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	2. Part Two :- WebElement
	
	@FindBy(xpath="//input[@name='username']") WebElement userName;
	@FindBy(xpath="//input[@name='password']") WebElement passWord;
	@FindBy(xpath="//button[contains(@class,'orangehrm-login-button')]") WebElement submitBtn;
	
	/* -> To capture List of WebElements
	@FindBy(tagName="a")
	List<WebElement> allLinks;
	*/
	
//	3. Part Three :- Action Methods
	
	public void setUserName(String userName) {
		this.userName.sendKeys(userName);
	}
	
	public void setPassword(String userPassword) {
		passWord.sendKeys(userPassword);
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}
}
