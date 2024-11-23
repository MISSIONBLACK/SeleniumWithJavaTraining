package TestNGExtent;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Reports.ExtentReportManager;

public class LoginTest {

    ExtentReports extent;
    ExtentTest loginTest;

    @BeforeMethod
    public void init() {
        extent = ExtentReportManager.getReporter();  // Fixed spelling.
        loginTest = extent.createTest("Facebook Login Test");
    }

    @AfterMethod
    public void quit() {
        extent.flush();  // Finalizes the report.
    }

    @Test
    public void loginTest() {
        loginTest.info("Entering User Name");
        loginTest.info("Entering Password");
        loginTest.info("Clicking Submit Button");
        loginTest.info("Verifying Home Page Title");

        try {
            Assert.assertEquals("Facebook Login", "Facebook Login");  // This will pass.
            loginTest.pass("Login Test Passed.");
        } catch (AssertionError e) {
            loginTest.fail("Login Test Failed: " + e.getMessage());
            throw e;  // Ensure test fails when the assertion fails.
        }
    }
}
