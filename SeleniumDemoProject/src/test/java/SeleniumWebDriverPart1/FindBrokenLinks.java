package SeleniumWebDriverPart1;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindBrokenLinks {

	WebDriver driver = null;

	@Test
	public void findBrokenLinksTest() throws IOException {

		// Get all links on the webpage
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Number of Links: " + allLinks.size());

		int skippedLinksCount = 0;

		// Click each link to verify link status
		for (WebElement link : allLinks) {
			String linkURL = link.getAttribute("href");

			// Skip null or empty links
			if (linkURL == null || linkURL.isEmpty()) {
				System.out.println("Skipped empty or null link.");
				skippedLinksCount++;
				continue;
			}

			// Verify the link status
			VerifyLinkStatus.verifyLink(linkURL);
		}

		// Display final summary
		System.out.println("\n=== Summary ===");
		System.out.println("Total Links Processed: " + allLinks.size());
		System.out.println("Skipped Links: " + skippedLinksCount);
		VerifyLinkStatus.getInvalidLinkCount();
	}

	@BeforeMethod
	public void init() {
		// Setup WebDriver for Chrome
		System.setProperty("webdriver.chrome.driver",
				"C:/Selenium Training/eclipse-workspace/SeleniumDemoProject/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Navigate to the target webpage
		driver.get("https://edition.cnn.com/");
//        driver.get("https://money.rediff.com/index.html");
	}

	@AfterMethod
	public void finish() {
		// Quit the WebDriver
		driver.quit();
	}
}
