package ExcelDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataFromExcel {

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		
//		1. Create a new Excel File :-
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\custom.xlsx");
		
//		2. Create a new Workbook :-
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
//		3. Create a new Sheet :-
		
		XSSFSheet sheet =  workbook.createSheet("customSheetData");
		
//		4. Get the number of rows and cells :-
		
		System.out.print("Enter the number of rows : ");
		int rowCount = scn.nextInt();
		
		System.out.println("Enter the number of cells : ");
		int cellCount = scn.nextInt();
		
		int counter = 0;
		
//		5. Populate the Sheet :-
		
		for (int r=0; r<rowCount; r++) {
			XSSFRow row = sheet.createRow(r);
			for (int c=0; c<cellCount; c++) {
				row.createCell(c).setCellValue(counter);
				counter ++;
			}
		}
		
//		6. Attach the workbook :-
		
		workbook.write(file);
		
//		7. Close the workbook :-
		workbook.close();
//		8. Close the file :-
		file.close();
	}

}
