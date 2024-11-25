package seleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HardCodedWaits {

	/*
	 * Test Case -- Google Search Text
	 */

	@Test
	public void googleSearchTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		WebElement searchBox = driver.findElement(By.xpath("//textarea[@title='Search' and @role='combobox']"));
		searchBox.sendKeys("Selenium Webdriver");
		Thread.sleep(4000);
		
		WebElement searchResult = driver.findElement(By.xpath("//li[@role='presentation'][4]"));
		searchResult.click();
		
		Thread.sleep(2000);
		
		driver.quit();

	}

}
