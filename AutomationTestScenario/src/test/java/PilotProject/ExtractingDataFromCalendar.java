package PilotProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.Test;

public class ExtractingDataFromCalendar {

	@Test
	public void calendarTest() throws ParseException {
		/*
		 * Date Formats: dd-MM-yyyy -- e.g., 11-04-2024 dd-MMM-yyyy -- e.g., 11-Apr-2024
		 * dd-MMMM-yyyy -- e.g., 11-April-2024
		 */

		// Format and get the current date
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date currentDate = new Date();
		String currentD = dateFormat.format(currentDate);
		System.out.println("Current Date :: " + currentD);

		// Extract the Date
		String day = new SimpleDateFormat("dd").format(currentDate);
		System.out.println("Current Day :: " + day);

		// Extract Month in various formats
		String monthNumeric = new SimpleDateFormat("MM").format(currentDate);
		System.out.println("Current Month (Numeric) :: " + monthNumeric);

		String monthString = new SimpleDateFormat("MMM").format(currentDate);
		System.out.println("Current Month (Short Name) :: " + monthString);

		String monthFullName = new SimpleDateFormat("MMMM").format(currentDate);
		System.out.println("Current Month (Full Name) :: " + monthFullName);

		// Extract Year
		String year = new SimpleDateFormat("yyyy").format(currentDate);
		System.out.println("Current Year :: " + year);

		// Parse and compare a supplied date
		String dob = "08-06-1998";
		Date suppliedDate = dateFormat.parse(dob);

		// Compare dates and print results
		if (currentDate.compareTo(suppliedDate) > 0) {
			System.out.println("The current date is after the supplied date (" + dob + ").");
		} else if (currentDate.compareTo(suppliedDate) < 0) {
			System.out.println("The current date is before the supplied date (" + dob + ").");
		} else {
			System.out.println("The current date is equal to the supplied date (" + dob + ").");
		}
	}
}
