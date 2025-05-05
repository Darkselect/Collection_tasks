package org.example;

import java.util.List;

import static org.example.Winner.showWinner;

public class Main {
    public static void main(String[] args) {
        showWinner(List.of(
                "Ivan 5",
                "Petr 3",
                "Alex 10",
                "Petr 8",
                "Ivan 6",
                "Alex 5",
                "Ivan 1",
                "Petr 5",
                "Alex 1"
        ));
    }
}