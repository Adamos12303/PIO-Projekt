package model;

public class Card {
    public enum Suit { PIK, KIER, KARO, TREFL }
    public enum Rank { DWIE(2), TRZY(3), CZTERY(4), PIEC(5), SZESC(6), SIEDM(7), OSIEM(8), DZIEWIEC(9), DZIESIEC(10), WALET(10), DAMA(10), KROL(10), AS(11);
        private final int value;
        Rank(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
    private final Suit suit;
    private final Rank rank;
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
    public int getValue() {
        return rank.getValue();
    }
    public Rank getRank() {
        return rank;
    }
    @Override
    public String toString() {
        return rank + " (" + suit + ")";
    }
}