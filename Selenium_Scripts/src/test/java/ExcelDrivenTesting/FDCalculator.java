package ExcelDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelUtils.ExcelUtility;

public class FDCalculator {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

//		Closing the Pop-Up :-

		WebElement popup = driver.findElement(By.id("wzrk-cancel"));
		Actions a = new Actions(driver);

		a.moveToElement(popup).click().build().perform();

//		Scrolling into view :-

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,400)");

//		Capturing the WebElements :-

		WebElement principal = driver.findElement(By.id("principal"));
		WebElement interest = driver.findElement(By.id("interest"));
		WebElement tenure = driver.findElement(By.id("tenure"));
		WebElement tenureOption = driver.findElement(By.id("tenurePeriod"));
		WebElement freqOption = driver.findElement(By.id("frequency"));
		WebElement submitBtn = driver.findElement(By.xpath("//div[@class='CTR PT15'] //a[1]"));

		Select selectTenure = new Select(tenureOption);
// 		select.selectByVisibleText("month(s)");
		Select selectFreq = new Select(freqOption);

//		System.out.println(System.getProperty("user.dir"));
		
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\caldata.xlsx";
		String sheet = "Sheet1";
		
		int rowCount = ExcelUtility.getRowCount(filePath, sheet);
		
		for (int r=1; r<=rowCount; r++) {
//			Captured the details from Excel File :-
			String principalAmount = ExcelUtility.getCellData(filePath, sheet, r, 0);
			String interestAmount =  ExcelUtility.getCellData(filePath, sheet, r, 1);
			String periodCount = ExcelUtility.getCellData(filePath, sheet, r, 2);
			String periodType = ExcelUtility.getCellData(filePath, sheet, r, 3);
			String freqType = ExcelUtility.getCellData(filePath, sheet, r, 4);
			String expMaturityValue = ExcelUtility.getCellData(filePath, sheet, r, 5);
			
//			Inputting the same into Application :-
			Thread.sleep(500);
			principal.click();
			principal.clear();
			principal.sendKeys(principalAmount);
			
			Thread.sleep(500);
			interest.click();
			interest.clear();
			interest.sendKeys(interestAmount);
			
			Thread.sleep(500);
			tenure.click();
			tenure.clear();
			tenure.sendKeys(periodCount);
			
			Thread.sleep(500);
			selectTenure.selectByVisibleText(periodType);
			
			Thread.sleep(500);
			selectFreq.selectByVisibleText(freqType);
			
			Thread.sleep(500);
			submitBtn.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='response_div'] //span[@id='resp_matval']")));
			
			String actualValue = driver.findElement(By.xpath("//div[@id='response_div'] //span[@id='resp_matval']")).getText();
		
			Double expMat = Double.parseDouble(expMaturityValue);
			Double actMat = Double.parseDouble(actualValue);
			
			if (expMat.equals(actMat)) {
				ExcelUtility.setCellData(filePath, sheet, r, 7, "Test Pass");
			}else {
				ExcelUtility.setCellData(filePath, sheet, r, 7, "Test Fail");
			}
		}
		
		System.out.println("Test Case Executed...");
		Thread.sleep(2000);
		driver.quit();
	}
}
