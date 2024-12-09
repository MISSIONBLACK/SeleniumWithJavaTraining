package runner;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        TestNGRunner testNG = new TestNGRunner(1);
        testNG.createSuite("Manage Stocks", false);
        testNG.addListener("Listeners.testListeners");
        testNG.addTest("Add Stock Test");
        testNG.addTestParameters("action", "addStock");

        // Adding doLogin Test Method
        List<String> includeMethods = new ArrayList<String>();
        includeMethods.add("doLogin");
        testNG.addTestClass("testCaseRediffPortfolio.manageSessionTest", includeMethods);

        // Add SelectPortfolio Method
        includeMethods = new ArrayList<String>();
        includeMethods.add("selectPortfolio");
        testNG.addTestClass("testCaseRediffPortfolio.managePortfolioTest", includeMethods);

        // Add "Add Stock" MethodsMethod
        includeMethods = new ArrayList<String>();
        includeMethods.add("addStockTest");
        includeMethods.add("verifyStockIsPresent");
        includeMethods.add("verifyStockQuantity");
        includeMethods.add("verifyTransactionHistory");
        testNG.addTestClass("testCaseRediffPortfolio.manageStocksTest", includeMethods);
    }
}
