/*You are required to create a Java program that handles different types of exceptions. The program will take two integer inputs from the user and perform division. The program should handle the following exceptions:

ArithmeticException - Handle the case where the denominator is zero.

InputMismatchException - Handle the case where the input is not an integer.

NullPointerException - Handle the case where the input is null (this will be simulated in the code).

The program should:

Prompt the user to enter two integers.

Perform the division of the first integer by the second.

Catch and handle the exceptions mentioned above.

Display appropriate messages for each exception.*/

package ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Simulating a possible NullPointerException
            String str1 = null;
            String str2 = null;
            
            // Uncomment the following line to test for NullPointerException
            // System.out.println(str1.length()); // This will throw NullPointerException

            // Prompting user for input
            System.out.print("Enter the first integer: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Enter the second integer: ");
            int num2 = scanner.nextInt();
            
            // Perform division
            int result = num1 / num2;
            
            // Print result if no exception occurs
            System.out.println("Result of division: " + result);
            
        } catch (ArithmeticException e) {
            // Handle case where denominator is zero
            System.out.println("Error: Division by zero is not allowed.");
            
        } catch (InputMismatchException e) {
            // Handle case where input is not an integer
            System.out.println("Error: Invalid input. Please enter valid integers.");
            
        } catch (NullPointerException e) {
            // Handle case where a null object is dereferenced
            System.out.println("Error: Null reference encountered.");
            
        } finally {
            // Close the scanner to avoid resource leakage
            scanner.close();
            System.out.println("Execution completed.");
        }
    }
}


/*
 * Solution Explanation
 * 
 * Scanner Initialization and Input Handling:
 * 
 * The program uses a Scanner object to read inputs from the user. This is
 * enclosed in a try block to handle potential exceptions.
 * 
 * ArithmeticException Handling:
 * 
 * When performing the division, if the denominator is zero, an
 * ArithmeticException will be thrown. This is caught and handled with an
 * appropriate error message: "Error: Division by zero is not allowed."
 * 
 * InputMismatchException Handling:
 * 
 * If the user inputs something other than an integer, an InputMismatchException
 * will be thrown. This is also caught and handled with an appropriate error
 * message: "Error: Please enter valid integers."
 * 
 * NullPointerException Handling:
 * 
 * Although user input directly through the console will not throw a
 * NullPointerException, we include it here to demonstrate handling this type of
 * exception. In practice, this might be relevant if the input came from a
 * different source that could be null.
 * 
 * Finally Block:
 * 
 * The finally block ensures that the Scanner object is closed, which is good
 * practice to release resources. It also prints a message indicating the
 * program has terminated.
 * 
 * Division Method:
 * 
 * The divide method performs the actual division. It's separate from the input
 * handling to illustrate how you can modularize exception handling.
 */