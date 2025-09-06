package com.sneha.libraryManagementSystem.database;

import com.sneha.libraryManagementSystem.Book;

import java.util.List;

public class BookDatabase {
    private List<Book> books;

    public BookDatabase(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book getBook(String name) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                return books.get(i);
            }
        }
        return null;
    }
}
