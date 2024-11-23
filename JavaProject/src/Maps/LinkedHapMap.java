package Maps;

import java.util.LinkedHashMap;

public class LinkedHapMap {

	public static void main(String[] args) {


		LinkedHashMap<String, String> lmap = new LinkedHashMap<>();
		
		lmap.put("Akash", "27");
		lmap.put("John", "47");
		lmap.put("Amit", "26");
		lmap.put("Nitika", "23");
		lmap.put("Julia", "32");
		lmap.put("Akashh", "28");
		
		System.out.println(lmap);

		System.out.println("Size of Map is : " + lmap.size());
		
//		hmap.clear();
		System.out.println("Is Map Empty ? " + lmap.isEmpty());
		
		System.out.println("Is Contains Nitika ? " + lmap.containsKey("Neetika"));
		
		System.out.println("Is Contains 23 ? " + lmap.containsValue(23));
	}

}
