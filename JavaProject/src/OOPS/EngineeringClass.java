package OOPS;

public class EngineeringClass implements Student{

	
	public void displayName() {
		System.out.println("Hi, We are form Engineering");
	}

	
	public void getStudentNumber() {
		System.out.println("We are 120 Students");
	}

	
	public void getStandard() {
		System.out.println("We are from Computer Science");
	}

	public void getUniversity() {
		System.out.println("University name is : " + Student.university);
	}


	@Override
	public void getInterface() {
		// TODO Auto-generated method stub
		
	}
}