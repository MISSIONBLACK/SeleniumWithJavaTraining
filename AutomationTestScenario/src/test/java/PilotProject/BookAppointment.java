//Read Data and Locators from Properties File

package PilotProject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookAppointment extends TestBaseClass {

	@Test
	public void bookAppointmentTest() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		waitforWebPageToLoad();

		// Open Consultation Pop-Up
		driver.findElement(By.linkText(prop.getProperty("doctor_name"))).click();
		waitforWebPageToLoad();
		driver.findElement(By.xpath(prop.getProperty("Consultation_btn"))).click();

		// Validate presence and visibility of Name and any other field
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("name_id"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(prop.getProperty("email_id"))));

		// Enter Name, Email, Mobile
		driver.findElement(By.id(prop.getProperty("name_id"))).sendKeys(prop.getProperty("patient_name"));
		driver.findElement(By.id(prop.getProperty("email_id"))).sendKeys(prop.getProperty("patient_email"));
		driver.findElement(By.id(prop.getProperty("mobile_id"))).sendKeys(prop.getProperty("patient_mobile"));

		// Validate the Text Below the Date Field
		WebElement dateText = driver.findElement(By.xpath(prop.getProperty("dateText_xpath")));
		Assert.assertEquals(dateText.getText(),
				"Preferred Date and Time is subject to change. Our support team will be in contact with you within 24 hours.");

		// Validate Options in Gender
		WebElement genderDropDown = driver.findElement(By.id(prop.getProperty("gender_id")));
		Select dropdown = new Select(genderDropDown);
		dropdown.getOptions();
		for (WebElement dropDownValue : dropdown.getOptions()) {
			System.out.println(dropDownValue.getText());
		}
		dropdown.selectByVisibleText("Male");

		// Enter Date of Birth
		datePickerFromDropDownCalendar("(//input[@id='req_datebirth'])[1]", prop.getProperty("dob"));

		// Validate the presence and visibility of Preferred Date 1 Field
		WebElement req_prefdate1 = driver.findElement(By.xpath("(//input[@id='req_prefdate1'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", req_prefdate1);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='req_prefdate1'])[1]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='req_prefdate1'])[1]")));

		// Select Preferred Visiting Date 1
		datePickerFromSlidingCalender(prop.getProperty("appointment1_date"), "req_prefdate1");

		// Validate the presence and visibility of Preferred Date 2 Field
		WebElement req_prefdate2 = driver.findElement(By.xpath("(//input[@id='req_prefdate2'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", req_prefdate2);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='req_prefdate2'])[1]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='req_prefdate2'])[1]")));

		// Select Preferred Visiting Date 2
		datePickerFromSlidingCalender(prop.getProperty("appointment2_date"), "req_prefdate2");

		// Verify the Visibility of UHID
		Assert.assertFalse(driver.findElement(By.id(prop.getProperty("uhid_id"))).isDisplayed());

		// Check Yes Radio Button
		driver.findElement(By.id(prop.getProperty("radioBtnYes_id"))).click();
		Assert.assertTrue(driver.findElement(By.id(prop.getProperty("uhid_id"))).isDisplayed());

		// Enter UHID
		driver.findElement(By.id(prop.getProperty("uhid_id"))).sendKeys(prop.getProperty("UHID"));

		// Click No Radio Button and Check UHID
		driver.findElement(By.id(prop.getProperty("radioBtnNo_id"))).click();
		Assert.assertFalse(driver.findElement(By.id(prop.getProperty("uhid_id"))).isDisplayed());

		// Click Yes , Verify UHID Field and Compare the Existing UHID
		driver.findElement(By.id(prop.getProperty("radioBtnYes_id"))).click();
		Assert.assertTrue(driver.findElement(By.id(prop.getProperty("uhid_id"))).isDisplayed());
		String actualUHID = driver.findElement(By.id(prop.getProperty("uhid_id"))).getAttribute("value");
		String expectedUHID = prop.getProperty("UHID");
		Assert.assertEquals(actualUHID, expectedUHID);

		Thread.sleep(2000);

	}
}
