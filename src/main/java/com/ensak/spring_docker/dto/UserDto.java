package com.ensak.spring_docker.dto;

public record UserDto(
        Long id,
        String username,
        String role,
        String name,
        String email,
        int age,
        String bio
) {
}
