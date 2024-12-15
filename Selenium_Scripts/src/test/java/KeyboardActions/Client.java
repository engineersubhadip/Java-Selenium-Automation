package KeyboardActions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * There are 2 text areas. Actions to be performed are :-
 * 1. On the leftTextArea, write "Welcome to Selenium". Do Ctrl+A then Ctrl+C and do TAB
 * 2. You will now be on the rightTextArea, do Ctrl+V 
 * 
 * **Note**
 * KeyDown() -> Used to press a Key (ctrl, shift, alt)
 * keyUp() -> Used to release a Key (ctrl,shift,alt)
 * 
 * For single key :- Use keyDown() and KeyUp()
 * For Combo key :- Use keyDown() sendKeys() and Keyup()
 */

public class Client {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("K:\\CRX Files\\uBlock.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://text-compare.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.titleContains("Text Compare! - Find differences between two text files"));
		
		WebElement textArea1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		
		textArea1.sendKeys("Welcome to Selenium");
		
		Actions a = new Actions(driver);
		
//		Ctrl + A Action :-
		
		a.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
		
//		Ctrl + C Action :-
		
		a.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build().perform();
		
//		TAB Action ;-
		
		a.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
		
//		Ctrl+V Action :-
		
		a.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform();

	}

}
