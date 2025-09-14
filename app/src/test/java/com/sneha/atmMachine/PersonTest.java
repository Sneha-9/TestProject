package com.sneha.atmMachine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PersonTest {
    IdGenerator idGenerator = mock(IdGenerator.class);

    @AfterEach
    void mockReset() {
        reset(idGenerator);
    }

    @Test
    void shouldGiveGovernmentId() {
        when(idGenerator.generateId()).thenReturn("random");
        assertEquals("random", new Person(idGenerator).getGovernmentId());
    }

    @Test
    void throwExceptionWhileGeneratingCardId() {
        when(idGenerator.generateId()).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class, () -> new Person(idGenerator));
    }


}