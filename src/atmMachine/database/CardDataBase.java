package atmMachine.database;

import atmMachine.Card;

import java.util.ArrayList;
import java.util.List;

public class CardDataBase {

    List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);//return something to indicate success or failure
    }

    public Card validateCard(Card card) {
        for (Card c : cards) {
            if (c.getId().equals(card.getId()))
                return c;
        }
        return null;
    }
}
