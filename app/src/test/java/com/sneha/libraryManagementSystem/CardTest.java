package com.sneha.libraryManagementSystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CardTest {
    IdGenerator idGenerator = mock(IdGenerator.class);

    @AfterEach
    void resetMock(){
        reset(idGenerator);
    }

    @Test
    void checkCardIdIsGenerated(){
        when(idGenerator.generateId()).thenReturn("random");
        assertEquals("random", new Card(idGenerator).getId());
    }

    @Test
    void throwsExceptionWhenCardIdIsNotGenerated(){
        when(idGenerator.generateId()).thenThrow(new IllegalArgumentException());
        assertThrows(IllegalArgumentException.class, ()->new Card(idGenerator));
    }


}