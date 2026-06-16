package app;

import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String wybor = UI.wyswietlMenuGlowne(scanner);
            if (wybor.equals("3")) {
                System.out.println("Dziękujemy za grę. Do widzenia!");
                break;
            } else if (wybor.equals("1")) {
                Game.uruchom(scanner);
            } else if (wybor.equals("2")) {
                UI.ustawLiczbeAI(scanner);
            } else {
                System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
            }
        }
        scanner.close();
    }
}