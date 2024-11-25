package suiteA;

import org.testng.annotations.Test;

import TestBase.TestBase;
import dataProvider.TestDataProvider;

public class TestClassAA extends TestBase {

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataProviderSuiteA", groups = { "smoke" })
	public void testAA(String arg1, String arg2) throws InterruptedException {
		log("Starting TestAA");
		log("UserName -- " + arg1);
		log("Password -- " + arg2);
		Thread.sleep(2000);
		log("Ending TestAA");
	}

}
