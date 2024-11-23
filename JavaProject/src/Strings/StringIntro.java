package Strings;

public class StringIntro {

	public static void main(String[] args) {
		
		String name = "Akash Agarwal";
		String name1 = "Akash Agarwal";
		String name2 = "akash agarwal";
		
		String country = new String("India");
		String country1 = new String("India");
		
		/*
		 * System.out.println(name);
		 * 
		 * System.out.println(name1);
		 * 
		 * System.out.println(country);
		 * 
		 * System.out.println(country1);
		 */

		/*
		 * System.out.println(name.equals(name1));
		 * System.out.println(name.equals(name2));
		 * 
		 * System.out.println(name.equalsIgnoreCase(name1));
		 * 
		 * System.out.println(country.equals(country1));
		 */
		
		String finalString = name + name1 + name2;
		System.out.println(finalString);
		
		String secString = name.concat(name1).concat(name2);
		System.out.println(secString);
		
		
	}

}
