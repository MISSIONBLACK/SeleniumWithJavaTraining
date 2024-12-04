package testCaseRediffPortfolio;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testBase.baseTest;

public class manageStocksTest extends baseTest {

	@Test
	public void addStockTest() {
//		JSONObject data = (JSONObject) context.getAttribute("testData");
//		String companyName = (String) data.get("companyName");
//		String stockQuantity = (String) data.get("stockQuantity");
//		String stockPrice = (String) data.get("stockPrice");
//		String selectionDate = (String) data.get("selectionDate");

		String companyName = "YES Bank";
		String selectionDate = "01-12-2024";
		String stockQuantity = "200";
		String stockPrice = "100";

		app.logInfo("Selecting Stocks in Portfolio");

//		int quantityBeforeSelling = app.findCurrentStockQuantity(companyName);
//		context.setAttribute("quantityBeforeSelling", quantityBeforeSelling);

		app.click("addStock_id");
		app.type("addstockname_id", companyName);
		app.wait(2);
		app.clickEnterKey("addstockname_id");
		app.click("stockPurchaseDate_id");
		app.selectDateFromCalendar(selectionDate);
		app.type("addstockqty_id", stockQuantity);
		app.type("addstockprice_id", stockPrice);
		app.click("addStockButton_id");
		app.waitforWebPageToLoad();

		app.logInfo("Stock Added Successfully....");

	}

	@Test
	public void verifyStockIsPresent() {
//		JSONObject data = (JSONObject) context.getAttribute("testData");
//		String companyName = (String) data.get("companyName");
		String companyName = "YES Bank";

		app.logInfo("Verifying Added Stock in Portfolio...");
		int rowNum = app.getRowNumWithCellData("stockTable_id", companyName);

		if (rowNum == -1) {
			app.reportFailure(companyName + " is not present in Stock List!!! ", true);
		}
		app.logInfo(companyName + " -- Found in Portfolio Stocks");
	}

	@Parameters({ "action" })
	@Test
	public void verifyStockQuantity(String action, ITestContext context) {
//		JSONObject data = (JSONObject) context.getAttribute("testData");
//		String companyName = (String) data.get("companyName");
//		int modifiedQuantity = Integer.parseInt((String) data.get("stockQuantity"));
		int expectedModifiedQuantity = 0;
		String companyName = "YES Bank";
		int modifiedQuantity = 0;

		app.logInfo("Verify Stock Quantity After Action :: " + action);
		int quantity = app.findCurrentStockQuantity(companyName);

		int quantityBeforeSelling = (int) context.getAttribute("quantityBeforeSelling");

		if (action.equals("sellStock")) {
			expectedModifiedQuantity = quantityBeforeSelling - quantity;
		} else if (action.equals("addStock")) {
			expectedModifiedQuantity = quantity - quantityBeforeSelling;
		}

		app.logInfo("Earlier Stock Quantity : " + quantityBeforeSelling);
		app.logInfo("New Stock Quantity : " + quantity);

		if (expectedModifiedQuantity != modifiedQuantity) {
			app.reportFailure("Expected Modified Quantity is not matching", true);
		}

		app.logInfo("Stock Quantity Changed as per expected :: " + expectedModifiedQuantity);
	}

	@Parameters({ "action" })
	@Test
	public void verifyTransactionHistory(String action, ITestContext context) {
		String companyName = "YES Bank";

		app.logInfo("Verify Stock Transaction History after operation :: " + action);
		app.openTransactionHistory(companyName);
		String quantityDisplayed = app.getText("transactionTable_xpath");

		if (action.equals("sellStock")) {
			quantityDisplayed = "-" + quantityDisplayed;
		}
		app.logInfo("Latest Change in Stock : " + companyName + " is :: " + quantityDisplayed);
	}

	@Test
	public void modifyStock(ITestContext context) {
		String companyName = "YES Bank";
		String selectionDate = "02-12-2024";
		String stockQuantity = "100";
		String stockPrice = "150";

		app.logInfo("Selling Quantity : " + stockQuantity + " of Stock :: " + companyName);

		int quantityBeforeSelling = app.findCurrentStockQuantity(companyName);
		context.setAttribute("quantityBeforeSelling", quantityBeforeSelling);

		app.goToBuySell(companyName);
		app.selectByVisibleText("equityAction_id", "Sell");
		app.click("buySellCalendar_id");
		app.selectDateFromCalendar(selectionDate);
		app.type("buysellqty_id", stockQuantity);
		app.type("buysellprice_id", stockPrice);
		app.click("buySellStockButton_id");
		app.waitforWebPageToLoad();
		app.logInfo("Stock :: " + companyName + " Sold Successfully...");
	}
}