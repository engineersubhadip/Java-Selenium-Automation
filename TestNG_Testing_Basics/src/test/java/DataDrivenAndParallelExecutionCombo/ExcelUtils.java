package DataDrivenAndParallelExecutionCombo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
//	1. get row count
//	2. get cell count for a particular row
//	3. read cell data for a particular row
	public static FileInputStream file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String filePath, String sheetName) throws IOException {
		file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		file.close();
		return rowCount;
	}

	public static int getCellCount(String filePath, String sheetName, int rowNum) throws IOException {
		
		file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		
		int cellCount = sheet.getRow(rowNum).getLastCellNum();
		
		workbook.close();
		file.close();
		
		return cellCount;
	}

	public static String readCellData(String filePath, String sheetName, int rowNum, int cellNum) throws IOException {
		
		file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		
		String data;
		
		try {
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
		}catch(Exception e) {
			data = "";
		}
		
		workbook.close();
		file.close();
		return data;
	}
}
