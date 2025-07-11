package org.example.bookStore.model;

import org.example.bookStore.service.MailService;

public class EBook extends Book{
    private String fileType;

    public EBook(String isbn, String title, String author, int publishYear, double price, String fileType) {
        super(isbn, title, author, publishYear, price);
        this.fileType = fileType;
    }

    @Override
    public PurchaseResult buy(int quantity, String email, String address) {
        double totalAmount = price * quantity;
        MailService.sendEBook(this, quantity, email);
        return new PurchaseResult(totalAmount, "EBook purchase successfully");
    }
    public String getFileType() {
        return fileType;
    }
    @Override
    public String toString() {
        return super.toString() + ", File Type: " + fileType + " (EBook)";
    }
}
