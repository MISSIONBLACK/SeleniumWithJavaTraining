/*Create a Java program that performs the following tasks using List and ArrayList:

Create a list of integers.

Add the following integers to the list: 10, 20, 30, 40, and 50.

Print the list.

Remove the integer at index 2.

Print the list again.

Add the integer 25 at index 2.

Print the list.

Find and print the maximum value in the list.

Find and print the sum of all values in the list.

Ensure your program is efficient and uses the appropriate methods for each task. The class should be named Exercise.*/

package ListInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise {

    public static void main(String[] args) {
        // Step 1: Create a list of integers
        List<Integer> list = new ArrayList<>();

        // Step 2: Add the integers 10, 20, 30, 40, and 50 to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // Step 3: Print the list
        System.out.println("Original list: " + list);

        // Step 4: Remove the integer at index 2 (which is 30)
        list.remove(2);

        // Step 5: Print the list again
        System.out.println("After removing element at index 2: " + list);

        // Step 6: Add the integer 25 at index 2
        list.add(2, 25);

        // Step 7: Print the list
        System.out.println("After adding 25 at index 2: " + list);

        // Step 8: Find and print the maximum value in the list
        int max = Collections.max(list);
        System.out.println("Maximum value in the list: " + max);

        // Step 9: Find and print the sum of all values in the list
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        System.out.println("Sum of all values in the list: " + sum);
    }
}

/*
 * Solution Explanation
 * 
 * Creating the List: We use List<Integer> to declare a list of integers and
 * ArrayList<>() to instantiate it. This allows us to use dynamic sizing of the
 * array and list operations.
 * 
 * Adding Integers: The add method is used to add integers to the list. We add
 * the integers 10, 20, 30, 40, and 50 sequentially.
 * 
 * Printing the List: We use System.out.println to print the list to the
 * console.
 * 
 * Removing an Element: The remove method is used to remove the element at a
 * specific index. Here, we remove the element at index 2.
 * 
 * Adding an Element at a Specific Index: The add method with two parameters
 * (index and element) is used to add an element at a specific index. We add the
 * integer 25 at index 2.
 * 
 * Finding the Maximum Value: We define a findMax method that iterates through
 * the list to find the maximum value. We initialize the maximum value with the
 * first element and update it if a larger value is found.
 * 
 * Calculating the Sum: We define a findSum method that iterates through the
 * list to calculate the sum of all elements. We initialize a sum variable to 0
 * and add each element of the list to it.
 */