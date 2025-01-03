package ThreadSafety;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class DriverTestRemedy {
	
	private static ThreadLocal<WebDriver> tLocal = new ThreadLocal<>();
	
	WebDriver driver;
	
	public void setDriver (WebDriver driver) {
		tLocal.set(driver);
	}
	
	public WebDriver getDriver () {
		return tLocal.get();
	}
	
	@Test
	public void test1 () {
		setDriver(new ChromeDriver());
		getDriver().get("https://www.google.com");
		System.out.println(getDriver().getTitle());
		getDriver().quit();
	}
	
	@Test
	public void test2 () {
		setDriver(new EdgeDriver());
		getDriver().get("https://www.bing.com/");
		System.out.println(getDriver().getTitle());
		getDriver().quit();
	}
	
	@AfterClass
	public void tearDown() {
		tLocal.remove();
	}
}
