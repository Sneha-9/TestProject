package com.sneha.libraryManagementSystem;


import com.sneha.libraryManagementSystem.database.EntryDatabase;

public class BillGenerationSystem {
    private static final int RATE = 10;
    private final TimeUtil timeUtil;
    private final IdGenerator idGenerator;

    public BillGenerationSystem(IdGenerator idGenerator, TimeUtil timeUtil) {
        this.timeUtil = timeUtil;
        this.idGenerator = idGenerator;
    }

    public Bill generateBill(Book book, EntryDatabase entryDatabase) {
        long duration = timeUtil.getCurrentTime() - entryDatabase.getEntry(book).getStartTime();

        float amount = duration * RATE;

        Bill bill = new Bill(idGenerator, book.getId(), amount, book.getName(), duration);

        return bill;
    }


}
