package org.example.bookStore.model;

import org.example.bookStore.service.ShippingService;

public class PaperBook extends Book{
    private int stock;
    public PaperBook(String isbn, String title, String author, int publisheYear, double price, int stock) {
        super(isbn, title, author, publisheYear, price);
        this.stock = stock;
    }
    @Override
    public PurchaseResult buy(int quantity, String email, String address) {
        if(stock<quantity)
            throw new RuntimeException("Not enough stock available:" + stock + " for " + quantity + " requested");
        stock -= quantity;
        double amount = quantity * price;
        ShippingService.ship(this,quantity,address);
        return new PurchaseResult(amount, "Purchase paper book successfully to: " + email);
    }
    public int getStock() { return stock; }

    @Override
    public String toString() {
        return super.toString() + ", Stock: " + stock + " (Paper Book)";
    }
}
