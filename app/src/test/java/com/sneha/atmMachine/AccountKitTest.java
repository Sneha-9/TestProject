package com.sneha.atmMachine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;

class AccountKitTest {
    IdGenerator idGenerator = mock(IdGenerator.class);

    @AfterEach
    void mockReset() {
        reset(idGenerator);
    }

    @Test
    void shouldGiveAccountId() {
        Card card = mock(Card.class);

        assertEquals("123", new AccountKit(card, "123").accountId());
    }

    @Test
    void shouldThrowExceptionWhenAccountIdIsNull() {
        Card card = mock(Card.class);

        Assertions.assertThrows(IllegalArgumentException.class, () -> new AccountKit(card, null));
    }

    @Test
    void shouldThrowExceptionWhenAccountIdIsEmpty() {
        Card card = mock(Card.class);

        Assertions.assertThrows(IllegalArgumentException.class, () -> new AccountKit(card, ""));
    }


}