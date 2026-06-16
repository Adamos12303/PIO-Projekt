package test;

import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    public void testAceValueReduction() {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.Suit.PIK, Card.Rank.AS)); //11
        hand.addCard(new Card(Card.Suit.KIER, Card.Rank.KROL)); //10
        hand.addCard(new Card(Card.Suit.TREFL, Card.Rank.PIEC)); //5 -> Razem 26. As musi zmienić się w 1.
        assertEquals(16, hand.calculateValue(), "As powinien zredukować się do 1, chroniąc przed fura (bust).");
    }

    @Test
    public void testSplitAvailability() {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.Suit.PIK, Card.Rank.OSIEM));
        hand.addCard(new Card(Card.Suit.KIER, Card.Rank.OSIEM));
        assertTrue(hand.isSplittable(), "Para ósemek powinna kwalifikować się do splitu.");
    }

    @Test
    public void testAINeverHitsOn18() {
        AI ai = new AI("Bot-Test");
        ai.getHand().addCard(new Card(Card.Suit.PIK, Card.Rank.KROL));
        ai.getHand().addCard(new Card(Card.Suit.KIER, Card.Rank.OSIEM)); //Suma 18
        assertFalse(ai.decideHit(), "AI nigdy nie powinno dobierać przy 18 punktach.");
    }
}