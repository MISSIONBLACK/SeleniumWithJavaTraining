package suiteA;

import org.testng.annotations.Test;
import TestBase.TestBase;
import dataProvider.TestDataProvider;

public class TestClassA extends TestBase {

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataProviderSuiteA", groups = { "sanity" })
	public void testA(String arg1, String arg2) throws InterruptedException {
		log("Staring Test A");
		log("UserName -- " + arg1);

		if (!arg1.equals("USERNAME_DEMO")) {
			softAssert("Validation Failure -- " + arg1 + " not Equals to USERNAME_DEMO");
		}

		softAssert.assertEquals(arg1, "USERNAME_DEMO");
		log("Password -- " + arg2);

		if (!arg2.equals("USER_PASSWORD")) {
			softAssert("Validation Failure -- " + arg2 + " not Equals to USER_PASSWORD");
		}

		softAssert.assertEquals(arg2, "USER_PASSWORD");
		Thread.sleep(2000);
		log("Ending TestA");
//		Assert.fail();
//		Assert.assertEquals(arg1, "USERNAME_DEMO");
		softAssert.assertAll();
	}

}
