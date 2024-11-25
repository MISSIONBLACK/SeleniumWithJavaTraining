package dataProvider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

// Seperate Data Providers for Each Test Suite
// External Data Source -- JSON, Excel, YAML,XML, TXT

public class TestDataProvider {

	@DataProvider
	public static Object[][] dataProviderSuiteA(Method method) {
		// Separate Data for Each Test
		System.out.println("Test Method name -- " + method.getName());

		Object data[][] = null;
		if (method.getName().toUpperCase().equals("TESTA")) {
			data = new Object[2][2];

			data[0][0] = "UserName 1";
			data[0][1] = "Password 1";

			data[1][0] = "UserName 2";
			data[1][1] = "Password 2";
		} else if (method.getName().toUpperCase().equals("TESTAA")) {
			data = new Object[2][2];

			data[0][0] = "UserName 3";
			data[0][1] = "Password 3";

			data[1][0] = "UserName 4";
			data[1][1] = "Password 4";
		}

		return data;
	}

	@DataProvider
	public static Object[][] dataProviderSuiteB(Method method) {
		// Separate Data for Each Test
		System.out.println("Test Method name -- " + method.getName());

		Object data[][] = null;
		if (method.getName().toUpperCase().equals("TESTB")) {
			data = new Object[2][2];

			data[0][0] = "UserName 5";
			data[0][1] = "Password 5";

			data[1][0] = "UserName 6";
			data[1][1] = "Password 6";
		} else if (method.getName().toUpperCase().equals("TESTBB")) {
			data = new Object[2][2];

			data[0][0] = "UserName 7";
			data[0][1] = "Password 7";

			data[1][0] = "UserName 8";
			data[1][1] = "Password 8";
		}

		return data;
	}

	@DataProvider
	public static Object[][] dataProviderSuiteC(Method method) {
		// Separate Data for Each Test
		System.out.println("Test Method name -- " + method.getName());

		Object data[][] = null;
		if (method.getName().toUpperCase().equals("TESTC")) {
			data = new Object[2][2];

			data[0][0] = "UserName 9";
			data[0][1] = "Password 9";

			data[1][0] = "UserName 10";
			data[1][1] = "Password 10";
		}

		return data;
	}
}
