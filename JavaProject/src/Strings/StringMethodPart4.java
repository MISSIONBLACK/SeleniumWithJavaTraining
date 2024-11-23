package Strings;

public class StringMethodPart4 {

	public static void main(String[] args) {

		String text = "India is my country";
		
		System.out.println(text.substring(5));
		
		System.out.println(text.substring(5, 9));
		
		char [] charArray = text.toCharArray();
		
		System.out.println("Main String is : " + text);
		
		for (int i = 0; i < charArray.length; i++) {
			System.out.println(charArray[i]);
		}
		
		System.out.println(text.toLowerCase());
		
		System.out.println(text.toUpperCase());
		
		String text1 = "My name is                ";
		String text2 = "          Akash";
		
		System.out.println(text1+text2);
		System.out.println(text1.trim() + text2);
		System.out.println(text1.trim() + text2.trim());
		
	}

}
