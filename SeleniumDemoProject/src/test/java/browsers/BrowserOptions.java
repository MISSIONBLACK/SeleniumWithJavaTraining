package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserOptions {

	@Test
	public void chromeBrowserProfiling() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();

		// Chrome maximized
		options.addArguments("--start-maximized");

		options.addArguments(
				"--user-data-dir=C:\\Users\\AKASAGAR\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		Thread.sleep(10000);
		driver.get("https://www.google.com/");

		// Verify the Title
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google");

		Thread.sleep(3000);
		driver.quit();
	}
}
