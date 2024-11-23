package TestNGExtent;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Reports.ExtentReportManager;

public class RegistrationTest {

    ExtentReports extent;
    ExtentTest registrationTest;

    @BeforeMethod
    public void init() {
        extent = ExtentReportManager.getReporter();  // Fixed method name.
        registrationTest = extent.createTest("Facebook Registration Test");
    }

    @AfterMethod
    public void quit() {
        extent.flush();  // This ensures the report data is saved and finalized.
    }

    @Test
    public void regisTest() {
        registrationTest.info("Open the Facebook URL");
        registrationTest.info("Enter the Registration Details");
        registrationTest.info("Submit the Registration Form");
        registrationTest.info("Verify Page Title");
        registrationTest.pass("Test Success....");
    }
}
