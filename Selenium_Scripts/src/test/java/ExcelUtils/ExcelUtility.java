package ExcelUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static FileInputStream file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
//	public static CellStyle style;
	public static FileOutputStream file2;
	
//	Row Count
	
	public static int getRowCount(String filePath, String sheetName) throws IOException {
		file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		file.close();
		return rowCount;
	}

//	Cell Count
	
	public static int getCellCount(String filePath, String sheetName, int rowNum) throws IOException {
		file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		
		int cellCount = sheet.getRow(rowNum).getLastCellNum();
		
		workbook.close();
		file.close();
		return cellCount;
	}

//	getCell Data
	
	public static String getCellData(String filePath, String sheetName, int rowNum, int cellNum) throws IOException {
		file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		String data;
		
		try {
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		}catch(Exception e) {
			data = "";
		}
		
		workbook.close();
		file.close();
		
		return data;
	}
	
//	setCell Data
	
	public static void setCellData(String filePath, String sheetName, int rowNum, int cellNum, String data) throws IOException {
//		We are reading and writing the data both
		
//		Part one reading :-
		file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum); // On which particular row, I want to update
		
//		Part two writing :-
		cell = row.createCell(cellNum); // whatever row, I received, I am creating a new cell in that row
		cell.setCellValue(data);
		file2 = new FileOutputStream(filePath);
		workbook.write(file2);
		
		workbook.close();
		file.close();
		file2.close();
	}
}
