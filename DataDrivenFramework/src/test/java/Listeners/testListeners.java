package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;

public class testListeners implements ITestListener{

	public void onTestFailure(ITestResult result) {
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("extentTest");
		test.fail(result.getThrowable().getMessage());
	}

	public void onTestSuccess(ITestResult result) {
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("extentTest");
		test.pass("Test Success : " + result.getName());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("extentTest");
		test.skip(result.getName() + " :: Test Skipped Due to Critical Error in Previous Test");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
