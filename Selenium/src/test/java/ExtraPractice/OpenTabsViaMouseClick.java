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

public class OpenTabsViaMouseClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String parentID = driver.getWindowHandle();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,2600)");

		Actions a = new Actions(driver);

		List<WebElement> links = driver.findElements(By.xpath("//table[@class='gf-t'] //td[1] //li //a"));

		for (int i = 1; i < links.size(); i++) {
			Thread.sleep(2000);
			WebElement currLink = links.get(i);
			a.moveToElement(currLink).keyDown(Keys.LEFT_CONTROL).click().build().perform();
		}

		Set<String> ids = driver.getWindowHandles();

		for (String currID : ids) {
			Thread.sleep(500);
			if (!currID.contains(parentID)) {
				driver.switchTo().window(currID);
				String currTitle = driver.getTitle();
				System.out.println(currTitle);
			}
		}

		ids.stream().filter(currID -> !currID.contains(parentID))
				.forEach(currID -> driver.switchTo().window(currID).close());

		driver.switchTo().window(parentID);

		System.out.println("Parent Title " + driver.getTitle());

		driver.close();
	}

}
