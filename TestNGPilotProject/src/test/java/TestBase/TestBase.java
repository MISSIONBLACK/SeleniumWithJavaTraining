package TestBase;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Reports.ExtentReportManager;

public class TestBase {

	public ExtentReports report;
	public ExtentTest test;

	public SoftAssert softAssert;

	@BeforeMethod(alwaysRun = true)
	public void init(ITestResult res) {
		report = ExtentReportManager.getReporter();
		test = report.createTest(res.getMethod().getMethodName().toUpperCase());
		res.setAttribute("reporterObject", test);
		softAssert = new SoftAssert();
	}

	@AfterMethod
	public void quit() {
		System.out.println("@AfterMethod -- @AfterMethod");
		report.flush();
	}

	public void log(String msg) {
		System.out.println(msg);
		test.info(msg);
	}

	public void pass(String msg) {
		System.out.println(msg);
		test.pass(msg);
	}

	public void fail(String msg) {
		System.out.println(msg);
		test.fail(msg);
	}

	public void skip(String msg) {
		System.out.println(msg);
		test.skip(msg);
	}

	// Print soft assert in Extent Report, Fail the test in TestNG
	public void softAssert(String msg) {
		fail(msg);
		softAssert.fail(msg);
	}

	// Print Error in Extent and Stop Execution
	public void failAndStop(String msg) {
		fail(msg);
		softAssert.assertAll();
	}

}
