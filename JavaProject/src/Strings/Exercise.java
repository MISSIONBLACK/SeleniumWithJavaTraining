/*Create a Java class named Exercise that includes a method called reverseWords. This method should take a single string as input and return a new string where the order of the words is reversed. Each word is defined as a sequence of non-space characters. You must preserve the original whitespace between words, and the output string should not have leading or trailing spaces.

Example:

Input: "The quick brown fox jumps over the lazy dog"

Output: "dog lazy the over jumps fox brown quick The"

Requirements:

You must not use any additional libraries other than the standard Java library.

The input string can have multiple spaces between words.

The input string can be empty or contain only whitespace.

The output string should not have leading or trailing spaces.*/

package Strings;

public class Exercise {

    // Method to reverse the order of words in a string
    public static String reverseWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }

        // Split the input string into words using one or more spaces as a delimiter
        String[] words = input.trim().split("\\s+");

        // Reverse the order of the words
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");  // Append a space after every word except the last one
            }
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        // Test the reverseWords method
        String input = "The quick brown fox jumps over the lazy dog";
        String output = reverseWords(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}


/*
 * Solution Explanation
 * 
 * Check for null or empty input:
 * 
 * The method first checks if the input is null or contains only whitespace by
 * using input == null || input.trim().isEmpty(). If either condition is true,
 * it returns the input as is because there's nothing to reverse.
 * 
 * Split the input string into words:
 * 
 * The input string is split into an array of words using input.split("\\s+").
 * The regular expression \\s+ matches one or more whitespace characters,
 * ensuring that multiple spaces between words are handled correctly.
 * 
 * Reverse the order of words:
 * 
 * A StringBuilder is used to construct the reversed string. A for loop iterates
 * over the array of words from the last element to the first. Each word is
 * appended to the StringBuilder.
 * 
 * Preserve the spaces between words:
 * 
 * Inside the loop, after appending a word, a single space is appended unless it
 * is the last word (i.e., i != 0). This ensures there are no trailing spaces in
 * the resulting string.
 * 
 * Return the result:
 * 
 * Finally, the reversed string is converted back to a String using the
 * toString() method of the StringBuilder and returned as the result.
 */