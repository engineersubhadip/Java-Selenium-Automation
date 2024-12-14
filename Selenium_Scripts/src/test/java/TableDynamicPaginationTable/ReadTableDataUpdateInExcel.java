package TableDynamicPaginationTable;

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

/*
 * Read Data from a Dynamic Pagination WebTable
 * Capture the Name, Position and Location
 * Update the Records in the Excel File
 */

public class ReadTableDataUpdateInExcel {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://datatables.net/examples/basic_init/alt_pagination.html");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.titleContains("DataTables example - Alternative pagination"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,680)");

		int pageCount = driver.findElements(By.xpath("//nav[@aria-label='pagination'] //button")).size() - 2;

		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> designation = new ArrayList<>();
		ArrayList<String> location = new ArrayList<>();

		for (int p = 1; p <= pageCount; p++) {

			List<WebElement> totalRecords = driver.findElements(By.xpath("//table[@id='example']/tbody //tr"));
			
			for (int k=0; k<totalRecords.size(); k++) {
				WebElement currRow = totalRecords.get(k);
				String currName = currRow.findElement(By.xpath("./td[@class='sorting_1']")).getText();
				String currPosition =  currRow.findElement(By.xpath("./td[2]")).getText();
				String currLocation =  currRow.findElement(By.xpath("./td[3]")).getText();

				names.add(currName);
				designation.add(currPosition);
				location.add(currLocation);
			}
			
			
			WebElement nextBtn = driver
					.findElement(By.xpath("//nav[@aria-label='pagination'] //button[@aria-label='Next']"));

			if (nextBtn.getAttribute("class").contains("disabled") == false) {
				Thread.sleep(500);
				nextBtn.click();
			}
		}

		Thread.sleep(1500);

		System.out.println("Closing the Browser.");
		
		driver.quit();
		
		FileOutputStream file = new FileOutputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\testdata\\UpdateTableViaDynamicWebTable.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Details of Employees");

		int rowCount = names.size();
		
		for (int r=0; r<rowCount; r++) {
			XSSFRow currRow = sheet.createRow(r);
			
			currRow.createCell(0).setCellValue(names.get(r));
			
			currRow.createCell(1).setCellValue(designation.get(r));
			
			currRow.createCell(2).setCellValue(location.get(r));
		}
		
		workbook.write(file);
		
		System.out.println("File Updated !");
		workbook.close();
		
		file.close();
		
		
	}

}
