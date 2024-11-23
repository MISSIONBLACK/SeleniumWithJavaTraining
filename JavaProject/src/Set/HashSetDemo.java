package Set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

	public static void main(String[] args) {
		
		HashSet hash = new HashSet<>();
		
		hash.add("Akash");
		hash.add("Agarwal");
		hash.add("from");
		hash.add("Lucknow");
		hash.add("India");
		
		System.out.println(hash);
		
		hash.remove("Lucknow");
		
		System.out.println(hash);
		
		System.out.println("Is Ste contains Akash : " + hash.contains("Akash"));
		
		Iterator i = hash.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		hash.clear();
		
		System.out.println("Hash is : " + hash);

	}

}
