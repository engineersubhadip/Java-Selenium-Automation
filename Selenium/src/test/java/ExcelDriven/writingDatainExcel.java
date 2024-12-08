package ExcelDriven;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File--->Workbook--->Sheets--->Rows----Cells
public class writingDatainExcel {

	public static void main(String[] args) throws IOException {
		
//		1. Create a new xlsx file :-
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\java\\ExcelDriven\\testdata\\customData.xlsx");
		
//		2. Create a new workBook :-
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
//		3. Create a new Sheet :-
		
		XSSFSheet sheet =  workbook.createSheet("customSheetName");
		
//		4. Create a new Row :-
		
		XSSFRow row1 =  sheet.createRow(0);
		
//		5. Create a new cell in the row :-
		
		row1.createCell(0).setCellValue("Happy Path");
		row1.createCell(1).setCellValue("Happy Path1");
		row1.createCell(2).setCellValue("Happy Path2");
		
		XSSFRow row2 = sheet.createRow(1);
		
		row2.createCell(0).setCellValue("Auto");
		row2.createCell(1).setCellValue("Java");
		row2.createCell(2).setCellValue("Pisces");
		
//		Attach the work book in Excel file :-
		
		workbook.write(file);
		
		workbook.close();
		file.close();
		
		System.out.println("File is created !!!");
	}

}
