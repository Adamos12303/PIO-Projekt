package app;

import model.*;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=================================");
            System.out.println("    CASINO BLACKJACK - KONSOLA   ");
            System.out.println("=================================");
            System.out.println("1. Graj");
            System.out.println("2. Wyjdź");
            System.out.print("Wybierz opcję (1-2): ");

            String choice = scanner.nextLine().trim();
            if (choice.equals("2")) {
                System.out.println("Dziękujemy za grę. Do widzenia!");
                break;
            } else if (choice.equals("1")) {
                uruchomRozgrywke(scanner);
            } else {
                System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
            }
        }
        scanner.close();
    }

    private static void uruchomRozgrywke(Scanner scanner) {
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        List<AI> aiPlayers = new ArrayList<>();
        aiPlayers.add(new AI("Bot Robert"));
        aiPlayers.add(new AI("Bot Anna"));
        for (AI ai : aiPlayers) {
            ai.getHand().addCard(deck.drawCard());
            ai.getHand().addCard(deck.drawCard());
        }

        playerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());

        System.out.println("--- WITAJ W BLACKJACK ---");
        UI.wyswietlZasady();

        while (playerHand.calculateValue() < 21) {
            System.out.println("\nKrupier pokazuje: [" + dealerHand.getCards().get(0) + "] | Suma pokazanych kart: " + dealerHand.getCards().get(0).getValue());
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
        }
        UI.odczekaj(1500);

        AITurn.przeprowadzTureBotow(aiPlayers, deck);
        int dealerTotal = Dealer.przeprowadzTureKrupiera(dealerHand, deck);

        System.out.println("\n=================================");
        System.out.println("         WYNIKI KOŃCOWE          ");
        System.out.println("=================================");
        UI.odczekaj(1000);
        System.out.print("Gracz (Ty): ");
        UI.wyswietlWynikIndywidualny(playerTotal, dealerTotal);
        UI.odczekaj(800);
        for (AI ai : aiPlayers) {
            System.out.print(ai.getName() + ": ");
            UI.wyswietlWynikIndywidualny(ai.getHand().calculateValue(), dealerTotal);
            UI.odczekaj(800);
        }
        System.out.println("=================================\n");
    }
}