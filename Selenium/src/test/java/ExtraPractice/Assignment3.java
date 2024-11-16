package ExtraPractice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
//		Step:02 :-
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollTo(0,2000)");
		
//		Step:03 :-
		
		List<WebElement> link =  driver.findElements(By.xpath("//div[@id='gf-BIG'] //tbody //td[1]/ul/li //a"));
		
		Actions a = new Actions(driver);
		
		for (int i=1; i<link.size(); i++) {
			Thread.sleep(1000);
			WebElement currLink = link.get(i);
			a.moveToElement(currLink).keyDown(Keys.LEFT_CONTROL).click().build().perform();
		}
		
		
//		Step:04 :-
		
		
		Set<String> listWindowHandles = driver.getWindowHandles();
		
		String currWindowHandle = driver.getWindowHandle();
		
		for (String currEle : listWindowHandles) {
			
			Thread.sleep(500);
			
			if (currEle.equals(currWindowHandle)) {
				continue;
			}
			driver.switchTo().window(currEle);
			System.out.println(driver.getTitle());
			driver.close();
		}
		
		driver.switchTo().window(currWindowHandle);
	}

}
