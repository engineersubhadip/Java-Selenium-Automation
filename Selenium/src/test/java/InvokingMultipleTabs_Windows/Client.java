package InvokingMultipleTabs_Windows;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Client {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		String currWindowHandle = driver.getWindowHandle();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
//		Open new TAB
		
		driver.switchTo().newWindow(WindowType.TAB);
				
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		 
		Set<String> windowHandle = driver.getWindowHandles();
		
		String tarWindowHandle = windowHandle.stream().filter(currEle -> !currEle.equals(currWindowHandle)).map(currEle -> currEle).collect(Collectors.toList()).get(0);
		
		driver.switchTo().window(tarWindowHandle);
		
		driver.get("https://courses.rahulshettyacademy.com/courses");
		
//		Scroll into view :-
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,800)");
		
//		Capture all the first course title :-
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row course-list list'] //div[@class='course-listing-title']")));
		String title =  driver.findElements(By.xpath("//div[@class='row course-list list'] //div[@class='course-listing-title']")).get(0).getText();
		
		driver.close();
		
		driver.switchTo().window(currWindowHandle);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
		
		WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
		
		nameField.click();
		
		nameField.sendKeys(title);
		
//		Take screenshot to validate
		
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("K://AutomationScreenShots//file2.png"));
		
//		Capture height and width of the name input box :-
		
		int height = nameField.getRect().getDimension().getHeight();
		
		int width = nameField.getRect().getDimension().getWidth();
		
		System.out.println("Height "+height+" Width "+width);
		
		driver.close();
	}

}
