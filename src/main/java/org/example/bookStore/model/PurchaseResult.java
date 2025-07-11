package org.example.bookStore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PurchaseResult {
    private double amount;
    private String message;
}
