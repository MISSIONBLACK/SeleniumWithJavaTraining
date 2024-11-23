package OOPS;

public class AbstractClass extends AbstractClassAndMethod{

	public void displayShape() {
		
		System.out.println("Shape is Circle");
	}

	public static void main(String[] args) {
		
		AbstractClassAndMethod s = new AbstractClass();
		AbstractClassAndMethod s1 = new AbstractMethod();
		
		s.displayShape();
		s1.displayShape();
		s.displayName();
		s.displayName();

	}

}
