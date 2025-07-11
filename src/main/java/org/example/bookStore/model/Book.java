package org.example.bookStore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public abstract class Book {  // Changed from package-private to public
    protected String isbn;
    protected String title;
    protected String author;
    protected int publishYear;
    protected double price;

    public abstract PurchaseResult buy(int quantity, String email, String address);

    // Fixed method signature to match usage
    public boolean isOutdated(int currentYear, int maxAge) {
        return (currentYear - publishYear) > maxAge;
    }

    // Added toString method for better output
    @Override
    public String toString() {
        return String.format("ISBN: %s, Title: %s, Author: %s, Year: %d, Price: $%.2f",
                isbn, title, author, publishYear, price);
    }
}