package liteners_Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClassUtility.Baseclass;

public class Listeners implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("suite execution started-configure the reports", true);
		String time = new Date().toString().replace(":", "_").replace(" ", "_");

		// configure the report
		spark = new ExtentSparkReporter("./AdvancedReports/report_" + time + ".html");
		spark.config().setDocumentTitle("Vtiger CRM Project");
		spark.config().setReportName("Test Report");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOWS-11");
		report.setSystemInfo("BROWSER", "CHROME - 138");

		test = report.createTest("Test");
		test.log(Status.INFO, "Configuring the Report");

	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("suite execution ended-backup the reports", true);
		test.log(Status.INFO, "Report Backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Reporter.log(testname + "test execution started", true);
		test.log(Status.INFO, "" + testname + "test execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Reporter.log(testname + "test execution success", true);
		test.log(Status.PASS, "" + testname + "test execution success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		String time = new Date().toString().replace("", "_").replace(":", "_");
		Reporter.log(testname + "test exectution failed", true);
		test.log(Status.FAIL, "" + testname + "test exectution failed");
		TakesScreenshot ts = (TakesScreenshot) Baseclass.sdriver;
		String ss = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss, "" + testname + time + "");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Reporter.log(testname + "test excetion skipped", true);
		test.log(Status.SKIP, "" + testname + "test excetion skipped");
	}

}

// File src = ts.getScreenshotAs(OutputType.FILE);
// File dest = new File("./Screenshot"+testname+".png");
