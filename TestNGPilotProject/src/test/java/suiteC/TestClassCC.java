package suiteC;

import org.testng.annotations.Test;

import TestBase.TestBase;

public class TestClassCC extends TestBase {

	// @Parameters("browser2")
	@Test(groups = { "sanity" })
	public void testCC() throws InterruptedException {
		log("Strating TestCC");
		Thread.sleep(2000);
		log("Ending TestCC");
	}

}
