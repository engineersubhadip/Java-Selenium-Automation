package TableStatic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * A Static WebTable is the one, in which the contents, number of rows and number of cols remain static
 */

public class StaticWebTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

		driver.get("https://testautomationpractice.blogspot.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.titleContains("Automation Testing Practice"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,1750)");

//		1. Find total number of rows in a table

		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable'] //tr"));

		System.out.println("Row Count -> " + rows.size());

//		2. Find total number of cols in a table

		List<WebElement> cols = driver.findElements(By.xpath("//table[@name='BookTable'] //tr[1] //th"));

		System.out.println("Col Count -> " + cols.size());

//		3. Read data from specific row and col

		String tarEleText = rows.get(4).findElement(By.xpath("//td[1]")).getText();

		System.out.println("Target Element Text -> " + tarEleText);
		System.out.println();
		
//		4. Read all the data from the Table 

		for (int r = 0; r < rows.size(); r++) {
			WebElement currRow = rows.get(r);
			for (int c = 1; c <= cols.size(); c++) {
				if (r == 0) {
					System.out.print(currRow.findElement(By.xpath("./th[" + c + "]")).getText() + " ");
				}else {
				System.out.print(currRow.findElement(By.xpath("./td[" + c + "]")).getText() + " "); // . ensures we are
				}																			// specifically
																									// looking for td
																									// inside currRow's
																									// scope
			}
			System.out.println();
		}
		
		System.out.println("-------------------");
		
		
//		5. Print book names whose author is "Mukesh"
		
		for (int r=1; r<rows.size(); r++) {
			WebElement currRow = rows.get(r);
			String authorName = currRow.findElement(By.xpath("./td[2]")).getText();
			if (authorName.equals("Mukesh")) {
				String bookName = currRow.findElement(By.xpath("./td[1]")).getText();
				System.out.println(bookName);
			}
		}
		
//		6. Sum the total prices of the Books 
		
		int total = 0;
		
		for (int r=1; r < rows.size(); r++) {
			WebElement currRow = rows.get(r);
			String runPrice = currRow.findElement(By.xpath("./td[4]")).getText();
			total += Integer.parseInt(runPrice);
		}
		
		System.out.println("Total Price -> "+total);
	}

}
