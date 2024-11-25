package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RediffSignInTest {

	@Test
	public void verifyRediffSignIn() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// 1. Open Rediff
		driver.get("https://www.rediff.com/");

		// 2. Verify Rediff Page Title
		String expectedPageTitle = "Rediff.com: News | Rediffmail | Stock Quotes | Rediff Gurus";
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);

		// 3. Click on Sign In
		WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		signInLink.click();

		// 4. Verify Sign In Page Title
		String expectedSignInPageTitle = "Rediffmail - Free Email for Login with Secure Access";
		String actualSignInPageTitle = driver.getTitle();
		Assert.assertEquals(actualSignInPageTitle, expectedSignInPageTitle);

		// 5. Enter User Name and Password
		WebElement userNameTextBox = driver.findElement(By.id("login1"));
		WebElement passwordTextBox = driver.findElement(By.id("password"));
		userNameTextBox.sendKeys("anshulc55@icloud.com");
		Thread.sleep(4000);
		passwordTextBox.sendKeys("Test@1234");
		Thread.sleep(4000);

		// 6. Click Sign In Button
		WebElement signInButton = driver.findElement(By.name("proceed"));
		signInButton.click();

		// 7. Verify Page Title
		String expectedSignInSuccessPageTitle = "Rediffmail - Free Email for Login with Secure Access";
		String actualSignInSuccessPageTitle = driver.getTitle();
		Assert.assertEquals(actualSignInSuccessPageTitle, expectedSignInSuccessPageTitle);

		driver.quit();
	}
}
