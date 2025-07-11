package org.example.bookStore.service;

import org.example.bookStore.model.Book;
import org.example.bookStore.model.PurchaseResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookStoreSystem {
    private Map<String, Book> inventory;

    public BookStoreSystem() {
        this.inventory = new HashMap<>();
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Book store: Added book - " + book.toString());
    }

    public List<Book> removeOutdatedBooks(int currentYear, int maxAge) {
        List<Book> outdatedBooks = inventory.values().stream()
                .filter(book -> book.isOutdated(currentYear, maxAge))
                .collect(Collectors.toList());

        for (Book book : outdatedBooks) {
            inventory.remove(book.getIsbn());
            System.out.println("Book store: Removed outdated book - " + book.toString());
        }
        return outdatedBooks;
    }

    public PurchaseResult buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);
        if (book == null)
            throw new RuntimeException("Book with ISBN " + isbn + " not found in inventory");

        try {
            PurchaseResult result = book.buy(quantity, email, address);
            System.out.println("Quantum book store: Purchase completed. Amount paid: $" + result.getAmount());
            return result;
        } catch (RuntimeException e) {
            System.out.println("Quantum book store: Purchase failed - " + e.getMessage());
            throw e;
        }
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }

    public void listAllBooks() {
        System.out.println("Book store: Current inventory:");
        for (Book book : inventory.values()) {
            System.out.println("  " + book.toString());
        }
    }

    public int getInventorySize() {
        return inventory.size();
    }
}