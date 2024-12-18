package Utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJSONFileDemo {

	public static void main(String[] args) {
		
		JSONObject student1 = new JSONObject();
		student1.put("StudentName", "John");
		student1.put("Grade", "5th");
		student1.put("Location", "14th Avenue");
		
		System.out.println(student1.toJSONString());
		
		JSONObject student2 = new JSONObject();
		student2.put("StudentName", "Anna");
		student2.put("Grade", "6th");
		student2.put("Location", "15th Avenue");
		
		System.out.println(student2.toJSONString());
		
		JSONArray studentDetails = new JSONArray();
		
		studentDetails.add(student1);
		studentDetails.add(student2);
		
		System.out.println(studentDetails.toJSONString());
		
		JSONObject details = new JSONObject();
		details.put("studentDetails", studentDetails);
		
		System.out.println(details.toJSONString());
		
		

	}

}
