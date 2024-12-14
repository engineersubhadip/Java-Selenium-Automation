package TableDynamicPaginationTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicPagination {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://datatables.net/examples/basic_init/alt_pagination.html");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.titleContains("DataTables example - Alternative pagination"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
//		Capturing the total number of Entries :-
		
		js.executeScript("window.scrollTo(0,680)");
		
		String tar = driver.findElement(By.xpath("//div[@id='example_info']")).getText().split("of")[1];
		
		String ans = tar.split(" ")[1];
		
		int finalCount = Integer.parseInt(ans.trim()); // got the total number of entries on the page
		
//		Reading Name and Position at Each Page :-
		
		for (int i=1; i<=6; i++) {						
			int rowCount =  driver.findElements(By.xpath("//table[@id='example'] //tbody /tr")).size();
			
			List<WebElement> names = driver.findElements(By.xpath("//table[@id='example'] //tbody /tr //td[@class='sorting_1']"));
			
			List<WebElement> position = driver.findElements(By.xpath("//table[@id='example'] //tbody /tr //td[2]"));
			
			for (int j=1; j<rowCount; j++) {
				System.out.println(names.get(j).getText() +"\t"+position.get(j).getText());
			}

			System.out.println("----------------------------------------");
			
			WebElement nextBtn =  driver.findElement(By.xpath("//nav[@aria-label='pagination'] //button[@aria-label='Next']"));
			
			if (nextBtn.getAttribute("class").contains("disabled") == false) {
				Thread.sleep(500);
				nextBtn.click();
			}
		}
	}

}
