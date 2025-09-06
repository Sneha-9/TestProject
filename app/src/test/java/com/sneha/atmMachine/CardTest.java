package com.sneha.atmMachine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CardTest {

    IdGenerator idGenerator = mock(IdGenerator.class);

    @AfterEach
    void mockReset(){
        reset(idGenerator);
    }

    @Test
    void shouldGiveCardId(){
        when(idGenerator.generateId()).thenReturn("random");
        assertEquals("random", new Card(idGenerator,"123").getId());
    }

    @Test
    void throwExceptionWhileGeneratingCardId(){
        when(idGenerator.generateId()).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class,()->new Card(idGenerator,"123"));
    }
    @Test
    void throwExceptionWhenAccountIdIsNull(){
        when(idGenerator.generateId()).thenReturn("random");
        Assertions.assertThrows(IllegalArgumentException.class,()->new Card(idGenerator,null));
    }

    @Test
    void throwExceptionWhenAccountIdISEmpty(){
        when(idGenerator.generateId()).thenReturn("random");
        Assertions.assertThrows(IllegalArgumentException.class,()->new Card(idGenerator,""));
    }

}