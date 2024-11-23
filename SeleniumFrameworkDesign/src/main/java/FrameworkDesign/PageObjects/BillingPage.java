package FrameworkDesign.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkDesign.AbstractComponents.AbstractComponent;

public class BillingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public BillingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By confirmMessageBy = By.tagName("h1");
	
	@FindBy(tagName="h1")
	WebElement confirmMessage;
	
	public String getConfirmMessage() {
		waitForElementToAppear(confirmMessageBy);
		
		return confirmMessage.getText().toLowerCase();
	}

}
