package browsers;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InvokeDynamicBrowser {

	/*
	 * Test 1: Open the Selenium Official Site and verify the home screen title Test
	 * 2: Open Yahoo and verify the home screen title
	 */

	public WebDriver driver = null;

	@Parameters("browser")
	@BeforeMethod
	public void openBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/drivers/chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized", "--disable-infobars");
			options.addArguments("--disable-extensions");

			// Use proxy
			Proxy proxy = new Proxy();
			proxy.setHttpProxy("proxy.example.com:8080");
			options.setCapability("proxy", proxy);
			options.addArguments("--incognito");
			options.addArguments("--disable-notifications");
			options.addArguments("ignore-certificate-errors");

			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver",
					"C:/Selenium Training/eclipse-workspace/SeleniumDemoProject/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		// Maximize Browser Window
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}

	@Test
	public void verifyCACertError() throws InterruptedException {
		driver.get("https://expired.badssl.com");
		Thread.sleep(3000);
	}

	@Test
	public void verifySeleniumSite() throws InterruptedException {

		driver.get("https://www.selenium.dev/");

		// Verify the Title
		String title = driver.getTitle();
		Assert.assertEquals(title, "Selenium");

		Thread.sleep(3000);
	}

	@Test
	public void verifyOrangeHRMSite() throws InterruptedException {

		driver.get("https://www.orangehrm.com/");

		// Verify the Title
		String title = driver.getTitle();
		Assert.assertEquals(title, "Human Resources Management Software | OrangeHRM");

		Thread.sleep(3000);
	}
}