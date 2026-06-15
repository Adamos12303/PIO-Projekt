package app;

import model.*;
import java.util.Scanner;

public class Main {
    private static void wyswietlZasady() {
        System.out.println("\n--- ZASADY GRY BLACKJACK ---");
        System.out.println("* Cel: Zdobyć jak najbliżej 21 punktów, ale nie przekroczyć tej liczby.");
        System.out.println("* Karty 2-10 mają swoją wartość nominalną.");
        System.out.println("* Walet, Dama, Król mają wartość 10 punktów.");
        System.out.println("* As liczy się jako 11 lub jako 1 (gdy suma przekracza 21).");
        System.out.println("* Krupier musi dobierać karty, dopóki ma mniej niż 17 punktów.");
        System.out.println("---------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        playerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());

        System.out.println("--- WITAJ W BLACKJACK ---");
        wyswietlZasady();
        while (playerHand.calculateValue() < 21) {
            System.out.println("\nKrupier pokazuje: [" + dealerHand.getCards().get(0) + "] | Suma pokazanych kart: " + dealerHand.getCards().get(0).getValue());
            System.out.println("Twoje karty: " + playerHand);
            System.out.print("Co robisz? (H = Hit/Dobierz, S = Stand/Pasuj): ");

            String action = scanner.nextLine().trim().toUpperCase();
            if (action.equals("H")) { playerHand.addCard(deck.drawCard()); }
            else if (action.equals("S")) { break; }
        }

        int playerTotal = playerHand.calculateValue();
        System.out.println("\nTwoje ostateczne karty: " + playerHand);
        if (playerTotal > 21) {
            System.out.println("Przekroczyłeś 21! Przegrałeś (Bust).");
            return;
        }

        System.out.println("\nTura Krupiera...");
        while (dealerHand.calculateValue() < 17) { dealerHand.addCard(deck.drawCard()); }

        int dealerTotal = dealerHand.calculateValue();
        System.out.println("Karty Krupiera: " + dealerHand);
        if (dealerTotal > 21 || playerTotal > dealerTotal) { System.out.println("Wygrałeś!"); }
        else if (playerTotal < dealerTotal) { System.out.println("Przegrałeś. Krupier wygrywa."); }
        else { System.out.println("Remis (Push)!"); }
    }
}