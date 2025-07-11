package org.example.bookStore.service;

import org.example.bookStore.model.EBook;

public class MailService {
    public static void sendEBook(EBook book, int quantity, String email) {
        System.out.println("Ebook store: Sending " + quantity + " copies of EBook '" +
                book.getTitle() + "' (" + book.getFileType() + ") to: " + email);
    }
}
