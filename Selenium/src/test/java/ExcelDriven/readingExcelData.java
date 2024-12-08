package ExcelDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//Excel File--->Workbook--->Sheets--->Rows----Cells
public class readingExcelData {

	public static void main(String[] args) throws IOException {
		
//		1. Open the Excel File :-
		System.out.println(System.getProperty("user.dir"));
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\ExcelDriven\\testdata\\data.xlsx");
		
//		2. Extract the Work Book from the File :-
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
//		3. Extract the Sheet from the WorkBook :-
		
		XSSFSheet sheet =  workbook.getSheet("Sheet1");
		
//		4. Get the total row num :-
		
		int totalRows =  sheet.getLastRowNum();
		
//		5. Get the total col num :-
		
		int totalCols = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Number of Rows : "+totalRows);
		System.out.println("Number of Cols : "+totalCols);
		
		for (int r=0; r <= totalRows; r++) {
			XSSFRow currentRow = sheet.getRow(r);
			for (int c=0; c < totalCols; c++) {
				String value = currentRow.getCell(c).toString();
				System.out.print(value+" ");
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
		
	}

}
