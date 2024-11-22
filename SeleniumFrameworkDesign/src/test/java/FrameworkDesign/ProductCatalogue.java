package FrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkDesign.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	Product List :-

	@FindBy(xpath = "//section[@id='products']/div[@class='container']/div[2] //div[@class='card']")
	List<WebElement> productList;

	By productListBy = By.xpath("//section[@id='products']/div[@class='container']/div[2] //div[@class='card']");
	
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	
	By animeLoader =  By.cssSelector(".ng-animating");
	
	By cartConfirmMessage = By.xpath("//div[@id='toast-container'] //div[@aria-label='Product Added To Cart']");
	
	
	@FindBy(xpath="//div[@id='toast-container'] //div[@aria-label='Product Added To Cart']")
	WebElement cartMessage;

//	Actions :-

	public List<WebElement> getProductList() {

		waitForElementToAppear(productListBy);

		return productList;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
	}
	
	
	public String cartVerification() {
		waitForElementToDisappear(animeLoader);
		waitForElementToAppear(cartConfirmMessage);
		
		return cartMessage.getText();
	}
}
