package app;

import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            String wybor = UI.wyswietlMenuGlowne(scanner);
            switch (wybor) {
                case "3":
                    System.out.println("Dziękujemy za grę. Do widzenia!");
                    break label;
                case "1":
                    Game.uruchom(scanner);
                    break;
                case "2":
                    UI.ustawLiczbeAI(scanner);
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
                    break;
            }
        }
        scanner.close();
    }
}