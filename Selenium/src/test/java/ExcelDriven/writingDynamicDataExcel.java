package ExcelDriven;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writingDynamicDataExcel {

	public static void main(String[] args) throws IOException {
		
		Scanner scn = new Scanner(System.in);
		
//		1. Create a Excel File :-
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\java\\ExcelDriven\\testdata\\dynamicData1.xlsx");
		
//		2. Create a workbook :-
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
//		3. Create a new Sheet inside the workbook :-
		
		XSSFSheet sheet =  workbook.createSheet("DynamicCustomData");
		
//		4. Take user Input :-
		
//		A. Number of Rows :-
		
		System.out.println("Enter the number of rows");
		int userRow = scn.nextInt();
		
//		B. Number of Cols :-
		
		System.out.println("Enter the number of columns");
		int userCol = scn.nextInt();
		
		int currRowCount = 1;
		int currColCount = 1;
		int counter = 12;
		
		while (currRowCount <= userRow) {
			XSSFRow row =  sheet.createRow(currRowCount);
			
			for (int i=0; i<userCol; i++) {
				XSSFCell cell = row.createCell(i);
				cell.setCellValue(counter);
				counter ++;
			}
			currRowCount ++;
		}
		
		XSSFRow row =  sheet.createRow(27);
		
		row.createCell(13).setCellValue("This is a random value I am updating");
		
//		5. Attach the workbook to the file :-
		
		workbook.write(file);
		
		workbook.close();
		file.close();
		
		System.out.println("File Created !!!");
	}

}
