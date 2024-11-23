package com.example;

public class ParameterisedConstructor {

	public ParameterisedConstructor() {
		System.out.println("I'm inside constructor");
	}
	
	int rollNumber;
	String name;
	
	public ParameterisedConstructor(int i, String n) {
		rollNumber = i;
		name = n;
	}
	
	public void display() {
		System.out.println("Roll Number is : " + rollNumber  + " and Name is : " + name);
	}
	public static void main(String[] args) {
		ParameterisedConstructor std = new ParameterisedConstructor();
		ParameterisedConstructor std1 = new ParameterisedConstructor(10, "James");
		ParameterisedConstructor std2 = new ParameterisedConstructor(20, "Pualy");
		
		std1.display();
		std2.display();

	}

}
