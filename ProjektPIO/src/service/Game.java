package service;

import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void uruchom(Scanner scanner) {
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        List<AI> aiPlayers = new ArrayList<>();
        for (int i = 1; i <= UI.getliczbaAI(); i++) {
            aiPlayers.add(new AI("Bot " + i));
        }

        for (AI ai : aiPlayers) {
            ai.getHand().dodajKarte(deck.dobierzKarty());
            ai.getHand().dodajKarte(deck.dobierzKarty());
        }
        playerHand.dodajKarte(deck.dobierzKarty());
        playerHand.dodajKarte(deck.dobierzKarty());
        dealerHand.dodajKarte(deck.dobierzKarty());

        System.out.println("--- WITAJ W BLACKJACK ---");
        UI.wyswietlZasady();
        while (playerHand.obliczWartosc() < 21) {
            System.out.println("\nKrupier pokazuje: [" + dealerHand.Karty().get(0) + "] | Suma pokazanych kart: " + dealerHand.Karty().get(0).getWartosc());
            System.out.println("Twoje karty: " + playerHand);
            System.out.print("\u001B[93mCo robisz? (H = Hit/Dobierz, S = Stand/Pasuj): \u001B[0m");
            String action = scanner.nextLine().trim().toUpperCase();
            if (action.equals("H")) {
                playerHand.dodajKarte(deck.dobierzKarty());
            } else if (action.equals("S")) {
                break;
            }
        }

        int playerTotal = playerHand.obliczWartosc();
        System.out.println("\nTwoje ostateczne karty: " + playerHand);
        if (playerTotal > 21) {
            System.out.println("\u001B[31mPrzekroczyłeś 21! Przegrałeś (Bust).\u001B[0m");
        }
        UI.odczekaj(1500);

        if (!aiPlayers.isEmpty()) {
            AITurn.przeprowadzTureBotow(aiPlayers, deck);
        }

        int dealerTotal = Dealer.przeprowadzTureKrupiera(dealerHand, deck);

        System.out.println("\n=================================");
        System.out.println("         WYNIKI KOŃCOWE          ");
        System.out.println("=================================");
        UI.odczekaj(1000);

        System.out.print("Gracz (Ty): ");
        UI.wyswietlWynikIndywidualny(playerTotal, dealerTotal);
        UI.odczekaj(800);

        for (AI ai : aiPlayers) {
            System.out.print(ai.getNazwa() + ": ");
            UI.wyswietlWynikIndywidualny(ai.getHand().obliczWartosc(), dealerTotal);
            UI.odczekaj(800);
        }
        System.out.println("=================================\n");
    }
}