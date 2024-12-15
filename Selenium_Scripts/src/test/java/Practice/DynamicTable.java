package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.titleContains("Automation Testing Practice"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,2750)");
		
		int pageCount = driver.findElements(By.xpath("//ul[@id='pagination'] //li")).size();
//		List<WebElement> pages =  driver.findElements(By.xpath("//ul[@id='pagination'] //li"));
		
		int currPage = 1;
		
		while (currPage <= pageCount) {
			Thread.sleep(1000);
			int rowCount =  driver.findElements(By.xpath("//table[@id='productTable']/tbody //tr")).size();
			for (int r=1;r<=rowCount; r++) {
				WebElement currRow = driver.findElement(By.xpath("(//table[@id='productTable']/tbody //tr)["+r+"]"));
				WebElement checkBox = currRow.findElement(By.xpath("./td/input"));
				Thread.sleep(500);
				checkBox.click();
			}
			currPage += 1; // 2 -> 3 -> 4
			if (currPage <= pageCount) {
				WebElement nextPage = driver.findElement(By.xpath("//ul[@id='pagination']/li["+currPage+"]"));
				nextPage.click(); // 2 -> 3
			}
		}

	}

}
