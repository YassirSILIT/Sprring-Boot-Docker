package com.ensak.spring_docker.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController {

    @GetMapping("/api/v1")
    public String AllCars(){
        return "Welcome to the new repository";
    }
}
