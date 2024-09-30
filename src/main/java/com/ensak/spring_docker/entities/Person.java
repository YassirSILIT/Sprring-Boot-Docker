package com.ensak.spring_docker.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "persons")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Builder @ToString
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String city;
    private String phoneNumber;
}
