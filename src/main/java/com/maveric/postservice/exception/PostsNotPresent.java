package com.maveric.postservice.exception;

public class PostsNotPresent extends RuntimeException {
    public PostsNotPresent(String message) {
        super(message);
    }
}
