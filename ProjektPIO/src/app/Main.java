package app;

import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        playerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        while (playerHand.calculateValue() < 21) {
            System.out.println("\nKrupier pokazuje: [" + dealerHand.getCards().get(0) + "]");
            System.out.println("Twoje karty: " + playerHand);
            System.out.print("Co robisz? (H = Hit/Dobierz, S = Stand/Pasuj): ");
            String action = scanner.nextLine().trim().toUpperCase();
            if (action.equals("H")) {
                playerHand.addCard(deck.drawCard());
            } else if (action.equals("S")) {
                break;
            }
        }
        int playerTotal = playerHand.calculateValue();
        System.out.println("\nTwoje ostateczne karty: " + playerHand);
        if (playerTotal > 21) {
            System.out.println("Przekroczyłeś 21! Przegrałeś (Bust).");
            return;
        }
        System.out.println("\nTura Krupiera...");
        while (dealerHand.calculateValue() < 17) {
            dealerHand.addCard(deck.drawCard());
        }
        int dealerTotal = dealerHand.calculateValue();
        System.out.println("Karty Krupiera: " + dealerHand);
        if (dealerTotal > 21 || playerTotal > dealerTotal) {
            System.out.println("Wygrałeś!");
        } else if (playerTotal < dealerTotal) {
            System.out.println("Przegrałeś. Krupier wygrywa.");
        } else {
            System.out.println("Remis (Push)!");
        }
    }
}