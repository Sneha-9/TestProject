package com.sneha.libraryManagementSystem;

import com.sneha.libraryManagementSystem.database.BookDatabase;
import com.sneha.libraryManagementSystem.database.CardDatabase;
import com.sneha.libraryManagementSystem.database.EntryDatabase;

public class LibraryManagementSystem {
    private final IdGenerator idGenerator;
    private final TimeUtil timeUtil;
    private final EntryDatabase entryDatabase;
    private final CardDatabase cardDatabase;
    private final BookDatabase bookDatabase;
    private final BillGenerationSystem billGenerationSystem;
    private final PaymentService paymentService;

    public LibraryManagementSystem(IdGenerator idGenerator, TimeUtil timeUtil, EntryDatabase entryDatabase, CardDatabase cardDatabase, BookDatabase bookDatabase, BillGenerationSystem billGenerationSystem, PaymentService paymentService) {
        this.idGenerator = idGenerator;
        this.timeUtil = timeUtil;
        this.billGenerationSystem = billGenerationSystem;
        this.entryDatabase = entryDatabase;
        this.cardDatabase = cardDatabase;
        this.paymentService = paymentService;
        this.bookDatabase = bookDatabase;
    }

    Book issueBook(String name, Card card) throws BookNotFoundException, DuplicateCardEntryException {
        Book book = bookDatabase.getBook(name);
        if (book == null) {
            throw new BookNotFoundException();
        }

        Card c = cardDatabase.getCard(card.getId());
        if (c != null && c.getId().equals(card.getId())) {
            throw new DuplicateCardEntryException();
        }

        entryDatabase.addEntry(card.getId(), timeUtil, book.getId());
        cardDatabase.addCards(card);
        bookDatabase.removeBook(book);

        return book;

    }

    public Bill payBill(Bill bill) {
        return paymentService.payBill(bill);
    }

    public Bill generateBill(Book book, EntryDatabase entryDatabase) {
        Bill bill = billGenerationSystem.generateBill(book, entryDatabase);
        return bill;
    }

    Card returnBook(Book book, Bill bill) throws BillNotPaidException, EntryNotFoundException, CardNotFoundException {
        if (!bill.isPaid()) {
            throw new BillNotPaidException();
        }

        Entry entry = entryDatabase.getEntry(book);
        if (entry == null) {
            throw new EntryNotFoundException();
        }

        Card card = cardDatabase.getCard(entry.getCardId());
        if (card == null) {
            throw new CardNotFoundException();
        }

        bookDatabase.addBook(book);
        entryDatabase.removeEntry(book);
        cardDatabase.removeCard(entry.getCardId());

        return card;
    }
}
