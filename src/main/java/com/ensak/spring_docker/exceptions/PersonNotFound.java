package com.ensak.spring_docker.exceptions;

public class PersonNotFound extends RuntimeException{
    public PersonNotFound(String message){
        super(message);
    }
}
