package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();
    public Deck() {
        for (Card.Symbol symbol : Card.Symbol.values()) { for (Card.Waga waga : Card.Waga.values()) { cards.add(new Card(symbol, waga)); } }
        shuffle();
    }

    public void shuffle() { Collections.shuffle(cards); }

    public Card dobierzKarty() {
        if (cards.isEmpty()) { return null; }
        return cards.remove(cards.size() - 1);
    }
}