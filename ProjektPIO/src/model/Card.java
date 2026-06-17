package model;

public class Card {
    public enum Symbol { PIK, KIER, KARO, TREFL }
    public enum Waga {
        DWA(2), TRZY(3), CZTERY(4), PIEC(5), SZESC(6), SIEDEM(7), OSIEM(8),
        DZIEWIEC(9), DZIESIEC(10), WALET(10), DAMA(10), KROL(10), AS(11);

        private final int wartosc;
        Waga(int wartosc) { this.wartosc = wartosc; }
        public int getWartosc() { return wartosc; }
    }

    private final Symbol symbol;
    private final Waga waga;
    public Card(Symbol symbol, Waga waga) {
        this.symbol = symbol;
        this.waga = waga;
    }

    public int getWartosc() { return waga.getWartosc(); }
    public Waga getWaga() { return waga; }
    @Override
    public String toString() { return waga + " (" + symbol + ")"; }
}