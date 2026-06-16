package test;

import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    public void testAceValueReduction() {
        Hand hand = new Hand();
        hand.dodajKarte(new Card(Card.Symbol.PIK, Card.Waga.AS)); //11
        hand.dodajKarte(new Card(Card.Symbol.KIER, Card.Waga.KROL)); //10
        hand.dodajKarte(new Card(Card.Symbol.TREFL, Card.Waga.PIEC)); //5 -> Razem 26. As musi zmienić się w 1.
        assertEquals(16, hand.obliczWartosc(), "As powinien zredukować się do 1, chroniąc przed fura (bust).");
    }

    @Test
    public void testSplitAvailability() {
        Hand hand = new Hand();
        hand.dodajKarte(new Card(Card.Symbol.PIK, Card.Waga.OSIEM));
        hand.dodajKarte(new Card(Card.Symbol.KIER, Card.Waga.OSIEM));
        assertTrue(hand.Rozdzielna(), "Para ósemek powinna kwalifikować się do splitu.");
    }

    @Test
    public void testAINeverHitsOn18() {
        AI ai = new AI("Bot-Test");
        ai.getHand().dodajKarte(new Card(Card.Symbol.PIK, Card.Waga.KROL));
        ai.getHand().dodajKarte(new Card(Card.Symbol.KIER, Card.Waga.OSIEM)); //Suma 18
        assertFalse(ai.decideHit(), "AI nigdy nie powinno dobierać przy 18 punktach.");
    }
}