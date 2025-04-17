package Utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;

import Pojo.SingleUser;
import Pojo.UserData;

public class JSONFileReader {
	public static List<SingleUser> getDummyUsers() throws FileNotFoundException {
		
		FileReader fileReader = new FileReader("K:\\Selenium Java Automation\\DataDrivenTestingJSON\\src\\test\\resources\\dummyUsers.json");
		
		Gson gson = new Gson();
		UserData userData = gson.fromJson(fileReader, UserData.class);
		
		List<SingleUser> testData = userData.getData();
		return testData;
	}
}
