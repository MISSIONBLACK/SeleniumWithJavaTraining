package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstScript {

    @Test
    public void openSiteInEdge() {
    	
    	// Set the path to the ChromeDriver executable
    	System.setProperty("webdriver.msedge.driver",, "C:\\Selenium Training\\eclipse-workspace\\SeleniumProject\\drivers\\msedgedriver.exe");
    	
    	// Create a new instance of the Edge Driver
    	EdgeDriver driver = new EdgeDriver();
    	
    	driver.get("https://www.facebook.com");
    }
}
