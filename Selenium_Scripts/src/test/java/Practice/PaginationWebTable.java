package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationWebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(1440, 900));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,2550)");
		
		List<WebElement> page = driver.findElements(By.xpath("//ul[@id='pagination'] /li"));
		int currPage = 1;
		Thread.sleep(1000);
		
		while (currPage <= page.size()) {
			List<WebElement> row = driver.findElements(By.xpath("//table[@id='productTable']/tbody //tr"));
			
			for (int i=0; i<row.size(); i++) {
				WebElement currRow = row.get(i);
				Integer idEle = Integer.parseInt(currRow.findElement(By.xpath("./td[1]")).getText());
				WebElement checkBox = currRow.findElement(By.xpath("./td[1]/following-sibling::td/input"));
				if (idEle % 2 == 0) {
					checkBox.click();
				}
			}
			
			Thread.sleep(1000);
			if (currPage == page.size()) {
				break;
			}
			page.get(currPage).findElement(By.xpath("./a")).click();
			currPage += 1;
		}
		
		Thread.sleep(2000);
		System.out.println("Performed successfully !");
		driver.quit();
	}

}
