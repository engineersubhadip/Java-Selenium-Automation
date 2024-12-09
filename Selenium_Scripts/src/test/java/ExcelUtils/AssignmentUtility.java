package ExcelUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AssignmentUtility {
	public static FileInputStream file1;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream file2;
	
//	1. Get Row Count in the sheet
//	2. Get Cell Count for particular row
//	3. Read Particular cell data on a row
//	4. Set cell data for a particular row
	
	public static int getRowCount(String filePath, String sheetName) throws IOException {
		file1 = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file1);
		sheet = workbook.getSheet(sheetName);
		
		int totalRowCount = sheet.getLastRowNum();
		workbook.close();
		file1.close();
		return totalRowCount;
	}
	
	public static int getCellCount(String filePath, String sheetName, int rowNum) throws IOException {
		file1 = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file1);
		sheet = workbook.getSheet(sheetName);
		
		int totalCellCount = sheet.getRow(rowNum).getLastCellNum();
		workbook.close();
		file1.close();
		return totalCellCount;
	}
	
	public static String readCellData(String filePath, String sheetName, int rowNum, int cellNum) throws IOException {
		file1 = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file1);
		sheet = workbook.getSheet(sheetName);
		
		String data;
		
		try {
			data = sheet.getRow(rowNum).getCell(cellNum).toString();
		}catch (Exception e) {
			data = "";
		}
		
		workbook.close();
		file1.close();
		return data;
	}
	
	public static void setCellData(String filePath, String sheetName, int rowNum, int cellNum, String userData) throws IOException {
		file2 = new FileOutputStream(filePath);
		workbook = new XSSFWorkbook();
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rowNum);
		row.createCell(cellNum).setCellValue(userData);
		workbook.write(file2);
		
		workbook.close();
		file2.close();
	}
}
