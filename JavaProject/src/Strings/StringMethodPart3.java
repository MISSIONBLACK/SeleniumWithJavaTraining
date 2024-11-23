package Strings;

public class StringMethodPart3 {
	
	public static void main(String[] args) {
		
		String text = "Hello Team";
		String sample = "His name is Akash and he is a good man";
		
		String text1 = text.replace("e", "a");
		String sample2 = sample.replace("is", "was");
		
		System.out.println(text1);
		System.out.println(sample2);
		
		String[] sampletext = sample.split(" ");
		
		System.out.println(sample);
		
		for (int i = 0; i< sampletext.length; i++) {
			System.out.println(sampletext[i]);
		}
		
		System.out.println(sample.startsWith("His"));
	}

}
