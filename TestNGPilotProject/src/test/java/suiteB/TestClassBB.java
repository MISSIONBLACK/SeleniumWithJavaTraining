package suiteB;

import org.testng.annotations.Test;

import TestBase.TestBase;
import dataProvider.TestDataProvider;

public class TestClassBB extends TestBase {

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataProviderSuiteB", groups = { "smoke" })
	public void testBB(String arg1, String arg2) throws InterruptedException {
		log("Starting TestBB");
		log("UserName -- " + arg1);
		log("Password -- " + arg2);
		Thread.sleep(2000);
		log("Ending TestBB");
	}

}
