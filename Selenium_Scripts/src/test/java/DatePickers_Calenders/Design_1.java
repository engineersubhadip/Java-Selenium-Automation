package DatePickers_Calenders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Design_1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.titleContains("Datepicker | jQuery UI"));
		
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(frameEle);
		
		WebElement dateField = driver.findElement(By.xpath("//input[@id='datepicker']"));
		dateField.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ui-datepicker-div'] //table")));
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div'] //table //td[contains(@class,'ui-datepicker-today')]")).click();
		
		driver.switchTo().defaultContent();
	}

}
