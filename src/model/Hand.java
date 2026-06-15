package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>();
    public void addCard(Card card) {
        cards.add(card);
    }
    public List<Card> getCards() {
        return cards;
    }
    public int calculateValue() {
        int value = 0;
        int aces = 0;
        for (Card card : cards) {
            value += card.getValue();
            if (card.getRank() == Card.Rank.AS) aces++;
        }
        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }
        return value;
    }
    public boolean isSplittable() {
        return cards.size() == 2 && cards.get(0).getValue() == cards.get(1).getValue();
    }
    public Card removeCard(int index) {
        return cards.remove(index);
    }
    @Override
    public String toString() {
        return cards.toString() + " | Suma: " + calculateValue();
    }
}