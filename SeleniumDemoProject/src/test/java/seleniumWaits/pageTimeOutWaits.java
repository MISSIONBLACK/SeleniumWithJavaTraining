package seleniumWaits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class pageTimeOutWaits {

	@Test
	public void pageTimeOutWaits() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		
		driver.get("https://edition.cnn.com/");
		Assert.assertEquals(driver.getTitle(), "Breaking News, Latest News and Videos | CNN");

		driver.quit();

	}

}
