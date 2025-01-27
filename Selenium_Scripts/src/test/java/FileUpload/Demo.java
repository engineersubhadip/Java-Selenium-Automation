package FileUpload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Demo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
//		Single File Upload :-
		WebElement chooseFile = driver.findElement(By.id("filesToUpload"));
		chooseFile.sendKeys("C:\\Interview Prep\\Courseware.txt");
//		Validation :-
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fileList")));
		String fileName = driver.findElement(By.id("fileList")).getText();
		
		if (fileName.contains("Courseware.txt")) {
			System.out.println("File Upload Successful.");
			Assert.assertTrue(true);
		} else {
			System.out.println("File Upload Failed.");
			Assert.fail();
		}
		
	}

}
