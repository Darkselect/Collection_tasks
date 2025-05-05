package org.example;

import java.util.Arrays;
import java.util.List;

import static org.example.Solution.getTop10;

public class Main {
    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(
                new Post("Post 1", 10),
                new Post("Post 2", 50),
                new Post("Post 3", 5),
                new Post("Post 4", 500),
                new Post("Post 5", 300),
                new Post("Post 6", 1000),
                new Post("Post 7", 25),
                new Post("Post 8", 60),
                new Post("Post 9", 15),
                new Post("Post 10", 45),
                new Post("Post 11", 200),
                new Post("Post 12", 700),
                new Post("Post 13", 90),
                new Post("Post 14", 33),
                new Post("Post 15", 88)
        );

        List<Post> top10 = getTop10(posts);

        System.out.println("Топ 10 самых залайканных постов:");
        for (Post post : top10) {
            System.out.println(post);
        }
    }
}