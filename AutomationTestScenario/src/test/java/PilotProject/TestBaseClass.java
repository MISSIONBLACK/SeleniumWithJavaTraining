package PilotProject;

import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseClass {

	WebDriver driver = null;
	Properties prop = null;

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		prop = new Properties();
		try {
			FileInputStream fIS = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\sakraWorldHospital_BookAppointment.properties");
			prop.load(fIS);
			System.out.println("Property file path: " + System.getProperty("user.dir")
					+ "\\src\\test\\resources\\sakraWorldHospital_BookAppointment.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void finish() {
		driver.quit();
	}

	public void waitforWebPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int i = 0;

		while (i != 10) {
			String state = (String) js.executeScript("return document.readyState;");
//			System.out.println(state);

			if (state.equals("complete"))
				break;
			else
				wait(2);

			i++;
		}

		// check for jQuery status
		i = 0;
		while (i != 10) {

			Long d = (Long) js.executeScript("return jQuery.active;");
//			System.out.println(d);
			if (d.longValue() == 0)
				break;
			else
				wait(2);
			i++;

		}
	}

	public void wait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void datePickerFromDropDownCalendar(String calendarProperty, String suppliedDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date dob_year;

		try {
			dob_year = dateFormat.parse(suppliedDate);

			// click dob block
			WebElement inputElement = driver.findElement(By.xpath(calendarProperty));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputElement);
			inputElement.click();

			// select Year
			String year = new SimpleDateFormat("yyyy").format(dob_year);
			System.out.println("Supplied Date Year :: " + year);

			WebElement calendarYear = driver.findElement(By.xpath("(//select[@class='ui-datepicker-year'])"));
			selectFromeDropDown(calendarYear, year);

			// Select Month
			String month = new SimpleDateFormat("MMM").format(dob_year);
			System.out.println("Supplied Date Month :: " + month);

			WebElement calendarMonth = driver.findElement(By.xpath("(//select[@class='ui-datepicker-month'])"));
			selectFromeDropDown(calendarMonth, month);

			// Select day
			String day = new SimpleDateFormat("d").format(dob_year);
			System.out.println("Supplied Date Day :: " + day);

			WebElement calendarDay = driver.findElement(By.xpath("//a[text()='" + day + "']"));
			calendarDay.click();

			Thread.sleep(2000);
		} catch (ParseException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void selectFromeDropDown(WebElement element, String selectTable) {
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(selectTable);
	}

	public void datePickerFromSlidingCalender(String suppliedDate, String preferredDateId) {
		SimpleDateFormat datFormat = new SimpleDateFormat("dd-MM-yyyy");

		try {
			Date dateYear = datFormat.parse(suppliedDate);
			Date currentDate = new Date();

			String year = new SimpleDateFormat("yyyy").format(dateYear);
			String month = new SimpleDateFormat("MMMM").format(dateYear);

			String appDate = month + " " + year;
			System.out.println("Supplied Month and Year : " + appDate);

			// Use the provided preferredDateId (either req_prefdate1 or req_prefdate2)
			WebElement inputElement = driver.findElement(By.xpath("(//input[@id='" + preferredDateId + "'])[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputElement);
			inputElement.click();

			// Get the month and year displayed in the calendar
			String monthYearDisplayed = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']")).getText();
			System.out.println("Getting Calendar Month and Year : " + monthYearDisplayed);

			// Navigate through the months until the desired month and year are displayed
			while (!appDate.equals(monthYearDisplayed)) {

				// Click on forward or backward based on the comparison with the current date
				if (dateYear.compareTo(currentDate) == 1) {
					// Click on forward
					driver.findElement(By.xpath("//span[text()='Next']")).click();
				} else if (dateYear.compareTo(currentDate) == -1) {
					// Click on backward
					driver.findElement(By.xpath("//span[text()='Prev']")).click();
				}

				monthYearDisplayed = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']")).getText();
				System.out.println("Displayed Month and Year in Loop : " + monthYearDisplayed);
			}

			// Select the day from the calendar
			String day = new SimpleDateFormat("d").format(dateYear);
			System.out.println("Supplied Date Day : " + day);

			WebElement calendarDay = driver.findElement(By.xpath("//a[text()='" + day + "']"));
			calendarDay.click();

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void selectAppointmentDate() {
		waitforWebPageToLoad();
		String displayDate = driver.findElement(By.xpath(prop.getProperty("displayDate_xpath"))).getText();
		System.out.println("Display Date : " + displayDate);

		// Add 4 days ahead date in display date
		String appointmentDay = addInDisplayDate(displayDate);

		List<WebElement> allDates = driver.findElements(By.xpath(prop.getProperty("allDates_xapth")));
		boolean isDateSelected = false;
		for (WebElement date : allDates) {
			if (date.getText().equals(appointmentDay)) {
				date.click();
				isDateSelected = true;
			}
		}

		if (!isDateSelected) {
			driver.findElement(By.xpath(prop.getProperty("nextWeek_xpath"))).click();
			List<WebElement> allNewDates = driver.findElements(By.xpath(prop.getProperty("allDates_xapth")));
			for (WebElement date : allNewDates) {
				if (date.getText().equals(appointmentDay)) {
					date.click();
				}
			}
		}
	}

	public String addInDisplayDate(String displayDate) {
		// Display Date format -- Sat, 16 Mar
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM");
		String newDate = null;
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFormat.parse(displayDate));

			// Add 4 days
			calendar.add(Calendar.DAY_OF_MONTH, 5);
			SimpleDateFormat dateFormatNew = new SimpleDateFormat("d");
			newDate = dateFormatNew.format(calendar.getTime());
			System.out.println("New Date : " + newDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}
	
	public void selectfromDropDown(WebElement element, String selecatble) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(selecatble);
	}
	
	
	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

}
