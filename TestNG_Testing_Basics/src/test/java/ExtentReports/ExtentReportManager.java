package ExtentReports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
//	Responsible for :-
//	1. Setting the Report Location in the current Project directory.
//	2. Configuring the UI of the report
//	3. Setting the Document Title and Report Name
	public ExtentSparkReporter extentSparkReporter;
//	Responsible for :-
//	1. Creating a blank report
//	2. Populating the common info on the report
	public ExtentReports extent;
//	Responsible for :-
//	1. Creating an entry in the report corresponding to the particular @Test Class/Method
//	2. Updating the status in the report
	public ExtentTest test;

// 	"onStart" Will be executed before any of the annotations in a <test> module gets executed.
//	context refers to the particular <test> module in the XML file getting executed.	
	public void onStart(ITestContext context) {
		
//		1. Creating the report Name via time-stamp approach.
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date dt = new Date();
		String fileName = df.format(dt);
		
//		2. Setting the Report Location in the current Project directory.
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/report_"+fileName+".html");
		
//		3. Configuring the UI.
		extentSparkReporter.config().setDocumentTitle("Automation Report");
		extentSparkReporter.config().setReportName("T-Mobile App");
		extentSparkReporter.config().setTheme(Theme.DARK);
		
//		4. Creating blank report.
		extent = new ExtentReports();
		extent.attachReporter(extentSparkReporter); // configured the UI into the Blank report
		
//		5. Populating the common data in the report.
		extent.setSystemInfo("Application Name", "Open Cart");
		extent.setSystemInfo("Owner Name", System.getProperty("user.name"));
		extent.setSystemInfo("Browser Name", context.getCurrentXmlTest().getParameter("browser"));
		extent.setSystemInfo("OS Name", context.getCurrentXmlTest().getParameter("os"));
	}

	
//	"onTestSuccess" will be executed after a @Test is successfully executed.
//	"result" denotes the particular @Test Method which got executed.
	public void onTestSuccess(ITestResult result) {
//		1. Create an entry corresponding to particular @Test Class/method
		test = extent.createTest(result.getTestClass().getName()); // On the report, entry is made for the particular @Test Class
//		2. If the @Test Method is part of any groups, update that in the report
		test.assignCategory(result.getMethod().getGroups());
//		3. Update the status in the report.
		test.log(Status.PASS, result.getName()); // made the particular @Test Method pass
	}
	
	
//	"onTestFailure" will be executed after a @Test is successfully executed.
//	"result" denoted the particular @Test Method which got executed.
	public void onTestFailure(ITestResult result) {
//		1. Create an entry in the report corresponding to the particular @Test Method/Class.
		test = extent.createTest(result.getTestClass().getName());
//		2. Assign group to the particular entry if the @Test Method was part of some group or not.
		test.assignCategory(result.getMethod().getGroups());
//		4. Update the status.
		test.log(Status.FAIL, result.getName());
		test.info(result.getThrowable());
//		5. Attach Screenshot to the test entry.
		try {
			String picFile = BaseTest.captureScreenShot();
			test.addScreenCaptureFromPath(picFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

//	"onTestSkipped" will be executed after a @Test is skipped.
//	"result" denotes the particular @Test Method which is skipped.
	public void onTestSkipped(ITestResult result) {
//		1. Create an entry corresponding to the particular @Test Class/Method.
		test = extent.createTest(result.getTestClass().getName());
//		2. Assign the @Test to a particular group if it is a part of.
		test.assignCategory(result.getMethod().getGroups());
//		3. Update the status in the report.
		test.log(Status.SKIP, result.getName());
		test.info(result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext context) { 
		extent.flush();
	}
}
