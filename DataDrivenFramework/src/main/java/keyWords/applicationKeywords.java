package keyWords;

import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class applicationKeywords extends validationKeywords {

	public applicationKeywords() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Project.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		softAssert = new SoftAssert();
	}

	public void selectDateFromCalendar(String date) {
		logInfo("Selecting the Date :: " + date);

		try {
			// Parse the input date
			SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date utilDate = dFormat.parse(date); // Parse as java.util.Date

			// If java.sql.Date is required (e.g., for DB):
			// java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			// Extract day, month, and year
			String day = new SimpleDateFormat("d").format(utilDate);
			String month = new SimpleDateFormat("MMMM").format(utilDate);
			String year = new SimpleDateFormat("yyyy").format(utilDate);

			String monthYearToBeSelected = month + " " + year;

			// Get the currently displayed month and year in the calendar
			String monthYearDisplayed = getElement("monthyear_css").getText();

			// Navigate to the correct month and year
			while (!monthYearToBeSelected.equals(monthYearDisplayed)) {
				// Compare years to decide navigation direction
				String[] displayedParts = monthYearDisplayed.split(" ");
				String displayedYear = displayedParts[1];

				if (Integer.parseInt(displayedYear) > Integer.parseInt(year)
						|| (displayedParts[0].compareTo(month) > 0 && displayedYear.equals(year))) {
					click("datebackButton_xpath"); // Navigate back
				} else {
					click("dateforwardButton_xpath"); // Navigate forward
				}

				// Update displayed month and year after navigation
				monthYearDisplayed = getElement("monthyear_css").getText();
			}

			// Select the day from the calendar
			WebElement dayElement = driver.findElement(By.xpath("//td[text()='" + day + "']"));

			if (dayElement.isDisplayed()) {
				dayElement.click();
			} else {
				throw new Exception("Day element not found or not clickable for the date: " + date);
			}

		} catch (ParseException e) {
			logError("Invalid date format. Expected format is dd-MM-yyyy. Received: " + date);
			e.printStackTrace();
		} catch (Exception e) {
			logError("Error while selecting the date: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public int getRowNumWithCellData(String locatorKey, String data) {

		WebElement table = getElement(locatorKey);
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int rNum = 0; rNum < rows.size(); rNum++) {
			WebElement row = rows.get(rNum);
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (int cNum = 0; cNum < cells.size(); cNum++) {
				WebElement cell = cells.get(cNum);
				if (!cell.getText().trim().equals(""))
					System.out.println("Cell Data :: " + cell.getText());
				if (cell.getText().contains(data))
					return (rNum);
			}
		}
		return -1; // data is not found
	}

	public int findCurrentStockQuantity(String companyName) {
		int rowNum = getRowNumWithCellData("stockTable_id", companyName);

		if (rowNum == -1) {
			logError("Stock Quantity is 0 as given Stock - " + companyName + " is not present in Stock List");
			return 0;
		}

		String quantity = driver
				.findElement(By.cssSelector("table#stock > tbody > tr:nth-child(" + rowNum + ") >td:nth-child(4)"))
				.getText();
		logInfo(companyName + " :: Stock quality is -- " + quantity);

		return Integer.parseInt(quantity);

	}

	public void openTransactionHistory(String companyName) {
		int rowNum = getRowNumWithCellData("stockTable_id", companyName);

		if (rowNum == -1) {
			logError("Stock not present in list");
		}

		driver.findElement(By.cssSelector("table#stock > tbody > tr:nth-child(" + rowNum + ") >td:nth-child(1)"))
				.click();
		driver.findElement(By.cssSelector("table#stock > tbody > tr:nth-child(" + rowNum + ") input.equityTransaction"))
				.click();
		waitforWebPageToLoad();
	}

	public void goToBuySell(String companyName) {
		int rowNum = getRowNumWithCellData("stockTable_id", companyName);

		if (rowNum == -1) {
			logError("Stock not present in list");
		}

		driver.findElement(By.cssSelector("table#stock > tbody > tr:nth-child(" + rowNum + ") >td:nth-child(1)"))
				.click();
		driver.findElement(By.cssSelector("table#stock > tbody > tr:nth-child(" + rowNum + ") input.buySell")).click();
		waitforWebPageToLoad();
	}
}
