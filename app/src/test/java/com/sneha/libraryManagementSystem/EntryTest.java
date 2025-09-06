package com.sneha.libraryManagementSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class EntryTest {
    TimeUtil timeUtil = mock(TimeUtil.class);

    @Test
    void entryIsCreated(){
        Assertions.assertDoesNotThrow(()-> new Entry(timeUtil,"123"));
    }

    @Test
    void throwsExceptionWhenCardIdIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> new Entry(timeUtil,""));
    }

    @Test
    void throwsExceptionWhenCardIdIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Entry(timeUtil,null));
    }

}