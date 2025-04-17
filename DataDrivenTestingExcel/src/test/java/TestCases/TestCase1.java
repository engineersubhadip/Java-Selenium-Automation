package TestCases;

import org.testng.annotations.Test;

import Pojo.SingleUser;

public class TestCase1 {
	
	@Test(dataProvider = "testData", dataProviderClass = DataProvider.retrieveExcelData.class)
	public void getTestData(SingleUser user) {
		System.out.println(user.getUserName() + " || "+user.getUserStatus());
	}
}
