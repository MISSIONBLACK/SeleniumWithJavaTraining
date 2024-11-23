package ExecutionOrder;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionExample {
	
	@Test (priority=1)
	public void testOne(){
		Assert.assertEquals("FaceBook", "FaceBook");
		System.out.println("Hi, I am Test One .....");
	}

	@Test (priority=2)
	public void testTwo(){
		Assert.assertEquals(404, 200);
		System.out.println("Hi, I am Test Two .....");
	}

	@Test (priority=3)
	public void testThree(){
		Assert.assertTrue(true);
		System.out.println("Hi, I am Test Three .....");
	}

	@Test (priority=4)
	public void testFour(){
		Assert.assertTrue(false, "Making Test Failure");
		System.out.println("Hi, I am Test Four .....");
	}

	@Test (priority=5)
	public void testFive(){
		System.out.println("Hi, I am Test Five .....");
	}

	@Test (priority=6)
	public void testSix(){
		System.out.println("Hi, I am Test Sixs .....");
	}

}
