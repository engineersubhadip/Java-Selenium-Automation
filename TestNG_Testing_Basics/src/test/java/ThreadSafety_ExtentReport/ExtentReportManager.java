package ThreadSafety_ExtentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public boolean basicReport = false;
	Lock onStartLock = new ReentrantLock();
	Lock postActionLockSuccess = new ReentrantLock();
	Lock postActionLockFailure = new ReentrantLock();
//	private ThreadLocal<ExtentTest> tLocalTest = new ThreadLocal<>();
	
	public void onStart(ITestContext context) {
		onStartLock.lock();
		if (basicReport == false) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date dt = new Date();
			String fileName = format.format(dt);
			
			sparkReporter = new ExtentSparkReporter("K:\\Selenium Java Automation\\TestNG_Testing_Basics\\reports\\" + fileName+".html");
			sparkReporter.config().setDocumentTitle("Automation Report");
			sparkReporter.config().setReportName("Open Cart Application");
			sparkReporter.config().setTheme(Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			
			extent.setSystemInfo("SDET", System.getProperty("user.name"));
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Application", "Open Cart");
			basicReport = true;
		}
		onStartLock.unlock();
	}

	public void onTestSuccess(ITestResult result) {
		postActionLockSuccess.lock();
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.PASS, result.getMethod().getMethodName());
		postActionLockSuccess.unlock();
	}

	public void onTestFailure(ITestResult result) {
		postActionLockFailure.lock();
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.info(result.getThrowable());
		String ssFilePath = takeScreenShot();
		test.addScreenCaptureFromPath(ssFilePath);
		postActionLockFailure.unlock();
	}
	
	public String takeScreenShot () {
		File src = ((TakesScreenshot)BaseTest.tLocalDriver.get()).getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date dt = new Date();
		String ssFile = format.format(dt);
		
		String ssFilePath = "K:\\Selenium Java Automation\\TestNG_Testing_Basics\\screenshots\\"+ssFile+".png";
		try {
			FileUtils.copyFile(src, new File(ssFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ssFilePath;
	}
	
	public void onFinish(ITestContext context) {
//		if (extent.flush() == null) {
			extent.flush();			
//		}
	}
}
