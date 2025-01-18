package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoubleClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
		
		WebElement target = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
		
		wait.until(ExpectedConditions.titleContains("W3Schools Tryit Editor"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(target).doubleClick().build().perform();
		
		driver.switchTo().defaultContent();
		driver.quit();
	}

}
