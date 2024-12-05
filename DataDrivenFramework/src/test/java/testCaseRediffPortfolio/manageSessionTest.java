package testCaseRediffPortfolio;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.BaseTest;

public class manageSessionTest extends BaseTest {

	@Test
	public void doLogin(ITestContext con) {
		app.logInfo("Login Application");
		app.openBrowser("browser_name");
		app.openURL("URL");
		app.click("signIn_linkText");
		app.type("userName_id", "anshulc55@rediffmail.com");
		app.type("password_xpath", "Test@12345");
//		app.enterCaptcha("captcha_id");
		app.wait(20);
		app.clickButton("submitBtn_id");
		app.reportAll();

	}

	@Test
	public void doLogOut(ITestContext con) {
		extentTest.log(Status.INFO, "Logging Out");

		System.out.println("Logout successful.");
	}
}
