package com.ensak.spring_docker.exceptions;

public class ProfileNotFoundExceptions extends RuntimeException {
    public ProfileNotFoundExceptions(String message) {
        super(message);
    }
}
