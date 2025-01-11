package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseTest.BaseTest;

public class ExtentReportManager implements ITestListener {
	
	private ExtentSparkReporter sparkReporter;
//	Responsibility :-
//	1. Setting up the location of the Report
//	2. Configuring the UI of the Report
	private ExtentReports extent;
//	Responsibility :-
//	1. Creating Blank Report
//	2. Configuring the UI in the Report
//	3. Populating the common info in the Report
	private ExtentTest test;
//	Responsibility :-
//	1. Create an entry in the Report
//	2. Update the status in the Report
	
//	"onStart" will be executed before the execution of any of the @ in the particular <test> module
//	"context" points to current <test> module being executed
	public void onStart(ITestContext context) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date dt = new Date();
		String fileName = format.format(dt);
		
//		1. Setting up the Report location :-
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\"+fileName+".html");
//		2. Configuring the UI of the Report :-
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Open Cart");
		sparkReporter.config().setTheme(Theme.DARK);
//		3. Creating the Blank report and configuring the UI :-
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
//		4. Populating the Common Data in the Report :-
		extent.setSystemInfo("Application", "Open Cart");
		extent.setSystemInfo("Tester Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
		List<String> groups = context.getCurrentXmlTest().getIncludedGroups();
		
		if (!groups.isEmpty()) {
			extent.setSystemInfo("Groups", groups.toString());
		}
	}
	
//	"onTestSuccess" gets executed once a Test method gets successfully executed
//	"result" points to @Test
	public void onTestSuccess(ITestResult result) {
//		1. Create an entry corresponding to the particular @Test Method/Class
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
//		2. Update the Status in the Report
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
//		1. Create an entry corresponding to the particular @Test Method/Class
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
//		2. Update the Status in the Report
		test.log(Status.FAIL, result.getMethod().getMethodName());
//		3. Attach the Logs
		test.log(Status.INFO, result.getThrowable());
		
		try {
			String screenshotPath = BaseTest.takeScreenshot();
			Thread.sleep(2000);
			test.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.INFO, result.getThrowable());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
