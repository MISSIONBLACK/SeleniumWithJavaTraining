package com.example;

public class StudentDemo {
	
	int rollNumber;
	String name;
	String Standard;
	
	/*
	 * public StudentDemo(int i, String n, String s) { rollNumber = i; name = n;
	 * Standard = s; }
	 */
	
	/*
	 * public StudentDemo(int rollNumber, String name, String Standard) { rollNumber
	 * = rollNumber; name = name; Standard = Standard;
	 }*/
	
	public StudentDemo(int rollNumber, String name, String Standard) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.Standard = Standard;
	}
	
	public void display() {
		System.out.println("Student Roll Number : " + rollNumber + " name is : " + name + " and in class : " + Standard);
	}

	public static void main(String[] args) {
		StudentDemo std = new StudentDemo(10, "Frank", "2nd");
		
		StudentDemo std1 = new StudentDemo(10, "Michael", "5th");
		
		std.display();
		std1.display();
	}

}
