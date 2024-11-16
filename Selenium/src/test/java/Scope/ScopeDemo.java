package Scope;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScopeDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
//		Task 1 :-
		
		int linkCount = driver.findElements(By.xpath("//a")).size();
		
		System.out.println("Total Link Count "+linkCount);
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
//		Task 2 :- (Limiting WebDriver Scope)
		
		int footerLinkCount = driver.findElements(By.xpath("//div[@id='gf-BIG'] //tbody //a")).size();
		
		System.out.println("Footer Link Count "+footerLinkCount);
		
//		Task 3 :- (Limiting WebDriver Scope)
		
		int firstColLinkCount = driver.findElements(By.xpath("//div[@id='gf-BIG'] //tbody //td[1] // a")).size();
		
		System.out.println("Total Links in the First Col of the Footer Section "+ firstColLinkCount);
		
//		Task 4 :- 
		
		int linkCount1 = driver.findElements(By.xpath("//div[@id='gf-BIG'] //tbody //td[1] // a")).size();
		
//		for (int i=0; i<linkCount1; i++) {
//			List<WebElement> firstColLink = driver.findElements(By.xpath("//div[@id='gf-BIG'] //tbody //td[1] // a"));
//			WebElement currLink = firstColLink.get(i);
//			
//			wait.until(ExpectedConditions.elementToBeClickable(currLink));
//			currLink.click();
//			driver.navigate().back();
//		}
		
//		Task 5 :-
		
		Actions a = new Actions(driver);
		
		List<WebElement> firstColLinks = driver.findElements(By.xpath("//div[@id='gf-BIG'] //tbody //td[1] // a"));
		
		for (int i=0; i<linkCount1; i++) {
			WebElement currLink = firstColLinks.get(i);
			a.moveToElement(currLink).keyDown(Keys.LEFT_CONTROL).click().build().perform();
		}
		
		
//		Task 6 :-
		
		Set<String> windowHandles =  driver.getWindowHandles();
		
		String presentWindowHandle = driver.getWindowHandle();
		
		for (String currWindowHandle : windowHandles) {
			if (currWindowHandle.equals(presentWindowHandle)) {
				continue;
			}else {
				driver.switchTo().window(currWindowHandle);
				String currWebPageTitle = driver.getTitle();
				System.out.println(currWebPageTitle);
			}
		}
		
		driver.switchTo().window(presentWindowHandle);
	}

}
