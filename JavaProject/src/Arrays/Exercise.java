/*Create a Java program that performs the following operations on an array of integers:

Initialization: Initialize an array of integers with at least 10 elements.

Print Array: Print the elements of the array.

Reverse Array: Reverse the elements of the array.

Find Maximum and Minimum: Find and print the maximum and minimum elements in the array.

Sum and Average: Calculate and print the sum and average of the elements in the array.

Search Element: Search for a specific element in the array and print its index. If the element is not found, print a message saying it is not found.

Sort Array: Sort the array in ascending order and print the sorted array.*/

package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise {

    // Method to reverse an array
    public static void reverseArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Method to find the maximum element in an array
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Method to find the minimum element in an array
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Method to calculate the sum of elements in an array
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // Method to search for an element in an array
    public static int searchElement(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Return -1 if the element is not found
    }

    public static void main(String[] args) {
        // Initialize an array with at least 10 elements
        int[] array = {12, 5, 7, 9, 23, 19, 1, 17, 3, 10};

        // Print the array
        System.out.println("Original Array: " + Arrays.toString(array));

        // Reverse the array
        reverseArray(array);
        System.out.println("Reversed Array: " + Arrays.toString(array));

        // Find the maximum and minimum elements in the array
        int max = findMax(array);
        int min = findMin(array);
        System.out.println("Maximum Element: " + max);
        System.out.println("Minimum Element: " + min);

        // Calculate and print the sum and average of the elements in the array
        int sum = sumArray(array);
        double average = (double) sum / array.length;
        System.out.println("Sum of Elements: " + sum);
        System.out.println("Average of Elements: " + average);

        // Search for a specific element in the array
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an element to search for: ");
        int element = scanner.nextInt();
        int index = searchElement(array, element);
        if (index != -1) {
            System.out.println("Element " + element + " found at index: " + index);
        } else {
            System.out.println("Element " + element + " is not found in the array.");
        }

        // Sort the array in ascending order
        Arrays.sort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}


/*
 * Solution Explanation
 * 
 * Initialization:
 * 
 * The array numbers is initialized with 10 integer values.
 * 
 * Print Array:
 * 
 * The array is printed using Arrays.toString(numbers).
 * 
 * Reverse Array:
 * 
 * The reverseArray method is used to reverse the elements of the array
 * in-place.
 * 
 * Find Maximum and Minimum:
 * 
 * The findMax method iterates through the array to find the maximum value.
 * 
 * The findMin method iterates through the array to find the minimum value.
 * 
 * Sum and Average:
 * 
 * The calculateSum method calculates the sum of all elements in the array.
 * 
 * The calculateAverage method calculates the average by dividing the sum by the
 * number of elements.
 * 
 * Search Element:
 * 
 * The user is prompted to enter an element to search for.
 * 
 * The searchElement method searches for the specified element and returns its
 * index if found, otherwise returns -1.
 * 
 * Sort Array:
 * 
 * The array is sorted in ascending order using Arrays.sort(numbers).
 */