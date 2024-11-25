package suiteC;

import org.testng.annotations.Test;

import TestBase.TestBase;
import dataProvider.TestDataProvider;

public class TestClassC extends TestBase {

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataProviderSuiteC", groups = { "sanity",
			"smoke" })
	public void testC(String arg1, String arg2) throws InterruptedException {
		log("Starting TestC");
		log("UserName -- " + arg1);
		log("Password -- " + arg2);
		Thread.sleep(2000);
		log("Ending TestC");
	}

}
