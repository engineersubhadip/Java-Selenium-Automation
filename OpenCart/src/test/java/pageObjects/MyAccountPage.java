package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement MyAccount;
	
	By MyAccountOptionsLoc = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']");
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement logoutLink;
	
	By myAccountHeaderMsgLoc = By.xpath("//h2[normalize-space()='My Account']");
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement headerMessage;
	
	
	public String getHeaderMessage() {
		try {
			waitForElementToAppear(myAccountHeaderMsgLoc);
			return headerMessage.getText();
		} catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public void clickMyAccount() {
		MyAccount.click();
	}
	
	public void clickLogout() {
		waitForElementToAppear(MyAccountOptionsLoc);
		logoutLink.click();
	}
}
