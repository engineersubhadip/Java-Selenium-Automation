package Practice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDynamicTable {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.titleContains("Automation Testing Practice"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,2700)");

		int pageCount = driver.findElements(By.xpath("//ul[@id='pagination'] //li")).size();

		int currPage = 1;

		List<String> productName = new ArrayList<>();
		List<String> price = new ArrayList<>();

		while (currPage <= pageCount) {

			int rowCount = driver.findElements(By.xpath("//table[@id='productTable'] //tbody //tr")).size();

			for (int r = 1; r <= rowCount; r++) {
				WebElement currRow = driver
						.findElement(By.xpath("(//table[@id='productTable'] //tbody //tr)[" + r + "]"));
				String currProductName = currRow.findElement(By.xpath("./td[2]")).getText();
				String currPrice = currRow.findElement(By.xpath("./td[3]")).getText();
				productName.add(currProductName);
				price.add(currPrice);
				currRow.findElement(By.xpath("./td[4]/input")).click();
			}

			currPage++;
			Thread.sleep(500);
			if (currPage <= pageCount) {
				WebElement nextBtn = driver.findElement(By.xpath("//ul[@id='pagination'] //li[" + currPage + "]"));
				nextBtn.click();
			}
		}

		System.out.println("Ending script.");

		driver.quit();

		FileOutputStream file = new FileOutputStream(
				new File(System.getProperty("user.dir") + "\\src\\test\\java\\testdata\\Dynamic Web Table Data.xlsx"));
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Custom Dynamic Data");
		
		int rows = productName.size();
		
		XSSFRow headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("Product Name");
		headerRow.createCell(1).setCellValue("Price");
		
		for (int r=1; r<=rows; r++) {
			XSSFRow currRow = sheet.createRow(r);
			currRow.createCell(0).setCellValue(productName.get(r-1));
			currRow.createCell(1).setCellValue(price.get(r-1));
		}
		
		System.out.println("File Updated successfully.");
		
		workbook.write(file);
		
		workbook.close();
		
		file.close();
	}

}
