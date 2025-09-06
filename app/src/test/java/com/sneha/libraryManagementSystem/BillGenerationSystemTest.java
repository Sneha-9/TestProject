package com.sneha.libraryManagementSystem;

import libraryManagementSystem.database.EntryDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BillGenerationSystemTest {
    IdGenerator idGenerator = mock(IdGenerator.class);

    TimeUtil timeUtil = mock(TimeUtil.class);

    @AfterEach
    void resetMock(){
        reset(idGenerator, timeUtil);
    }

    @Test
    void shouldCreateBill(){
        when(idGenerator.generateId()).thenReturn("random");
        when(timeUtil.getCurrentTime()).thenReturn(20L);

        Book mockBook=mock(Book.class);
        when(mockBook.getName()).thenReturn("ABC");
        when(mockBook.getId()).thenReturn("123");

        Entry entry=mock(Entry.class);

        EntryDatabase entryDatabase = mock(EntryDatabase.class);
        when(entryDatabase.getEntry(mockBook)).thenReturn(entry);


        Assertions.assertNotNull(new BillGenerationSystem(idGenerator,timeUtil).generateBill(mockBook,entryDatabase));


    }


}