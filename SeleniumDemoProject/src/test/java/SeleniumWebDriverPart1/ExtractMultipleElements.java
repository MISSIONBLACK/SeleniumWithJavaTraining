package SeleniumWebDriverPart1;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtractMultipleElements {
	WebDriver driver = null;

	@Test
	public void findNumberofLinksOnWebPage() {

		// Total Number of Links
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links :: " + allLinks.size());

		// Extract text and URL of Specific Link - 6th Link
		WebElement sixthLink = allLinks.get(5);
		System.out.println("6th Link Text is  :: " + sixthLink.getText());
		System.out.println("6th Link URL is :: " + sixthLink.getAttribute("href"));

		// Extract text and URL of each and every Link
		System.out.println("*******************************************************************");
		int links = 1;
		for (WebElement link : allLinks) {
			System.out.println(links + ". Link Text is :: " + link.getText() + " ---> Link URL is :: "
					+ link.getAttribute("href"));
			links++;
		}

		System.out.println("*******************************************************************");
		
		// Extract all non-hidden Links
		for (WebElement link : allLinks) {
			int hiddenLinks = 1;
			if (link.isDisplayed()) {
				System.out.println(hiddenLinks + ". Non Hidden Link Text is :: " + link.getText() + " ---> Non Hidden Link URL is :: "
						+ link.getAttribute("href"));
				hiddenLinks++;
			}
		}
	}

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Selenium Training/eclipse-workspace/SeleniumDemoProject/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://edition.cnn.com/");
	}

	@AfterMethod
	public void finish() {
		driver.quit();
	}
}
