/*Create a Java program that manages a collection of unique student names. The program should perform the following tasks:

Add names to the collection.

Remove a name from the collection.

Check if a name is in the collection.

Display all names in the collection in the order they were added (using HashSet).

Display all names in the collection in alphabetical order (using TreeSet).

Implement the above functionality in a class named Exercise with the following methods:

addStudent(String name): Adds a student's name to both collections.

removeStudent(String name): Removes a student's name from both collections.

checkStudent(String name): Checks if a student's name is in the collections.

displayStudentsOrderAdded(): Displays all students' names in the order they were added.

displayStudentsAlphabetically(): Displays all students' names in alphabetical order.
*/
package Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Exercise {

    // Using LinkedHashSet to maintain the order of insertion
    private Set<String> studentsOrderAdded = new LinkedHashSet<>();

    // Using TreeSet to maintain the alphabetical order
    private Set<String> studentsAlphabetical = new TreeSet<>();

    // Method to add a student's name to both collections
    public void addStudent(String name) {
        studentsOrderAdded.add(name); // Maintains order of insertion
        studentsAlphabetical.add(name); // Maintains alphabetical order
        System.out.println(name + " has been added.");
    }

    // Method to remove a student's name from both collections
    public void removeStudent(String name) {
        if (studentsOrderAdded.remove(name) && studentsAlphabetical.remove(name)) {
            System.out.println(name + " has been removed.");
        } else {
            System.out.println(name + " was not found in the collection.");
        }
    }

    // Method to check if a student's name is in the collection
    public void checkStudent(String name) {
        if (studentsOrderAdded.contains(name)) {
            System.out.println(name + " is in the collection.");
        } else {
            System.out.println(name + " is not in the collection.");
        }
    }

    // Method to display all students' names in the order they were added
    public void displayStudentsOrderAdded() {
        System.out.println("Students in the order they were added:");
        for (String student : studentsOrderAdded) {
            System.out.println(student);
        }
    }

    // Method to display all students' names in alphabetical order
    public void displayStudentsAlphabetically() {
        System.out.println("Students in alphabetical order:");
        for (String student : studentsAlphabetical) {
            System.out.println(student);
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        Exercise exercise = new Exercise();

        // Adding students
        exercise.addStudent("Alice");
        exercise.addStudent("Bob");
        exercise.addStudent("Charlie");
        exercise.addStudent("Dave");

        // Displaying students in order of addition
        exercise.displayStudentsOrderAdded();

        // Displaying students in alphabetical order
        exercise.displayStudentsAlphabetically();

        // Check if a student is in the collection
        exercise.checkStudent("Alice");
        exercise.checkStudent("Eve");

        // Removing a student
        exercise.removeStudent("Bob");

        // Display the collections after removal
        exercise.displayStudentsOrderAdded();
        exercise.displayStudentsAlphabetically();
    }
}



/*
 * Solution Explanation
 * 
 * Class and Variables:
 * 
 * The class Exercise contains three private member variables: studentHashSet,
 * studentTreeSet, and studentLinkedHashSet.
 * 
 * studentHashSet is used to store unique student names without any particular
 * order.
 * 
 * studentTreeSet automatically sorts the student names in alphabetical order.
 * 
 * studentLinkedHashSet maintains the insertion order of the student names.
 * 
 * Constructor:
 * 
 * The constructor initializes the three sets.
 * 
 * Methods:
 * 
 * addStudent(String name): Adds the given name to all three sets. This ensures
 * that the name is stored uniquely and is available for both order-specific
 * displays.
 * 
 * removeStudent(String name): Removes the given name from all three sets.
 * 
 * checkStudent(String name): Checks if the name exists in the HashSet (could
 * use any set here, as all will have the same elements).
 * 
 * displayStudentsOrderAdded(): Iterates over the LinkedHashSet to display names
 * in the order they were added.
 * 
 * displayStudentsAlphabetically(): Iterates over the TreeSet to display names
 * in alphabetical order.
 * 
 * Main Method:
 * 
 * Demonstrates the functionality by adding, checking, displaying, and removing
 * student names.
 */
