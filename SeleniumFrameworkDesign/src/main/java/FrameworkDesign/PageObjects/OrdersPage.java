package FrameworkDesign.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkDesign.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {

	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr[@class='ng-star-inserted'] //td[2]")
	List<WebElement> productDescription;
	
	By productTableBy = By.xpath("//table[contains(@class,'table table-bordered')]");
	
	public boolean checkProduct(String userPurchase) throws InterruptedException {
		clickOrderIcon();
		waitForElementToAppear(productTableBy);
		
		Thread.sleep(1000);
		boolean status = productDescription.stream()
				.anyMatch(currEle -> currEle.getText().toLowerCase().contains(userPurchase.toLowerCase()));
		return status;
	}
}
