package ExtraPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Client7 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://text-compare.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='inputText1']")));
//		//textarea[@id='inputText1']
		
		Actions a = new Actions(driver);
		
		WebElement textArea = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		
		a.moveToElement(textArea).click().keyDown(Keys.LEFT_SHIFT).sendKeys("welcome").keyDown(Keys.LEFT_CONTROL).sendKeys("a").build().perform();
	}

}
