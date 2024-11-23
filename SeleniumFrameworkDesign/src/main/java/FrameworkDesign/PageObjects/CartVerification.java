package FrameworkDesign.PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkDesign.AbstractComponents.AbstractComponent;

public class CartVerification extends AbstractComponent{
	
	WebDriver driver;
	
	public CartVerification (WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(@routerlink,'cart')]")
	WebElement cartIcon;
	
	@FindBy(xpath="//div[@class='cart'] //li //h3")
	List<WebElement> cartProduct;
	
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement checkOutBtn;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement autoSuggestionBox;
	
	By countryDropDown = By.xpath("//section[contains(@class,'ng-star-inserted')] //button");
	
	@FindBy(xpath="//section[contains(@class,'ng-star-inserted')] //button")
	List<WebElement> countryList;
	
	@FindBy(xpath="//div[@class='actions']/a")
	WebElement placeOrderBtn;
	
	public int verifyCart (String userPurchase) {
		clickCartIcon();
		int count = cartProduct.stream().filter(currEle -> currEle.getText().toLowerCase().contains(userPurchase)).collect(Collectors.toList()).size();
		return count;
	}
	
	public void selectCountry(String userInput, String destinationCountry) throws InterruptedException {
		checkOutBtn.click();
		autoSuggestionBox.click();
		autoSuggestionBox.sendKeys(userInput);
		
		waitForElementToAppear(countryDropDown);
		
		try {
			countryList.stream().filter(currEle -> currEle.getText().equalsIgnoreCase(destinationCountry)).forEach(currEle -> currEle.click());
		}catch(StaleElementReferenceException e) {
			List<WebElement> countryList = driver.findElements(By.xpath("//section[contains(@class,'ng-star-inserted')] //button"));
			countryList.stream().filter(currEle -> currEle.getText().equalsIgnoreCase(destinationCountry)).forEach(currEle -> currEle.click());
		}
	}
	
	
	public void checkoutClick() {
		placeOrderBtn.click();
	}
	
}
