package OOPS;

public class BMW extends Cars{
	
	BMW(){
		super();
		System.out.println("Calling BMW Constructor");
	}
	
	String name = "BMW";
	
	public void getName() {
		System.out.println(name);
		System.out.println(super.name);
	}
	
	public void run() {
		System.out.println("BMW is running");
		super.run();
		
	}

	public static void main(String[] args) {
		
		BMW bmw = new BMW();
		bmw.getName();
		bmw.run();
		
		/*
		 * Cars car = new Cars(); System.out.println(name); car.run();
		 */
		
		

	}

}
