package HandleAutoSuggestDropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement inputBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));

		inputBox.sendKeys("Selenium");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='Alh6id' ] //ul[@class='G43f7e' and @jsname='bw4e9b']")));
		;

		WebElement parentSearch = driver
				.findElement(By.xpath("//div[@id='Alh6id' ] //ul[@class='G43f7e' and @jsname='bw4e9b']"));

		List<WebElement> suggestions = parentSearch
				.findElements(By.xpath(" //div[@class='pcTkSc'] //div[@class='lnnVSe']"));

		WebElement target = suggestions.stream()
				.filter(currEle -> currEle.getText().contains("selenium sulfide shampoo")).findFirst().orElse(null);
		
		if (target != null) {
			Actions a = new Actions(driver);
			
			a.moveToElement(target).click().build().perform();			
		}
	}

}
