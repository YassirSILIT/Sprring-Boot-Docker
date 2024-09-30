package com.ensak.spring_docker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String address;
    long tel;
}
