package ShadowDOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiLevelAbstraction {

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
		
		SearchContext root3 =  root2.findElement(By.cssSelector(("#nested-shadow-dom"))).getShadowRoot();
		
		String finalMessage =  root3.findElement(By.cssSelector("#multi-nested-shadow-element")).getText();
		
		System.out.println("Multi-Level Nested Shadow Element Message -> "+finalMessage);

	}

}
