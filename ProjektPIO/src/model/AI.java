package model;

import java.util.Random;

public class AI {
    private final String name;
    private final Hand hand = new Hand();
    private final Random random = new Random();

    public AI(String name) { this.name = name; }
    public Hand getHand() { return hand; }
    public String getName() { return name; }

    public boolean decideHit() {
        int score = hand.calculateValue();
        if (score < 12) return true;
        if (score >= 18) return false;
        int riskChance = switch (score) {
            case 12 -> 85;
            case 13 -> 70;
            case 14 -> 55;
            case 15 -> 40;
            case 16 -> 20;
            case 17 -> 5;
            default -> 0;
        };
        return random.nextInt(100) < riskChance;
    }
}