package com.sneha.libraryManagementSystem;

public class CardNotFoundException extends Exception {
    CardNotFoundException() {
        super("Card not found");
    }
}
