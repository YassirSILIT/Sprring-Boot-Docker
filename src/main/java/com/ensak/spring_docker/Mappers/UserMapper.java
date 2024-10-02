package com.ensak.spring_docker.Mappers;

import com.ensak.spring_docker.dto.UserDto;
import com.ensak.spring_docker.entities.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class UserMapper {
    public UserDto toDto(User user){
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getRole(),
                user.getProfile().getFirstName() + " " + user.getProfile().getLastName(),
                user.getProfile().getEmail(),
                Period.between(user.getProfile().getBirthDate(), LocalDate.now()).getYears(),
                user.getProfile().getBio()
        );
    }
}
