package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static List<Post> getTop10(List<Post> posts){
        PriorityQueue<Post> top10 = new PriorityQueue<>(10, Comparator.comparing(Post::getLikesCount));

        posts.forEach(p -> {
            top10.offer(p);
            if (top10.size() > 10) {
                top10.poll();
            }
        });

        List<Post> result = new ArrayList<>(top10);
        result.sort(Comparator.comparingInt(Post::getLikesCount).reversed());

        return result;
    }
}
