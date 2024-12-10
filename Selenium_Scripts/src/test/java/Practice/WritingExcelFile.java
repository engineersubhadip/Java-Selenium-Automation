package Practice;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcelFile {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\practiceSheet.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("My Practice Sheet");
		
		int rowCount = 4;
		int cellCount = 8;
		
		int userCount = 1;
		
		for (int r=0; r<rowCount; r++) {
			XSSFRow currRow = sheet.createRow(r);
			for (int c=0; c<cellCount; c++) {
				XSSFCell currCell = currRow.createCell(c);
				currCell.setCellValue(userCount);
				userCount ++;
			}
		}
		
		workbook.write(file);
		
		System.out.println("Written in the Excel File ...");
		workbook.close();
		file.close();
	}

}
