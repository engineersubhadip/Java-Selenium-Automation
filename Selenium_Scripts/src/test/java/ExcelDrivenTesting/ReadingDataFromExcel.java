package ExcelDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
//		1. Open the File :-
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\data.xlsx");
		
//		2. Open the WorkBook :-
		
		XSSFWorkbook workbook = new XSSFWorkbook(file); 
		
//		3. Open the Sheet in the Workbook :-
		
		XSSFSheet sheet = workbook.getSheet("Sheet2");
		
//		4. Count total number of rows :-
		
		int rowCount = sheet.getLastRowNum();
		
//		5. Count total number of cells :-
		
		int cellCount = sheet.getRow(0).getLastCellNum();
		
//		6. Print the Data :-
		
		for (int r=0; r<=rowCount; r++) {
			XSSFRow currRow = sheet.getRow(r);
			for (int c=0; c<cellCount; c++) {
				XSSFCell currCell = currRow.getCell(c);
				System.out.print(currCell.toString()+" ");
			}
			System.out.println();
		}
		
//		7. Close Workbook :-
		workbook.close();
//		8. Close File :-
		file.close();
	}

}
