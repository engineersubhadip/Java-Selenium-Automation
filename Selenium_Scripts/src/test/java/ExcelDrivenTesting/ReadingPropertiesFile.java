package ExcelDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
//		1. Create object of properties file :-
		Properties properties = new Properties();

//		2. Locate the file in reading mode :-
		FileInputStream file = new FileInputStream("K:\\Selenium Java Automation\\Selenium_Scripts\\src\\test\\java\\testdata\\config.properties");
		
//		3. Load the properties file :-
		properties.load(file);
		
//		4. Reading data from Property file :-
		System.out.println(properties.getProperty("password"));
		System.out.println(properties.getProperty("orderid"));
	}

}
