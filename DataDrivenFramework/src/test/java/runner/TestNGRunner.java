package runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

public class TestNGRunner {

    /*
	 * TestNG -- Object of Complete TestNG XmlSuite -- Single Test Suite
	 * List<XmlSuite> -- List of All Test Suites XmlTest -- Test within the Suite
	 * List<XmlTest> -- All Tests under Single Suite Map<String,String> -- Test
	 * Parameters XmlClass -- Single Test Class List<XmlClass> -- All test Classes
	 * within Single Test Case
     */

    TestNG testNG;
    XmlSuite suite;
    List<XmlSuite> allSuites;
    XmlTest test;
    List<XmlTest> allTests;
    Map<String, String> testParameters;
    // XmlClass testClass;
    List<XmlClass> testClasses;

    public void createSuite(String suiteName, boolean parallelTests) {
        suite = new XmlSuite();
        suite.setName(suiteName);

        if (parallelTests) {
            suite.setParallel(ParallelMode.TESTS);
        }

        allSuites.add(suite);
    }

    public void addTest(String testName) {
        test = new XmlTest(suite);
        test.setName(testName);

        // Initially this will be blank
        testParameters = new HashMap<String, String>();
        testClasses = new ArrayList<XmlClass>();

        test.setParameters(testParameters);
        test.setClasses(testClasses);
    }

    public void addTestParameters(String name, String value) {
        testParameters.put(name, value);
    }

    public void addTestClass(String className, List<String> includeMethodNames) {
        XmlClass testClass = new XmlClass();

        // Add test Methods
        List<XmlInclude> classMethods = new ArrayList<XmlInclude>();

        int priority = 1;
        for (String methodName : includeMethodNames) {
            XmlInclude method = new XmlInclude(methodName, priority);
            classMethods.add(method);
            priority++;
        }

        testClass.setIncludedMethods(classMethods);
        testClasses.add(testClass);
    }

    public void addListener(String listenerFile) {
        suite.addListener(listenerFile);
    }

    public void run() {
        testNG.run();
    }

    public TestNGRunner(int setSuiteThreadPoolSize) {
        testNG = new TestNG();
        allSuites = new ArrayList<XmlSuite>();
        testNG.setXmlSuites(allSuites);
        testNG.setSuiteThreadPoolSize(setSuiteThreadPoolSize);
    }
}
