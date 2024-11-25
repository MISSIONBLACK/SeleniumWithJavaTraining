package Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

public class ReadYamlData {

    public static void main(String[] args) throws FileNotFoundException, YamlException {

        String filepath = System.getProperty("user.dir") + "//testData.yaml";
//        System.out.println("File path: " + filepath);

        FileReader file = new FileReader(filepath);
        YamlReader reader = new YamlReader(file);

        Map testData = (Map) reader.read();
        
        List testCases = (List) testData.get("testData");
        System.out.println(testCases);

        Map loginTestData = (Map) testCases.get(0);
        System.out.println(loginTestData.get("testName"));

        List loginTestDataData = (List) loginTestData.get("data");
        System.out.println(loginTestDataData);
        
        
        System.out.println("\nReading All Test Cases:");

        for (Object testCaseObj : testCases) {
            Map<String, Object> testCase = (Map<String, Object>) testCaseObj;

            // Print the name of the current test case
            System.out.println("Test Name: " + testCase.get("testName"));

            // Get the 'data' section for this test case
            List<Map<String, Object>> dataList = (List<Map<String, Object>>) testCase.get("data");

            // Loop through each data entry in the 'data' section
            for (Map<String, Object> dataEntry : dataList) {
                System.out.println("  Data Entry:");

                // Print each key-value pair in the current data entry
                for (Map.Entry<String, Object> entry : dataEntry.entrySet()) {
                    System.out.println("    " + entry.getKey() + ": " + entry.getValue());
                }
            }
        }
    }
}
