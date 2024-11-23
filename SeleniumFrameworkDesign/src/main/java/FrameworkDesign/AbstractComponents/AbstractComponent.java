package FrameworkDesign.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FrameworkDesign.PageObjects.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(@routerlink,'cart')]")
	WebElement cartIcon;
	
	By cartIconBy = By.xpath("//button[contains(@routerlink,'cart')]");
	
	By spinnerLoaderBy = By.cssSelector("[class*='ngx-spinner-overlay']");
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderIcon;
	
	public void clickCartIcon() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)this.driver;
		js.executeScript("arguments[0].click();",cartIcon);
	}
	
	public OrdersPage clickOrderIcon() {
		JavascriptExecutor js = (JavascriptExecutor)this.driver;
		js.executeScript("arguments[0].click();", orderIcon);
		OrdersPage orderPage = new OrdersPage(driver);
		return orderPage;
	}
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(findBy));
	}
	
	
	public void waitForElementToDisappear(By findBy) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findBy)));
	}
	
}
