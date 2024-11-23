/*Map, HashMap, LinkedHashMap
You are required to implement a program to manage a small book library. Each book has a unique ISBN number, a title, and an author's name. You will use Java's HashMap and LinkedHashMap to perform the following tasks:

Store books using ISBN as the key.

Retrieve a book's details using its ISBN.

Display all books in the order they were added.

Display all books sorted by their titles.

Requirements:

Implement a class Book with attributes ISBN, title, and author.

Implement a class Library with methods to add books, retrieve a book by ISBN, display all books in insertion order, and display all books sorted by titles.

Use HashMap for storing and retrieving books.

Use LinkedHashMap for displaying books in insertion order.

Use any appropriate method for displaying books sorted by titles.*/

package Maps;

import java.util.*;

public class Exercise {

    // Book class to store book details
    static class Book {
        private String ISBN;
        private String title;
        private String author;

        public Book(String ISBN, String title, String author) {
            this.ISBN = ISBN;
            this.title = title;
            this.author = author;
        }

        public String getISBN() {
            return ISBN;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "ISBN: " + ISBN + ", Title: " + title + ", Author: " + author;
        }
    }

    // Library class to manage the collection of books
    static class Library {
        private HashMap<String, Book> bookMap = new HashMap<>();
        private LinkedHashMap<String, Book> booksOrderAdded = new LinkedHashMap<>();

        // Method to add a book to the library
        public void addBook(Book book) {
            bookMap.put(book.getISBN(), book);           // Store in HashMap
            booksOrderAdded.put(book.getISBN(), book);   // Store in LinkedHashMap for order tracking
            System.out.println("Book added: " + book.getTitle());
        }

        // Method to retrieve a book by ISBN
        public Book getBookByISBN(String ISBN) {
            return bookMap.get(ISBN);  // Retrieve book by ISBN from HashMap
        }

        // Method to display all books in the order they were added
        public void displayBooksInOrderAdded() {
            System.out.println("Books in the order they were added:");
            for (Book book : booksOrderAdded.values()) {
                System.out.println(book);
            }
        }

        // Method to display all books sorted by title
        public void displayBooksSortedByTitle() {
            System.out.println("Books sorted by title:");
            List<Book> sortedBooks = new ArrayList<>(bookMap.values());
            sortedBooks.sort(Comparator.comparing(Book::getTitle));  // Sort by title using Comparator
            for (Book book : sortedBooks) {
                System.out.println(book);
            }
        }
    }

    // Main method for testing the functionality
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        Book book1 = new Book("123-456", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("789-101", "Clean Code", "Robert C. Martin");
        Book book3 = new Book("112-131", "Java Concurrency in Practice", "Brian Goetz");
        Book book4 = new Book("415-161", "Design Patterns", "Erich Gamma");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        // Retrieve and display a book by ISBN
        System.out.println("\nRetrieve book with ISBN 123-456:");
        System.out.println(library.getBookByISBN("123-456"));

        // Display all books in the order they were added
        System.out.println("\nDisplaying books in the order they were added:");
        library.displayBooksInOrderAdded();

        // Display all books sorted by title
        System.out.println("\nDisplaying books sorted by title:");
        library.displayBooksSortedByTitle();
    }
}


/*
 * Solution Explanation
 * 
 * Class Book: Represents a book with attributes ISBN, title, and author. It
 * includes a constructor to initialize these attributes and a toString method
 * to display book details.
 * 
 * Class Library:
 * 
 * Uses a HashMap (bookMap) to store and retrieve books by ISBN.
 * 
 * Uses a LinkedHashMap (insertionOrderBooks) to maintain the insertion order of
 * books.
 * 
 * addBook method: Adds a book to both HashMap and LinkedHashMap.
 * 
 * getBookByIsbn method: Retrieves a book by its ISBN from the HashMap.
 * 
 * displayBooksInInsertionOrder method: Displays all books in the order they
 * were added using LinkedHashMap.
 * 
 * displayBooksSortedByTitle method: Displays all books sorted by their titles
 * using a sorted ArrayList.
 * 
 * Class Exercise: The main class to demonstrate the functionality. It creates
 * instances of Book and adds them to the Library. It then retrieves a book by
 * ISBN, displays all books in insertion order, and displays all books sorted by
 * title.
 */