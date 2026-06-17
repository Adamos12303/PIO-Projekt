package service;

import model.Deck;
import model.Hand;

public class Dealer {
    public static int przeprowadzTureKrupiera(Hand dealerHand, Deck deck) {
        System.out.println("\u001B[95m\nTura Krupiera...\u001B[0m");

        while (dealerHand.obliczWartosc() < 17) {
            dealerHand.dodajKarte(deck.dobierzKarty());
        }

        UI.odczekaj(800);
        int dealerTotal = dealerHand.obliczWartosc();
        System.out.println("Karty Krupiera: " + dealerHand);

        if (dealerTotal > 21) {
            System.out.println("Krupier przekroczył 21 punktów!");
        }
        UI.odczekaj(2000);

        return dealerTotal;
    }
}