package service;

import model.AI;
import model.Card;
import model.Deck;
import java.util.List;

public class AITurn {
    public static void przeprowadzTureBotow(List<AI> aiPlayers, Deck deck) {
        System.out.println("\n=== TURA PRZECIWNIKÓW AI ===");

        for (AI ai : aiPlayers) {
            System.out.println("\nRuch wykonuje: " + ai.getName());
            UI.odczekaj(1000);

            while (ai.getHand().obliczWartosc() < 21) {
                UI.odczekaj(1200);
                if (ai.decideHit()) {
                    Card drawn = deck.dobierzKarty();
                    ai.getHand().dodajKarte(drawn);
                    System.out.println(ai.getName() + " dobiera: " + drawn);
                    UI.odczekaj(1000);
                } else {
                    System.out.println(ai.getName() + " pasuje.");
                    UI.odczekaj(1000);
                    break;
                }
            }
            System.out.println("Ostateczny układ " + ai.getName() + ": " + ai.getHand());
            UI.odczekaj(1500);
        }
    }
}