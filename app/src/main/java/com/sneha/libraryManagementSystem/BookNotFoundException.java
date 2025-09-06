package com.sneha.libraryManagementSystem;

public class BookNotFoundException extends Exception {
    public BookNotFoundException() {
        super("Book Not Found");
    }
}
