package Maps;

import java.util.HashMap;

public class HashMapsDemo {

	public static void main(String[] args) {


		HashMap<String, String> hmap = new HashMap<>();
		
		hmap.put("Akash", "27");
		hmap.put("John", "47");
		hmap.put("Amit", "26");
		hmap.put("Nitika", "23");
		hmap.put("Julia", "32");
		
		System.out.println(hmap);
		
		if(hmap.containsKey("Amit")) {
			System.out.println("Age of Amit is : " + hmap.get("Amit"));
		}
		
		System.out.println("Size of HashMap is : " + hmap.size());
		
//		hmap.clear();
		System.out.println("Is HashMap Empty ? " + hmap.isEmpty());

	}

}
