package service;

public class UI {

    public static void odczekaj(int milisekundy) {
        try {
            Thread.sleep(milisekundy);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
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
}