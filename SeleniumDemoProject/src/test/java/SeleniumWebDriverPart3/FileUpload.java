package SeleniumWebDriverPart3;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {

	WebDriver driver = null;

	@Test
	public void uplaodFileTest() throws InterruptedException {
		Assert.assertEquals(driver.getTitle(), "The Internet");

		// Upload the file
		WebElement fileUploadBtn = driver.findElement(By.id("file-upload"));
		String fileName = "C:\\Selenium Training\\eclipse-workspace\\SeleniumDemoProject\\src\\test\\java\\SeleniumWebDriverPart3/jpeg-optimizer_Photo.jpg";

		fileUploadBtn.sendKeys(fileName);
		Thread.sleep(5000);

		WebElement fileSubmitBtn = driver.findElement(By.id("file-submit"));
		fileSubmitBtn.click();
		Thread.sleep(5000);

		String fileConfirmation = driver.findElement(By.className("example")).getText().trim();
		String expectedMessage = "File Uploaded!\njpeg-optimizer_Photo.jpg".trim();

		Assert.assertEquals(fileConfirmation, expectedMessage, "The actual and expected messages do not match.");

	}

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://the-internet.herokuapp.com/upload");

	}

	@AfterMethod
	public void finish() {
		driver.quit();
	}
}
