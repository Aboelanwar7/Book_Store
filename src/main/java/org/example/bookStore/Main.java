package org.example.bookStore;

import org.example.bookStore.model.*;
import org.example.bookStore.service.BookStoreSystem;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        BookStoreSystem bookstore = new BookStoreSystem();

        //adding books
        System.out.println("=== Testing Book Addition ===");
        bookstore.addBook(new PaperBook("12345678", "Clean Code", "Robert C. Martin", 2008, 45.99, 10));
        bookstore.addBook(new EBook("1122334455", "Design Patterns", "Gang of Four", 1994, 35.50, "PDF"));
        bookstore.addBook(new ShowcaseBook("987654321", "Domain-Driven Design", "Eric Evans", 2003));
        System.out.println();
        bookstore.listAllBooks();

        //buying books
        System.out.println("\n=== Testing Book Purchases ===");
        try {
            //buy paper book
            PurchaseResult result1 = bookstore.buyBook("12345678", 2, "mohamed@gmail.com", "Toson, Alexandria, Egypt");
            System.out.println("Paper book purchase result: " + result1.getMessage());

            //buy ebook
            PurchaseResult result2 = bookstore.buyBook("1122334455", 1, "mohamed@gmail.com", "Toson, Alexandria, Egypt");
            System.out.println("EBook purchase result: " + result2.getMessage());

            //try to buy showcase book (not for sale)
            try {
                bookstore.buyBook("987654321", 1, "mohamed@gmail.com", "Toson, Alexandria, Egypt");
            } catch (RuntimeException e) {
                System.out.println("expected error for showcase book: " + e.getMessage());
            }

            System.out.println("\n=== Testing Stock Management ===");

            //buy more than available stock
            try {
                bookstore.buyBook("987654321", 10, "mohamed@gmail.com", "Toson, Alexandria, Egypt");
            } catch (RuntimeException e) {
                System.out.println("error for insufficient stock: " + e.getMessage());
            }

            System.out.println("\n=== Testing Non-Existent Book Purchase ===");

            //buy non-existent book
            try {
                bookstore.buyBook("34343221", 1, "mohamed@gmail.com", "Toson, Alexandria, Egypt");
            } catch (RuntimeException e) {
                System.out.println("Expected error for non-existent book: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        //removing outdated books
        System.out.println("\n=== Testing Outdated Book Removal ===");
        System.out.println("Removing books older than 20 years (from 2024)...");
        List<Book> outdatedBooks = bookstore.removeOutdatedBooks(2024, 20);
        System.out.println("Removed " + outdatedBooks.size() + " outdated books");

        System.out.println("\n=== Final Inventory ===");
        bookstore.listAllBooks();
    }
}