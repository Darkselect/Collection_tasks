package org.example;

import java.util.*;

public class Winner {
    public static void showWinner(List<String> competitors) {
        Map<String, Integer> totalScores = new HashMap<>();
        Map<String, Integer> reachedFinalScoreAt = new HashMap<>();

        int finalScore = 0;

        for (String line : competitors) {
            String[] parts = line.split(" ");
            String name = parts[0];
            int score = Integer.parseInt(parts[1]);
            totalScores.put(name, totalScores.getOrDefault(name, 0) + score);
        }


        for (int value : totalScores.values()) {
            finalScore = Math.max(finalScore, value);
        }

        totalScores.clear();

        String winner;

        for (int i = 0; i < competitors.size(); i++) {
            String[] parts = competitors.get(i).split(" ");
            String name = parts[0];
            int score = Integer.parseInt(parts[1]);

            int updatedScore = totalScores.getOrDefault(name, 0) + score;
            totalScores.put(name, updatedScore);

            if (updatedScore >= finalScore && !reachedFinalScoreAt.containsKey(name)) {
                reachedFinalScoreAt.put(name, i);
            }
        }

        winner = reachedFinalScoreAt.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("Победитель: " + winner);
    }

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
