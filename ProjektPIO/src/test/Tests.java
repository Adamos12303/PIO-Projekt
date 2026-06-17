package test;

import model.*;
import service.UI;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;

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
        assertFalse(ai.czyDobrac(), "AI nigdy nie powinno dobierać przy 18 punktach.");
    }

    @BeforeEach
    public void setUp() {
        UI.resetujLiczbeAI();
    }
    @Test
    public void testDefaultNumberOfAI() {
        assertEquals(0, UI.getliczbaAI(), "Domyślna liczba botów powinna wynosić 0.");
    }

    @Test
    public void testCorrectSetNumberOfAI() {
        String input = "4\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        UI.ustawLiczbeAI(scanner);
        assertEquals(4, UI.getliczbaAI(), "Liczba botów powinna zmienić się na 4.");
    }

    @Test
    public void testSetNumberOfAIInCorrectRadius() {
        String input = "10\n0\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        UI.ustawLiczbeAI(scanner);
        assertEquals(0, UI.getliczbaAI(), "Logika powinna odrzucić 10 i ostatecznie ustawić 0 botów.");
    }

    @Test
    public void testSetNumberOfAIInWithText() {
        String input = "błędny_tekst\n3\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        UI.ustawLiczbeAI(scanner);
        assertEquals(3, UI.getliczbaAI(), "Logika powinna zignorować tekst i ostatecznie ustawić 3 boty.");
    }

    @Test
    public void testMultipleAcesReduction() {
        Hand hand = new Hand();
        hand.dodajKarte(new Card(Card.Symbol.PIK, Card.Waga.AS));    //11
        hand.dodajKarte(new Card(Card.Symbol.KIER, Card.Waga.AS));   //11 -> 22 (redukcja do 12)
        hand.dodajKarte(new Card(Card.Symbol.TREFL, Card.Waga.AS));  //11 -> 23 (redukcja do 13)
        hand.dodajKarte(new Card(Card.Symbol.KARO, Card.Waga.AS));   //11 -> 24 (redukcja do 14)
        assertEquals(14, hand.obliczWartosc(), "Cztery asy powinny dać łączną wartość 14 punktów.");
    }

    @Test
    public void testDeckDepletionReturnsNull() {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            assertNotNull(deck.dobierzKarty());
        }
        assertNull(deck.dobierzKarty(), "Dobranie z pustej talii powinno zwrócić null.");
    }
}