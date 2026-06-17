# PIO-Projekt

Blackjack – Gra Karciana w Języku Java
Projekt przedstawia implementację gry karcianej Blackjack (Oczko) wykonanej zgodnie z paradygmatem programowania obiektowego w języku Java. Aplikacja umożliwia rozgrywkę pomiędzy graczem a komputerem, który pełni rolę zarówno krupiera, jak i dodatkowych uczestników gry.

Celem projektu było stworzenie kompletnej symulacji rozgrywki zgodnej z oficjalnymi zasadami Blackjacka, z uwzględnieniem mechanizmów sztucznej inteligencji sterującej zachowaniem przeciwników komputerowych.

Główne funkcjonalności:
Implementacja zasad Blackjacka
Tasowanie i rozdawanie kart z talii.
Automatyczne obliczanie wartości kart.
Obsługa kart As jako 1 lub 11 punktów.
Możliwość dobierania kart („Hit”).
Możliwość zakończenia tury („Stand”).
Wykrywanie przekroczenia limitu 21 punktów („Bust”).
Automatyczne wyłanianie zwycięzcy po zakończeniu rundy.

Tryby gry
Gracz może wybrać liczbę uczestników komputerowych:
Gracz vs Krupier
Gracz vs 1 dodatkowy gracz komputerowy + Krupier
Gracz vs 2 dodatkowych graczy komputerowych + Krupier
Gracz vs 3 dodatkowych graczy komputerowych + Krupier
Gracz vs 4 dodatkowych graczy komputerowych + Krupier
Gracz vs 5 dodatkowych graczy komputerowych + Krupier

Sztuczna nieprzewidywalność komputerów:
Przeciwnicy sterowani przez komputer nie podejmują decyzji wyłącznie na podstawie sztywnych reguł.

Zastosowano element losowości wpływający na:
moment dobierania kolejnych kart,
decyzję o zakończeniu tury,
poziom ryzyka podejmowany przez komputer.

Zasady działania krupiera:
Krupier działa zgodnie ze standardowymi zasadami Blackjacka:
Dobiera karty do momentu osiągnięcia minimum 17 punktów.
Po osiągnięciu 17 lub więcej punktów kończy swoją turę.
Nie podejmuje losowych decyzji.
Wynik krupiera służy do określenia zwycięzców rundy.
