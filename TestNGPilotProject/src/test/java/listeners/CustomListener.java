package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CustomListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("*********** TEST Success: " + result.getName() + " **********");
        ExtentTest test = (ExtentTest) result.getAttribute("reporterObject");
        if (test != null) {
            test.log(Status.INFO, "Test Case Name : " + result.getName());
            test.pass("Test Status is Success");
        } else {
            System.out.println("Reporter object is null for: " + result.getName());
        }
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("*********** TEST Failure: " + result.getName() + " **********");
        ExtentTest test = (ExtentTest) result.getAttribute("reporterObject");
        if (test != null) {
            test.log(Status.INFO, "Test Case Name : " + result.getName());
            test.fail("Failure : " + result.getThrowable().getMessage());
        } else {
            System.out.println("Reporter object is null for: " + result.getName());
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName() + 
                           " Reason: " + result.getThrowable());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed but within success percentage: " + result.getName());
    }

    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
    }
}
