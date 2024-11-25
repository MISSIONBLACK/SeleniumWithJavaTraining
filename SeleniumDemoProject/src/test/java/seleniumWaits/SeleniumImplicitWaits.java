package seleniumWaits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumImplicitWaits {

	@Test
	public void googleSearchTest() throws InterruptedException {

		// Set up Chrome WebDriver
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximize the browser window
		driver.manage().window().maximize();

		// Set implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Navigate to Google
		driver.get("https://www.google.com/");

		// Locate the search box and perform a search
		WebElement searchBox = driver.findElement(By.xpath("//textarea[@title='Search' and @role='combobox']"));
		searchBox.sendKeys("Selenium WebDriver");
		searchBox.submit(); // Submit the search query

		// Wait and click the first search result (ensure XPath targets the desired
		// result)
		WebElement searchResult = driver.findElement(By.xpath("(//h3)[1]")); // Clicks the first search result
		searchResult.click();

		// Quit the browser
		driver.quit();
	}
}
