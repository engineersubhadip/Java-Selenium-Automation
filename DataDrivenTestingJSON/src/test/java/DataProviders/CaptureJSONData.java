package DataProviders;

import java.io.FileNotFoundException;
import java.util.List;

import org.testng.annotations.DataProvider;

import Pojo.SingleUser;
import Utility.JSONFileReader;

public class CaptureJSONData {
	
	@DataProvider(name = "testDummyUser")
	public SingleUser[] getJSONTestData () throws FileNotFoundException {
		List<SingleUser> testData = JSONFileReader.getDummyUsers();
		SingleUser[] dummyData = new SingleUser[testData.size()];
		
		for (int i=0; i<testData.size(); i++) {
			dummyData[i] = testData.get(i);
		}
		
		return dummyData;
	}
}
