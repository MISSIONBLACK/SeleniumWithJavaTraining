package com.example;


/*Coding Exercise: Constructors and Static Keyword
Create a Java program for a simple library system that manages books. Implement a class Exercise that keeps track of the total number of books created using static variables and methods. The class should include:

A constructor that initializes the book's title and author.

Static variables to keep track of the total number of books created.

Static methods to get the total number of books.

Instance methods to get the title and author of a book.
*/
public class Exercise1 {
    // Static variable to keep track of the total number of books
    private static int totalBooks = 0;

    // Instance variables for title and author of the book
    private String title;
    private String author;

    // Constructor to initialize the title and author
    public Exercise1(String title, String author) {
        this.title = title;
        this.author = author;
        totalBooks++; // Increment the total number of books each time a book is created
    }

    // Static method to get the total number of books created
    public static int getTotalBooks() {
        return totalBooks;
    }

    // Instance method to get the title of the book
    public String getTitle() {
        return title;
    }

    // Instance method to get the author of the book
    public String getAuthor() {
        return author;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Create a few book objects
        Exercise1 book1 = new Exercise1("The Great Gatsby", "F. Scott Fitzgerald");
        Exercise1 book2 = new Exercise1("1984", "George Orwell");
        Exercise1 book3 = new Exercise1("To Kill a Mockingbird", "Harper Lee");

        // Print book details
        System.out.println("Book 1: " + book1.getTitle() + " by " + book1.getAuthor());
        System.out.println("Book 2: " + book2.getTitle() + " by " + book2.getAuthor());
        System.out.println("Book 3: " + book3.getTitle() + " by " + book3.getAuthor());

        // Print the total number of books created
        System.out.println("Total number of books: " + Exercise1.getTotalBooks());
    }
}


/*
 * Class Definition and Static Variable:
 * 
 * 
 * 
 * The Exercise class is defined with two private instance variables: title and
 * author to store the book's details.
 * 
 * A static variable totalBooks is initialized to 0. This variable will keep
 * track of the total number of Book instances created.
 * 
 * Constructor:
 * 
 * 
 * 
 * The constructor Exercise(String title, String author) takes the book's title
 * and author as parameters.
 * 
 * Inside the constructor, the instance variables title and author are
 * initialized with the provided values.
 * 
 * The static variable totalBooks is incremented by 1 every time a new Book
 * object is created.
 * 
 * Static Method:
 * 
 * 
 * 
 * The static method getTotalBooks() returns the value of totalBooks. Since it's
 * a static method, it can be called without creating an instance of the
 * Exercise class.
 * 
 * Instance Methods:
 * 
 * 
 * 
 * The instance method getTitle() returns the title of the book.
 * 
 * The instance method getAuthor() returns the author of the book.
 * 
 * Main Method:
 * 
 * 
 * 
 * Inside the main method, three Exercise objects are created with different
 * titles and authors.
 * 
 * The details of each book are printed using the instance methods getTitle()
 * and getAuthor().
 * 
 * The total number of books created is printed using the static method
 * getTotalBooks().
 */