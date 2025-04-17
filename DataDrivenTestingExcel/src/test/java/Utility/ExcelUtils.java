package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Pojo.SingleUser;

public class ExcelUtils {
	public static List<SingleUser> getDummyData() throws IOException {
		String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "testData.xlsx";

		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();

		List<SingleUser> userData = new ArrayList<>();

		for (int i = 1; i <= rowCount; i++) {
			XSSFRow currRow = sheet.getRow(i);
			SingleUser user = new SingleUser(currRow.getCell(0).toString(), currRow.getCell(1).toString(),
					currRow.getCell(2).toString());
			userData.add(user);
		}
		
		workbook.close();
		return userData;
	}
}
