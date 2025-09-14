package com.sneha.libraryManagementSystem.database;

import com.sneha.libraryManagementSystem.Card;

import java.util.List;

public class CardDatabase {
    private final List<Card> cards;

    public CardDatabase(List<Card> cards) {
        this.cards = cards;
    }

    public void addCards(Card card) {
        cards.add(card);
    }

    public void removeCard(String cardId) {
        for (Card card : cards) {
            if (card.getId().equals(cardId)) {
                cards.remove(card);
            }
        }
    }

    public Card getCard(String cardId) {
        for (Card card : cards) {
            if (card.getId().equals(cardId)) {
                return card;
            }
        }
        return null;
    }


}
