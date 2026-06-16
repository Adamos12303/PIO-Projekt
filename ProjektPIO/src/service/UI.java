package service;

import java.util.Scanner;

public class UI {
    private static int liczbaAI = 0;
    public static int getliczbaAI() {
        return liczbaAI;
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
        System.out.println("\n--- ZASADY GRY BLACKJACK ---");
        System.out.println("* Cel: Zdobyć jak najbliżej 21 punktów, ale nie przekroczyć tej liczby.");
        System.out.println("* Karty 2-10 mają swoją wartość nominalną.");
        System.out.println("* Walet, Dama, Król mają wartość 10 punktów.");
        System.out.println("* As liczy się jako 11 lub jako 1 (gdy suma przekracza 21).");
        System.out.println("* Krupier musi dobierać karty, dopóki ma mniej niż 17 punktów.");
        System.out.println("---------------------------------------------");
    }

    public static void wyswietlWynikIndywidualny(int score, int dealerScore) {
        if (score > 21) {
            System.out.println(score + " pkt - Przegrana (Przekroczenie 21)");
        } else if (dealerScore > 21) {
            System.out.println(score + " pkt - Wygrana (Krupier przekroczył 21)!");
        } else if (score > dealerScore) {
            System.out.println(score + " pkt - Wygrana!");
        } else if (score < dealerScore) {
            System.out.println(score + " pkt - Przegrana z krupierem.");
        } else {
            System.out.println(score + " pkt - Remis (Push).");
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