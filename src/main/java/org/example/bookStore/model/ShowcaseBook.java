package org.example.bookStore.model;

public class ShowcaseBook extends Book{

    public ShowcaseBook(String isbn, String title, String author, int publishYear) {
        super(isbn, title, author, publishYear, 0.0); // Price is 0 for showcase books
    }

    @Override
    public PurchaseResult buy(int quantity, String email, String address) {
        throw new RuntimeException("Showcase books are not for sale");
    }

    @Override
    public String toString() {
        return super.toString() + " (Showcase/Demo Book - Not for Sale)";
    }
}
