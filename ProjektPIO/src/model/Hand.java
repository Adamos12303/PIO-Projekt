package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>();
    public void dodajKarte(Card card) {
        cards.add(card);
    }
    public List<Card> Karty() {
        return cards;
    }
    public int obliczWartosc() {
        int wartosc = 0;
        int as = 0;
        for (Card card : cards) {
            wartosc += card.getWartosc();
            if (card.getWaga() == Card.Waga.AS) as++;
        }
        while (wartosc > 21 && as > 0) {
            wartosc -= 10;
            as--;
        }
        return wartosc;
    }
    public boolean Rozdzielna() {
        return cards.size() == 2 && cards.get(0).getWartosc() == cards.get(1).getWartosc();
    }
    public Card removeCard(int index) {
        return cards.remove(index);
    }
    @Override
    public String toString() {
        return cards.toString() + " | Suma: " + obliczWartosc();
    }
}