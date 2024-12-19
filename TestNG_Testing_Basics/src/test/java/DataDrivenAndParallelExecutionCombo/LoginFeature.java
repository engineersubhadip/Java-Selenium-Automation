package DataDrivenAndParallelExecutionCombo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginFeature {

	WebDriver driver;
	WebDriverWait wait;
	Properties properties;

	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browserName) throws IOException { // responsible for setting up the browser config.

		properties = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\java\\DataDrivenAndParallelExecutionCombo\\browserConfig.properties");
		properties.load(file);

		String browserURL = properties.getProperty("browserURL");
		
		if (browserName.toLowerCase().contains("chrome")) {
			driver = new ChromeDriver();			
		}else if (browserName.toLowerCase().contains("edge")) {
			driver = new EdgeDriver();
		}else {
			return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get(browserURL);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test(dataProvider= "dp")
	public void testCredential(String userName, String password) { // actual test

		wait.until(ExpectedConditions.titleContains("OrangeHRM"));
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

		driver.findElement(By.xpath("//button[contains(@class,'orangehrm-login-button')]")).click();

		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//i[contains(@class,'oxd-userdropdown-icon')]")));
			Thread.sleep(1500);
			driver.findElement(By.xpath("//i[contains(@class,'oxd-userdropdown-icon')]")).click();

			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='oxd-dropdown-menu'] //li")));

			driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu'] //li/a[contains(@href,'logout')]")).click();

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@AfterClass
	public void tearDown() { // closing browser
		driver.quit();
	}

	@DataProvider(name = "dp")
	Object[][] setUpTestData() throws IOException {
		
		String excelFilePath = System.getProperty("user.dir")
				+ "\\src\\test\\java\\DataDrivenAndParallelExecutionCombo\\userNamePassword.xlsx";
		String sheetName = "Sheet1";
		
		int rowCount = ExcelUtils.getRowCount(excelFilePath, sheetName);
		int cellCount = ExcelUtils.getCellCount(excelFilePath, sheetName, 0);
		
		Object[][] data = new Object[rowCount+1][cellCount];
		
		for (int r=0; r<=rowCount; r++) {
			String userName = ExcelUtils.readCellData(excelFilePath, sheetName, r, 0);
			String password = ExcelUtils.readCellData(excelFilePath, sheetName, r, 1);
			
			data[r][0] = userName;
			data[r][1] = password;
		}
		
		return data;
	}
}
