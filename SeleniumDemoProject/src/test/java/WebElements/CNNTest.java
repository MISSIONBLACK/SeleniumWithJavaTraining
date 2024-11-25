package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CNNTest {

	@Test
	public void testTravelLinkwithAbsoluteXPath() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://edition.cnn.com/");
		Assert.assertEquals(driver.getTitle(), "Breaking News, Latest News and Videos | CNN");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("/html/body/header/div/nav/div/div/div[1]/div[1]/nav/div/div[2]/a")).click();

//		driver.findElement(By.xpath("//*[@data-section='world']/a")).click();
		Assert.assertEquals(driver.getTitle(), "World news - breaking news, video, headlines and opinion | CNN");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
	}
	
	@Test
	public void testTravelLinkwithRelativeXPath() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://edition.cnn.com/");
		Assert.assertEquals(driver.getTitle(), "Breaking News, Latest News and Videos | CNN");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id=\"pageHeader\"]/div/div/div[1]/div[1]/nav/div/div[2]/a")).click();

//		driver.findElement(By.xpath("//*[@data-section='world']/a")).click();
		Assert.assertEquals(driver.getTitle(), "World news - breaking news, video, headlines and opinion | CNN");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
// #pageHeader > div > div > div.header__container > div.header__left > nav > div > div:nth-child(2) > a
	}

}
