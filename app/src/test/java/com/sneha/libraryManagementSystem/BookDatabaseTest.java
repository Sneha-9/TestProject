package com.sneha.libraryManagementSystem;

import libraryManagementSystem.database.BookDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class BookDatabaseTest {
    IdGenerator idGenerator=mock(IdGenerator.class);


    @AfterEach
    void mockReset(){

        reset(idGenerator);
    }

    @Test
    void shouldAddBook(){
        when(idGenerator.generateId()).thenReturn("random");
        Book mockBook = mock(Book.class);
        List<Book> books = new ArrayList<>();
        BookDatabase bookDatabase = new BookDatabase(books);
        bookDatabase.addBook(mockBook);
        Assertions.assertEquals(1, books.size());
    }

    @Test
    void shouldRemoveBook(){
        when(idGenerator.generateId()).thenReturn("random");
        Book mockBook = mock(Book.class);
        List<Book> books = new ArrayList<>();
        BookDatabase bookDatabase = new BookDatabase(books);
        bookDatabase.addBook(mockBook);
        bookDatabase.removeBook(mockBook);
        Assertions.assertEquals(0, books.size());
    }

    @Test
    void shouldGetBook(){
        when(idGenerator.generateId()).thenReturn("random");
        Book mockBook = mock(Book.class);
        when(mockBook.getName()).thenReturn("ABC");

        List<Book> books = new ArrayList<>();
        BookDatabase bookDatabase = new BookDatabase(books);
        bookDatabase.addBook(mockBook);
        Book book= bookDatabase.getBook(mockBook.getName());
        Assertions.assertEquals(book.getName(),mockBook.getName());
    }

}