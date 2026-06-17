package test;

import model.*;
import service.UI;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

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

    @Test
    public void testDefaultLiczbaBotow() {
        assertEquals(0, UI.getliczbaAI(), "Domyślna liczba botów powinna wynosić 0.");
    }

    @Test
    public void testUstawPoprawnaLiczbeBotow() {
        String input = "4\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        UI.ustawLiczbeAI(scanner);
        assertEquals(4, UI.getliczbaAI(), "Liczba botów powinna zmienić się na 4.");
    }

    @Test
    public void testUstawLiczbeBotowZWalidacjaZakresu() {
        String input = "10\n0\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        UI.ustawLiczbeAI(scanner);
        assertEquals(0, UI.getliczbaAI(), "Logika powinna odrzucić 10 i ostatecznie ustawić 0 botów.");
    }

}