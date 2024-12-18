package testCases;

import org.testng.annotations.Test;

import keyWords.applicationKeywords;

public class CreatePortfolioTest extends applicationKeywords {

	@Test
	public void createPortfolioTest() {

		/*
		 * 1. Open Target WebPage 2. Click on SignIn Button/Link 3. Enter Login Details
		 * 4. Click on Submit Button 5. Verify you are on Portfolio Page after login 6.
		 * Click Create Portfolio Link 7. Enter the portfolio name 8. Click on Create
		 * Portfolio Link
		 */

		applicationKeywords app = new applicationKeywords();

		app.openBrowser("browser_name");
		app.openURL("URL");
		app.click("signIn_linkText");
		app.type("userName_id", "anshulc55@rediffmail.com");
		app.type("password_xpath", "Test@12345");
		app.enterCaptcha("captcha_css");
		app.clickButton("submitBtn_name");
		app.validateTitle("portfolioTitle");
		app.quitDriver();
	}
}
