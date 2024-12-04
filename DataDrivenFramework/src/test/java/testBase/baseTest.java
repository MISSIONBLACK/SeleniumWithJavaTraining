package testBase;

import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import keyWords.applicationKeywords;
import reports.ExtentReportManager;

public class baseTest {

	public applicationKeywords app;
	public ExtentReports extentReport;
	public ExtentTest extentTest;

	@BeforeTest(alwaysRun = true)
	public void beforeTest(ITestContext context) {
		System.out.println("*****BeforeTest*****");
		app = new applicationKeywords();
		context.setAttribute("app", app);

		// Init Reports
		extentReport = ExtentReportManager.getReports();
		extentTest = extentReport.createTest(context.getCurrentXmlTest().getName());
		extentTest.log(Status.INFO, "Starting Test : " + context.getCurrentXmlTest().getName());
		app.setReport(extentTest);

		context.setAttribute("extentReport", extentReport);
		context.setAttribute("extentTest", extentTest);
		context.setAttribute("app", app);

	}

	@AfterTest(alwaysRun = true)
	public void afterTest(ITestContext context) {
		app = (applicationKeywords) context.getAttribute("app");
		if (app != null) {
			app.quitDriver();
		}

		extentReport = (ExtentReports) context.getAttribute("extentReport");
		if (extentReport != null) {
			extentReport.flush();
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestContext context) {

//		System.out.println("*****BeforeMethod*****");
		app = (applicationKeywords) context.getAttribute("app");
		extentReport = (ExtentReports) context.getAttribute("extentReport");
		extentTest = (ExtentTest) context.getAttribute("extentTest");

		String criticalFailure = (String) context.getAttribute("isCriticalFaliure");
		if (criticalFailure != null && criticalFailure.equals("true")) {
			app.logSkip("Critical Faliure in Previous Test Method");
			throw new SkipException("Critical Faliure in Previous Test Method");
		}
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestContext context) {
		app.reportAll();
	}
}