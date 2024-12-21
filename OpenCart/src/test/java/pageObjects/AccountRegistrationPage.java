package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement firstName;	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement cellNum;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement confirmPassword;
	@FindBy(xpath="//label[normalize-space()='Yes']") WebElement subscribeYes;
	@FindBy(xpath="//input[@value='0']") WebElement subscribeNo;
	@FindBy(xpath="//input[@name='agree']") WebElement privacyAgree;
	@FindBy(xpath="//input[@value='Continue']") WebElement continueButton;
	
	public void enterFirstName(String userName) {
		this.firstName.sendKeys(userName);
	}
	
	public void enterLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	
	public void enterEmail(String userEmail) {
		this.email.sendKeys(userEmail);
	}
	
	public void enterTelephoneNumber(String userNumber) {
		this.cellNum.sendKeys(userNumber);
	}
	
	public void enterUserPassword(String userPassword) {
		this.password.sendKeys(userPassword);
	}
	
	public void enterConfirmPassword(String userPassword) {
		this.confirmPassword.sendKeys(userPassword);
	}
	
	public void subscriptionAgree() {
		this.subscribeYes.click();
	}
	
	public void subscriptionNo() {
		this.subscribeNo.click();
	}
	
	public void privacyAgree() {
		this.privacyAgree.click();
	}
	
	public void clickContinue() {
		this.continueButton.click();
	}
}
