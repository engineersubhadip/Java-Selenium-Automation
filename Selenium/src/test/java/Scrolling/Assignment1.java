package Scrolling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,675)");
		
		List<WebElement> contentArr =  driver.findElements(By.xpath("//table[@id='product' and @name='courses']/tbody/tr"));
		
		int colCount = driver.findElements(By.xpath("//table[@id='product' and @name='courses']/tbody/tr //th")).size();
		int rowCount = contentArr.size();
		
		WebElement secondRow = driver.findElement(By.xpath("//table[@id='product' and @name='courses']/tbody/tr[3]"));
		
		String secondRowContent = secondRow.getText();
		
		System.out.println("Number of Rows "+rowCount);
		System.out.println("Number of Columns "+colCount);
		System.out.println("Second Row Content "+secondRowContent);
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
