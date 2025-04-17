package TestCases;

import org.testng.annotations.Test;

import Pojo.SingleUser;

public class Testcase1 {
	
	@Test(dataProvider = "testDummyUser", dataProviderClass = DataProviders.CaptureJSONData.class)
	public void testCase1_JSONData(SingleUser user) {
		System.out.println(user.getEmailAddress()+" || "+user.getPassword());
	}
}
