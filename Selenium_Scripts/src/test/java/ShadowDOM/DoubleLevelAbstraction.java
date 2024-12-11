package ShadowDOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoubleLevelAbstraction {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dev.automationtesting.in/shadow-dom");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.titleContains("Automation Testing Demo"));

		SearchContext root1 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();

		SearchContext root2 = root1.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();

		String nestedShadowMessage = root2
				.findElement(By.cssSelector("#nested-shadow-root #nested-shadow-element")).getText();

		System.out.println("Nested Shadow Message -> " + nestedShadowMessage);

	}

}
