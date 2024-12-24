package ExtentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // responsible for the UI of the Report and setting the document title and report name 
	public ExtentReports extent; // populates the common info. on the report {tester's name, OS and Browser Name}
	public ExtentTest test; // creates entries in the report for each test case, and responsible for
							// updating the status of each test case post execution

	public void onStart(ITestContext context) { // This will execute only once for a particular class

//		Setting the UI of the Report :-
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/finalTestReport.html"); // location of the report
		
		sparkReporter.config().setDocumentTitle("Automation Report"); // title of the report
		sparkReporter.config().setReportName("Login Test Report"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK); // Theme of the report
		
//		Create the report and apply the UI on the report :-
	
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter); // applied the UI on the report
		
//		Populating the common fields :-
		
		extent.setSystemInfo("Computer Name ", "localhost");
		extent.setSystemInfo("Tester Name ", "Subhadip Das");
		extent.setSystemInfo("Environment ", "QA");
		extent.setSystemInfo("Browser Name ", "Chrome");
		extent.setSystemInfo("OS ", "Windows");
		
	}

//	the result object will contain details of the particular @Test which just got executed

	public void onTestSuccess(ITestResult result) {
//		Create a particular entry in the report corresponding to that @Test
		test = extent.createTest(result.getName());
//		Update the status 
		test.log(Status.PASS, "Test case Pass "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
//		Create a particular entry in the report corresponding to that @Test
		test = extent.createTest(result.getName());
//		Update status
		test.log(Status.FAIL, "Test case Fail "+result.getName());
		test.log(Status.FAIL, "Failure reason "+result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
//		Create a particular entry in the report corresponding to that @Test
		test = extent.createTest(result.getName());
//		Update the status 
		test.log(Status.SKIP, "Test case Skipped "+result.getName());
	}

	public void onFinish(ITestContext context) { // This will execute only once for a particular class.
		extent.flush(); // to update the whole changes on the report
	}
}
