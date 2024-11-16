package Actions;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		List<WebElement> listArr =  driver.findElements(By.xpath("//li/a"));
		
		for (WebElement currEle : listArr) {
			if (currEle.getText().contains("Multiple Windows")) {
				currEle.click();
				break;
			}
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='example']/a")));
		
		driver.findElement(By.xpath("//div[@class='example']/a")).click();
		
		Set<String> windowHandles =  driver.getWindowHandles();
		
		String currentWindowHandle = driver.getWindowHandle();
		
		for (String currWindow : windowHandles) {
			if (currWindow.equals(currentWindowHandle)) {
				continue;
			}else {
				driver.switchTo().window(currWindow);
				break;
			}
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
		
		String childWindowText = driver.findElement(By.xpath("//h3")).getText();
		
		System.out.println(childWindowText);
		
		driver.switchTo().window(currentWindowHandle);
		
		String parentWindowText = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		
		System.out.println(parentWindowText);
	}

}
