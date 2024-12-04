package testCaseRediffPortfolio;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import testBase.baseTest;

public class managePortfolioTest extends baseTest {

	@Test
	public void createPortfolio(ITestContext context) {
//		JSONObject data = (JSONObject) context.getAttribute("testData");
//		String portfolioName = (String) data.get("portfolioname");
		String portfolioName = "MyPortfolio_999";
		
		app.logInfo("Creating Portfolio :: " + portfolioName);
		app.click("createPortfolio_id");
		app.clear("porfolioname_id");
		app.type("porfolioname_id", portfolioName);
		app.click("createPortfolioButton_id");
		app.waitforWebPageToLoad();
		app.validateSelectedValueInDropDown("portfolio_dropdown_id", portfolioName);
	}

	@Test
	public void deletePortfolio(ITestContext context) {
//		JSONObject data = (JSONObject) context.getAttribute("testData");
//		String portfolioName = (String) data.get("portfolioname");
		String portfolioName = "My Portfolio";
		
		app.logInfo("Deleting Porfolio :: " + portfolioName);
		app.selectByVisibleText("portfolio_dropdown_id", portfolioName);
		app.waitforWebPageToLoad();
		app.click("deletePortfolio_id");
		app.acceptAlert();
		app.waitforWebPageToLoad();
//		app.validateSelectedValueNotInDropDown("portfolio_dropdown_id", portfolioName);
	}
	
	@Test
	public void selectPortfolio(ITestContext context) {
		String portfolioName = "MyPortfolio_999";
		
		app.logInfo("Selecting Portfolio :: " + portfolioName);
		app.selectByVisibleText("portfolio_dropdown_id", portfolioName);
		app.waitforWebPageToLoad();
	}
}