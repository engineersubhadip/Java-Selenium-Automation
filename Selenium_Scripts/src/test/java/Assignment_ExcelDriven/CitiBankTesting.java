package Assignment_ExcelDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelUtils.AssignmentUtility;

public class CitiBankTesting {

	public static void main(String[] args) throws IOException, InterruptedException {
		
//		A. Loading the Driver configurations from the Properties File :-
		
//		1. Create a Properties object :-
		Properties properties = new Properties();
		
//		2. Open the Properties file in reading mode :-
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\assignmentConfig.properties");
		
//		3. Load the Properties file :-
		properties.load(file);
//		
//		4. Extract out the relevant details :-
		String url = (String) properties.get("appURL");

//		B. Initialize our driver : -
		
		WebDriver driver;
		
		if (properties.getProperty("browser").equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if (properties.getProperty("browser").equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else if (properties.getProperty("browser").equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else {
			return;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions a = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(url); // App is launched
		
		wait.until(ExpectedConditions.titleContains("CD Calculator | Certificate of Deposit Calculator | CIT Bank"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
//		C. Locators/WebElements of the targeted fields :-

		WebElement initialDeposit =  driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		WebElement lengthMonth =  driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		WebElement interestRate =  driver.findElement(By.xpath("//input[@id='mat-input-2']"));
		WebElement dropDown =  driver.findElement(By.xpath("//div[contains(@class,'mat-select-arrow-wrapper')] //div"));
		
//		D. Get the Excel File Details (File Path, row count) :-
		
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\assignmentTestData.xlsx";
		String sheetName = "Sheet1";
		int rowCount = AssignmentUtility.getRowCount(filePath, sheetName);
		
		for (int r=1; r<=rowCount; r++) {
			
			js.executeScript("window.scrollTo(0,450)");
			
//			Capture all the data from Excel File
			
			String initialDepositAmount = AssignmentUtility.readCellData(filePath, sheetName, r, 0);
			initialDepositAmount = initialDepositAmount.split("[.]")[0];
			String interestRateAmount =  AssignmentUtility.readCellData(filePath, sheetName, r, 1);
			String lengthCount = AssignmentUtility.readCellData(filePath, sheetName, r, 2);
			lengthCount = lengthCount.split("[.]")[0];
			String compundingType =  AssignmentUtility.readCellData(filePath, sheetName, r, 3);
			String expectedAmount =  AssignmentUtility.readCellData(filePath, sheetName, r, 4);
			
//			Insert all the captured data to the Application
			
			initialDeposit.clear();
			initialDeposit.sendKeys(initialDepositAmount);
			
			lengthMonth.clear();
			lengthMonth.sendKeys(lengthCount);
			
			
			interestRate.clear();
			interestRate.sendKeys(interestRateAmount);
			
			js.executeScript("arguments[0].click();",dropDown);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option[contains(@class,'mat-option mat-focus-indicator')] //span")));
			List<WebElement> dropDownValue =  driver.findElements(By.xpath("//mat-option[contains(@class,'mat-option mat-focus-indicator')] //span"));
			
			WebElement tarWebElement =  dropDownValue.stream().filter(currEle -> currEle.getText().contains(compundingType))
			.collect(Collectors.toList()).get(0);

			a.moveToElement(tarWebElement).click().build().perform();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='CIT-chart-submit']")));
			WebElement submitBtn = driver.findElement(By.xpath("//button[@id='CIT-chart-submit']"));
			
			js.executeScript("window.scrollTo(0,800)");
			submitBtn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='validResults'] //span[4]")));

			String actualResult = driver.findElement(By.xpath("//div[@id='validResults'] //span[4]")).getText();

//			Perform Validations

			expectedAmount = String.join("",expectedAmount.split("[$,.]"));
			actualResult = String.join("",actualResult.split("[$,.]"));
			
			if (expectedAmount.equals(actualResult)) {
				AssignmentUtility.setCellData(filePath, sheetName, r, 6, "Test Pass");
			}else {
				AssignmentUtility.setCellData(filePath, sheetName, r, 6, "Test Fail");
			}
		}
		
		System.out.println("Exiting out of the Test Case ....");
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}

