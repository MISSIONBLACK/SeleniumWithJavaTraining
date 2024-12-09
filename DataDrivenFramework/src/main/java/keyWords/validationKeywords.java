package keyWords;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class validationKeywords extends genericKeywords {

	public void SoftAssert() {
		logInfo("SoftAssert");
	}
	
	public void validateTitle(String expectedTitleKey) {
		Assert.assertEquals(driver.getTitle(), prop.getProperty(expectedTitleKey));
	}
	
	public void validateSelectedValueInDropDown(String locatorKey, String value) {
		Select dropdown = new Select(getElement(locatorKey));
		String selectedValue = dropdown.getFirstSelectedOption().getText();
		logInfo("Selected Value in DropDown : " + selectedValue);
		
		if(!selectedValue.equals(value)) {
			reportFailure("Entered "+ value + " is not availble in Portfolio List", true);
		}
	}
	
	public void validateSelectedValueNotInDropDown(String locatorKey, String value) {
		Select dropdown = new Select(getElement(locatorKey));
		String selectedValue = dropdown.getFirstSelectedOption().getText();
		if(selectedValue.equals(value)) {
			reportFailure("Portfolio "+ value + " is  availble in Portfolio List", true);
		}
	}
}
