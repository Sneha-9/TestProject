package com.sneha.libraryManagementSystem;

import libraryManagementSystem.database.CardDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class CardDatabaseTest {
    IdGenerator idGenerator=mock(IdGenerator.class);


    @AfterEach
    void mockReset(){

        reset(idGenerator);
    }

    @Test
    void shouldAddBook(){
        when(idGenerator.generateId()).thenReturn("random");
        Card mockCard =  mock(Card.class);
        List<Card> cards = new ArrayList<>();
        CardDatabase cardDatabase = new CardDatabase(cards);
        cardDatabase.addCards(mockCard);
        Assertions.assertEquals(1,cards.size());

    }

    @Test
    void shouldRemoveBook(){
        when(idGenerator.generateId()).thenReturn("random");
        Card mockCard =  mock(Card.class);
        List<Card> cards = new ArrayList<>();
        CardDatabase cardDatabase = new CardDatabase(cards);
        cardDatabase.addCards(mockCard);
       Assertions.assertNotNull(cards.size());

        cardDatabase.removeCard(mockCard.getId());
        Assertions.assertEquals(0,cards.size());
    }


}