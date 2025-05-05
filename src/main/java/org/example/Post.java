package org.example;

public class Post {
    private final String text;
    private final Integer likesCount;

    public Post(String text, Integer likesCount) {
        this.text = text;
        this.likesCount = likesCount;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    @Override
    public String toString() {
        return "Post{text='" + text + "', likes=" + likesCount + "}";
    }
}