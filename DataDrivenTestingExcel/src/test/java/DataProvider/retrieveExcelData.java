package DataProvider;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;

import Pojo.SingleUser;
import Utility.ExcelUtils;

public class retrieveExcelData {
	
	@DataProvider (name = "testData")
	public SingleUser[] getTestData() throws IOException {
		List<SingleUser> userList = ExcelUtils.getDummyData();
		SingleUser[] testData = new SingleUser[userList.size()];
		
		for (int i=0; i<userList.size(); i++) {
			testData[i] = userList.get(i);
		}
		
		return testData;
	}

}
