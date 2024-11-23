package SeleniumIntro;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {
	
	@Test
	public void OpenSiteInChrome() {
		
		System.out.println("First Project");
		
		// Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "C:/Selenium Training/eclipse-workspace/SeleniumDemoProject/drivers/chromedriver.exe");
		
		// Create a new instance of the ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.quit();
		
	}

}
