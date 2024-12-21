package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtCellNum;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConfirmPassword;
	@FindBy(xpath="//label[normalize-space()='Yes']") WebElement radSubscribeYes;
	@FindBy(xpath="//input[@value='0']") WebElement radSubscribeNo;
	@FindBy(xpath="//input[@name='agree']") WebElement chkPrivacyAgree;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinueButton;
	
	By msgConfirmationLoc = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	
	public void enterFirstName(String firstName) {
		this.txtFirstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		this.txtLastName.sendKeys(lastName);
	}
	
	public void enterEmail(String userEmail) {
		this.txtEmail.sendKeys(userEmail);
	}
	
	public void enterTelephoneNumber(String userNumber) {
		this.txtCellNum.sendKeys(userNumber);
	}
	
	public void enterUserPassword(String userPassword) {
		this.txtPassword.sendKeys(userPassword);
	}
	
	public void enterConfirmPassword(String userPassword) {
		this.txtConfirmPassword.sendKeys(userPassword);
	}
	
	public void subscriptionAgree() {
		this.radSubscribeYes.click();
	}
	
	public void subscriptionNo() {
		this.radSubscribeNo.click();
	}
	
	public void privacyAgree() {
		this.chkPrivacyAgree.click();
	}
	
	public void clickContinue() {
		this.btnContinueButton.click();
	}
	
	public boolean validateConfirmationMessage() {
		waitForElementToAppear(msgConfirmationLoc);
		return msgConfirmation.isDisplayed();
	}

}
