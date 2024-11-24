package seleniumWaits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumExpicitlyWaits {

	public WebDriver driver = null;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:/Selenium Training/eclipse-workspace/SeleniumDemoProject/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("file:///C:/Selenium%20Training/eclipse-workspace/SeleniumDemoProject/src/test/java/seleniumWaits/ExplicitWait.html");
	}
	
	@AfterMethod
	public void finish() {
		driver.quit();
	}
	
	@Test
	public void verifyAlert() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement alertBtn = driver.findElement(By.id("alert"));
		alertBtn.click();
		
		// Explicit Waits
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.alertIsPresent());
		
		// Accept the Alert
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
	}
	
	@Test
	public void verifyTextPresent() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement textBtn = driver.findElement(By.id("populate-text"));
		textBtn.click();
		
		WebElement targetText = driver.findElement(By.className("target-text"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.textToBePresentInElement(targetText, "Selenium Webdriver"));
	}
	
	@Test
	public void verifyButtonAvailableText() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Btn = driver.findElement(By.id("display-other-button"));
		Btn.click();
		
		WebElement clickableBtn = driver.findElement(By.id("hidden"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(clickableBtn));
		clickableBtn.click();
	}
	
	@Test
	public void verifyElementEnableTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Btn = driver.findElement(By.id("enable-button"));
		Btn.click();
		
		WebElement clickableBtn = driver.findElement(By.id("disable"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(clickableBtn));
		clickableBtn.click();
	}
	
	@Test
	public void verifyElementSelectText() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Btn = driver.findElement(By.id("checkbox"));
		Btn.click();
		
		WebElement clickableBtn = driver.findElement(By.id("ch"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeSelected(clickableBtn));
	}
}