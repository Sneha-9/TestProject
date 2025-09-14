package com.sneha.atmMachine.database;

import com.sneha.atmMachine.Card;
import com.sneha.atmMachine.IdGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CardDataBaseTest {
    IdGenerator idGenerator = mock(IdGenerator.class);

    @AfterEach
    void mockReset() {
        reset(idGenerator);
    }

    @Test
    void shouldGetCard() {
        Card card = mock(Card.class);
        when(card.getId()).thenReturn("123");
        when(card.getAccountId()).thenReturn("123456");

        CardDataBase cardDataBase = new CardDataBase();
        cardDataBase.addCard(card);
        Assertions.assertEquals(card, cardDataBase.validateCard(card));
    }

    @Test
    void shouldNotGetCard() {
        Card card = mock(Card.class);
        when(card.getId()).thenReturn("123");
        when(card.getAccountId()).thenReturn("123456");

        CardDataBase cardDataBase = new CardDataBase();

        Assertions.assertNull(cardDataBase.validateCard(card));
    }

}