package Day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait declaration

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		WebElement inputBox = myWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));

		inputBox.sendKeys("admin");
	}

}
