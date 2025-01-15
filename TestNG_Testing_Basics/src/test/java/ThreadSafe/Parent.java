package ThreadSafe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Parent {
	
	public WebDriver driver;
	public WebDriverWait wait;
	protected static ThreadLocal<WebDriver> tLocal = new ThreadLocal<>();
	
	public void setDriver (WebDriver driver) {
		tLocal.set(driver);
	}
	
	public WebDriver getDriver () {
		return tLocal.get();
	}
}
