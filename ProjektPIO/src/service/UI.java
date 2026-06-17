package service;

import java.util.Scanner;

public class UI {
    public static void resetujLiczbeAI() {
        liczbaAI = 0;
    }
    private static int liczbaAI = 0;
    public static int getliczbaAI() {
        return liczbaAI;
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void printKolor(String tekst, String kolor) {
        System.out.println(kolor + tekst + ANSI_RESET);
    }

    public static void odczekaj(int milisekundy) {
        try {
            Thread.sleep(milisekundy);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static String wyswietlMenuGlowne(Scanner scanner) {
        System.out.println("=================================");
        System.out.println("    CASINO BLACKJACK - KONSOLA   ");
        System.out.println("=================================");
        System.out.println("1. Graj");
        System.out.println("2. Ustaw liczbę graczy AI (Aktualnie: " + liczbaAI + ")");
        System.out.println("3. Wyjdź");
        System.out.print("Wybierz opcję (1-3): ");
        return scanner.nextLine().trim();
    }

    public static void wyswietlZasady() {
        printKolor("\n--- ZASADY GRY BLACKJACK ---", ANSI_CYAN);
        printKolor("* Cel: Zdobyć jak najbliżej 21 punktów, ale nie przekroczyć tej liczby.", ANSI_CYAN);
        printKolor("* Karty 2-10 mają swoją wartość nominalną.", ANSI_CYAN);
        printKolor("* Walet, Dama, Król mają wartość 10 punktów.", ANSI_CYAN);
        printKolor("* As liczy się jako 11 lub jako 1 (gdy suma przekracza 21).", ANSI_CYAN);
        printKolor("* Krupier musi dobierać karty, dopóki ma mniej niż 17 punktów.", ANSI_CYAN);
        printKolor("---------------------------------------------", ANSI_CYAN);
    }

    public static void wyswietlWynikIndywidualny(int score, int dealerScore) {
        if (score > 21) {
            printKolor(score + " pkt - Przegrana (Przekroczenie 21)", ANSI_RED);
        } else if (dealerScore > 21) {
            printKolor(score + " pkt - Wygrana (Krupier przekroczył 21)!", ANSI_GREEN);
        } else if (score > dealerScore) {
            printKolor(score + " pkt - Wygrana!", ANSI_GREEN);
        } else if (score < dealerScore) {
            printKolor(score + " pkt - Przegrana z krupierem.", ANSI_RED);
        } else {
            printKolor(score + " pkt - Remis (Push).", ANSI_YELLOW);
        }
    }

    public static void ustawLiczbeAI(Scanner scanner) {
        while (true) {
            System.out.print("Podaj liczbę graczy AI (0-5): ");
            String input = scanner.nextLine().trim();
            try {
                int liczba = Integer.parseInt(input);
                if (liczba >= 0 && liczba <= 5) {
                    liczbaAI = liczba;
                    System.out.println("Liczba graczy AI została ustawiona na: " + liczbaAI);
                    break;
                } else {
                    System.out.println("Błąd: Liczba botów musi mieścić się w przedziale od 0 do 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Błąd: Wprowadź poprawną liczbę całkowitą.");
            }
        }
    }
}