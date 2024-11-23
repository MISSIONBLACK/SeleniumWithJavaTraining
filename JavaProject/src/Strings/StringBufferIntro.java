package Strings;

public class StringBufferIntro {

	public static void main(String[] args) {
		
		String name = "Akash";
		name.concat(" Agarwal");
		
		System.out.println(name);
		
		StringBuffer name1 = new StringBuffer("Akash");
		
		name1.append(" Agarwal");
		
		//name1.insert(4, " Agarwal");
		
		//name1.replace(1,  3, " Agarwal");
		
		//name1.delete(1, 10);
		
		//name1.reverse();
		
		System.out.println(name1);
	}

}
