package com.sneha.libraryManagementSystem;

import java.util.Objects;

public class Bill {
    private final String id;
    private final String bookId;
    private final float amount;
    private final String bookName;
    private final long duration;
    private boolean isPaid = false;

    public Bill(IdGenerator idGenerator, String bookId, float amount, String bookName, long duration) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be negative or zero");
        }

        if (bookName == null || bookName.isEmpty()) {
            throw new IllegalArgumentException("Book name cannot be empty or null");
        }

        if (bookId == null || bookId.isEmpty()) {
            throw new IllegalArgumentException("Book Id cannot be empty or null");
        }

        if (duration <= 0) {
            throw new IllegalArgumentException("Duration cannot be negative or zero");
        }

        this.id = idGenerator.generateId();
        this.amount = amount;
        this.bookId = bookId;
        this.bookName = bookName;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void markAsPaid() {
        this.isPaid = true;
    }

    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Float.compare(amount, bill.amount) == 0 && isPaid == bill.isPaid && duration == bill.duration && Objects.equals(id, bill.id) && Objects.equals(bookId, bill.bookId) && Objects.equals(bookName, bill.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, amount, bookName, isPaid, duration);
    }
}
