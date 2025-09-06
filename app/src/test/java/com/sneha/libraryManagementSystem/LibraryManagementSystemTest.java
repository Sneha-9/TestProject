package com.sneha.libraryManagementSystem;

import libraryManagementSystem.database.BookDatabase;
import libraryManagementSystem.database.CardDatabase;
import libraryManagementSystem.database.EntryDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {
    IdGenerator idGenerator = mock(IdGenerator.class);
    TimeUtil timeUtil = mock(TimeUtil.class);

    @AfterEach
    void resetMocks(){
        reset(idGenerator,timeUtil);
    }

    @Test
    void shouldIssueBook() throws DuplicateCardEntryException, BookNotFoundException {
        Book book=mock(Book.class);
        Card card = mock(Card.class);

        when(card.getId()).thenReturn("123");
        when(book.getName()).thenReturn("ABC");
        when(book.getId()).thenReturn("12");

        CardDatabase cardDatabase =mock(CardDatabase.class);

        EntryDatabase entryDatabase = mock(EntryDatabase.class);

        BookDatabase bookDatabase = mock(BookDatabase.class);
        when(bookDatabase.getBook("ABC")).thenReturn(book);

        BillGenerationSystem billGenerationSystem = mock(BillGenerationSystem.class);
        PaymentService paymentService = mock(PaymentService.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(idGenerator,timeUtil,entryDatabase,cardDatabase,bookDatabase,billGenerationSystem,paymentService);

        Assertions.assertDoesNotThrow(()->libraryManagementSystem.issueBook("ABC",card));
    }

    @Test
    void shouldThrowExceptionWhenBookIsNotFound(){
        Book book=mock(Book.class);
        Card card = mock(Card.class);

        when(card.getId()).thenReturn("123");
        when(book.getName()).thenReturn("ABC");
        when(book.getId()).thenReturn("12");

        CardDatabase cardDatabase =mock(CardDatabase.class);
        cardDatabase.addCards(card);
        EntryDatabase entryDatabase = mock(EntryDatabase.class);
        BookDatabase bookDatabase = mock(BookDatabase.class);


        BillGenerationSystem billGenerationSystem = mock(BillGenerationSystem.class);
        PaymentService paymentService = mock(PaymentService.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(idGenerator,timeUtil,entryDatabase,cardDatabase,bookDatabase,billGenerationSystem,paymentService);

        Assertions.assertThrows(BookNotFoundException.class,()->libraryManagementSystem.issueBook("ABC",card));
    }

    @Test
    void shouldThrowDuplicateCardEntryException(){
        Book book=mock(Book.class);
        Card card = mock(Card.class);

        when(card.getId()).thenReturn("123");
        when(book.getName()).thenReturn("ABC");
        when(book.getId()).thenReturn("12");
        when(idGenerator.generateId()).thenReturn("random");
        CardDatabase cardDatabase =mock(CardDatabase.class);
        when(cardDatabase.getCard("123")).thenReturn(card);

        EntryDatabase entryDatabase = mock(EntryDatabase.class);


        BookDatabase bookDatabase = mock(BookDatabase.class);
      when(bookDatabase.getBook("ABC")).thenReturn(book);

        BillGenerationSystem billGenerationSystem = mock(BillGenerationSystem.class);
        PaymentService paymentService = mock(PaymentService.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(idGenerator,timeUtil,entryDatabase,cardDatabase,bookDatabase,billGenerationSystem,paymentService);

        Assertions.assertThrows(DuplicateCardEntryException.class,()->libraryManagementSystem.issueBook("ABC",card));
    }

    @Test
    void shouldReturnBook(){
        Book book=mock(Book.class);
        Card card = mock(Card.class);
        Entry entry = mock(Entry.class);

        when(entry.getStartTime()).thenReturn(10l);
        when(entry.getCardId()).thenReturn("123");

        when(card.getId()).thenReturn("123");
        when(book.getName()).thenReturn("ABC");
        when(book.getId()).thenReturn("12");
        when(idGenerator.generateId()).thenReturn("random");
        CardDatabase cardDatabase =mock(CardDatabase.class);


        EntryDatabase entryDatabase = mock(EntryDatabase.class);
        BillGenerationSystem billGenerationSystem = mock(BillGenerationSystem.class);
        PaymentService paymentService = mock(PaymentService.class);

        when(entryDatabase.getEntry(book)).thenReturn(entry);
        when(cardDatabase.getCard("123")).thenReturn(card);

        Bill bill =mock(Bill.class);
        when(bill.isPaid()).thenReturn(true);


        BookDatabase bookDatabase = mock(BookDatabase.class);
        when(bookDatabase.getBook("ABC")).thenReturn(book);


        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(idGenerator,timeUtil,entryDatabase,cardDatabase,bookDatabase,billGenerationSystem,paymentService);
        libraryManagementSystem.payBill(bill);
        Assertions.assertDoesNotThrow(()->libraryManagementSystem.returnBook(book,bill));
    }

    @Test
    void throwExceptionWhenBillIsNotPaid(){
        Book book=mock(Book.class);
        Card card = mock(Card.class);
        Entry entry = mock(Entry.class);

        when(entry.getStartTime()).thenReturn(10l);
        when(entry.getCardId()).thenReturn("123");

        when(card.getId()).thenReturn("123");
        when(book.getName()).thenReturn("ABC");
        when(book.getId()).thenReturn("12");
        when(idGenerator.generateId()).thenReturn("random");
        CardDatabase cardDatabase =mock(CardDatabase.class);


        EntryDatabase entryDatabase = mock(EntryDatabase.class);
        BillGenerationSystem billGenerationSystem = mock(BillGenerationSystem.class);
        PaymentService paymentService = mock(PaymentService.class);

        Bill bill =mock(Bill.class);



        BookDatabase bookDatabase = mock(BookDatabase.class);
        when(bookDatabase.getBook("ABC")).thenReturn(book);


        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(idGenerator,timeUtil,entryDatabase,cardDatabase,bookDatabase,billGenerationSystem,paymentService);
        libraryManagementSystem.payBill(bill);
        Assertions.assertThrows(BillNotPaidException.class,()->libraryManagementSystem.returnBook(book,bill));
    }

    @Test
    void shouldThrowExceptionWhenEntryIsNotFound(){
        Book book=mock(Book.class);
        Card card = mock(Card.class);
        Entry entry = mock(Entry.class);

        when(entry.getStartTime()).thenReturn(10l);
        when(entry.getCardId()).thenReturn("123");

        when(card.getId()).thenReturn("123");
        when(book.getName()).thenReturn("ABC");
        when(book.getId()).thenReturn("12");
        when(idGenerator.generateId()).thenReturn("random");
        CardDatabase cardDatabase =mock(CardDatabase.class);


        EntryDatabase entryDatabase = mock(EntryDatabase.class);
        BillGenerationSystem billGenerationSystem = mock(BillGenerationSystem.class);
        PaymentService paymentService = mock(PaymentService.class);




        Bill bill =mock(Bill.class);
        when(bill.isPaid()).thenReturn(true);


        BookDatabase bookDatabase = mock(BookDatabase.class);
        when(bookDatabase.getBook("ABC")).thenReturn(book);


        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(idGenerator,timeUtil,entryDatabase,cardDatabase,bookDatabase,billGenerationSystem,paymentService);
        libraryManagementSystem.payBill(bill);
        Assertions.assertThrows(EntryNotFoundException.class,()->libraryManagementSystem.returnBook(book,bill));
    }

    @Test
    void thowExceptionWhenCardIsNotFound(){
        Book book=mock(Book.class);
        Card card = mock(Card.class);
        Entry entry = mock(Entry.class);

        when(entry.getStartTime()).thenReturn(10l);
        when(entry.getCardId()).thenReturn("123");

        when(card.getId()).thenReturn("123");
        when(book.getName()).thenReturn("ABC");
        when(book.getId()).thenReturn("12");
        when(idGenerator.generateId()).thenReturn("random");
        CardDatabase cardDatabase =mock(CardDatabase.class);


        EntryDatabase entryDatabase = mock(EntryDatabase.class);
        BillGenerationSystem billGenerationSystem = mock(BillGenerationSystem.class);
        PaymentService paymentService = mock(PaymentService.class);

        when(entryDatabase.getEntry(book)).thenReturn(entry);


        Bill bill =mock(Bill.class);
        when(bill.isPaid()).thenReturn(true);


        BookDatabase bookDatabase = mock(BookDatabase.class);
        when(bookDatabase.getBook("ABC")).thenReturn(book);


        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(idGenerator,timeUtil,entryDatabase,cardDatabase,bookDatabase,billGenerationSystem,paymentService);
        libraryManagementSystem.payBill(bill);
        Assertions.assertThrows(CardNotFoundException.class,()->libraryManagementSystem.returnBook(book,bill));
    }

    @Test
    void shouldGenerateBill()
    {
        Book book=mock(Book.class);
        Card card = mock(Card.class);
        Entry entry = mock(Entry.class);

        when(entry.getStartTime()).thenReturn(10l);
        when(entry.getCardId()).thenReturn("123");

        when(card.getId()).thenReturn("123");
        when(book.getName()).thenReturn("ABC");
        when(book.getId()).thenReturn("12");
        when(idGenerator.generateId()).thenReturn("random");
        CardDatabase cardDatabase =mock(CardDatabase.class);


        EntryDatabase entryDatabase = mock(EntryDatabase.class);
        BillGenerationSystem billGenerationSystem = mock(BillGenerationSystem.class);
        PaymentService paymentService = mock(PaymentService.class);

        when(entryDatabase.getEntry(book)).thenReturn(entry);

        Bill bill =mock(Bill.class);

        when(billGenerationSystem.generateBill(book,entryDatabase)).thenReturn(bill);
        BookDatabase bookDatabase = mock(BookDatabase.class);
        when(bookDatabase.getBook("ABC")).thenReturn(book);


        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(idGenerator,timeUtil,entryDatabase,cardDatabase,bookDatabase,billGenerationSystem,paymentService);
        Bill generateBill = libraryManagementSystem.generateBill(book,entryDatabase);

        Assertions.assertNotNull(generateBill);
    }

    @Test
    void shouldReturnPaidBill(){
        Book book=mock(Book.class);
        Card card = mock(Card.class);
        Entry entry = mock(Entry.class);

        when(entry.getStartTime()).thenReturn(10l);
        when(entry.getCardId()).thenReturn("123");

        when(card.getId()).thenReturn("123");
        when(book.getName()).thenReturn("ABC");
        when(book.getId()).thenReturn("12");
        when(idGenerator.generateId()).thenReturn("random");
        CardDatabase cardDatabase =mock(CardDatabase.class);


        EntryDatabase entryDatabase = mock(EntryDatabase.class);
        BillGenerationSystem billGenerationSystem = mock(BillGenerationSystem.class);
        PaymentService paymentService = mock(PaymentService.class);

        when(entryDatabase.getEntry(book)).thenReturn(entry);
        when(cardDatabase.getCard("123")).thenReturn(card);

        Bill bill =mock(Bill.class);
        when(bill.isPaid()).thenReturn(true);


        BookDatabase bookDatabase = mock(BookDatabase.class);
        when(bookDatabase.getBook("ABC")).thenReturn(book);
        when(paymentService.payBill(bill)).thenReturn(bill);

        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(idGenerator,timeUtil,entryDatabase,cardDatabase,bookDatabase,billGenerationSystem,paymentService);

        Assertions.assertNotNull(libraryManagementSystem.payBill(bill));
        assertEquals(true,bill.isPaid());
    }

}