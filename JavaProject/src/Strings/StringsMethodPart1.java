package Strings;

public class StringsMethodPart1 {
	
	public static void main(String[] args) {
		String text = "Learning is the key";
		
		String text1 = "Hi we are learning from easybix.com";
		
		char ch = text.charAt(12);
		
		/*
		 * System.out.println(text.charAt(5));
		 * 
		 * System.out.println(ch);
		 * 
		 * System.out.println(text.charAt(50));
		 * 
		 * String text2 =
		 * text.concat(" to success").concat(" and we are learning Java");
		 * System.out.println(text2);
		 * 
		 * System.out.println(text.contains("Key"));
		 */
		
		System.out.println("Message ending with .com : " + text1.endsWith(".com"));
	}
	

}
