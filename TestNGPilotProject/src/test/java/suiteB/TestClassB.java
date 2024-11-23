package suiteB;

import org.testng.annotations.Test;

import TestBase.TestBase;
import dataProvider.TestDataProvider;

public class TestClassB extends TestBase {

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataProviderSuiteB", groups = { "sanity" })
	public void testB(String arg1, String arg2) throws InterruptedException {
		log("Starting TestB");
		log("UserName -- " + arg1);
		log("Password -- " + arg2);
		Thread.sleep(2000);
		log("Ending TestB");
	}

}
