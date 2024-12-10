package ExcelDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * If for an existing Excel File, I want to update certain
 * cell/s, then we would use this approach
 */

public class ReadingWritingBoth {

	public static void main(String[] args) throws IOException {

//		Part One :- (Reading Part)

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\testdata\\practiceSheet.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("My Practice Sheet");

		int rowCount = sheet.getLastRowNum();

		for (int r = 0; r <= rowCount; r++) {
			XSSFRow currRow = sheet.getRow(r);
			XSSFCell newCell = currRow.createCell(9);
			newCell.setCellValue("This is new Value");
		}

//		Part Two :- (Writing Part)

		FileOutputStream file2 = new FileOutputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\testdata\\practiceSheet.xlsx");
		
		workbook.write(file2);
		
		System.out.println("The Excel File has been updated....");
		
		workbook.close();
		file2.close();
		file.close();
	}

}
