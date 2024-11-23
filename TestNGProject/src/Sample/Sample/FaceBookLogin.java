package Sample.Sample;

import org.testng.annotations.Test;

public class FaceBookLogin {

	@Test
	public void loginWithValidCredentials() {
		System.out.println("Hi, I aam succesfully login in");
	}
	
	@Test
	public void loginWithInvalidCredentials() {
		System.out.println("Hi, I am not able to log in");
	}
}
