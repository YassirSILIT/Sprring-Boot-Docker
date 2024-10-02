package com.ensak.spring_docker.services;

import com.ensak.spring_docker.dto.UserDto;
import com.ensak.spring_docker.entities.Profile;
import com.ensak.spring_docker.entities.User;

import java.util.List;

public interface UserService {
    User addUser(User user, Profile profile);
    List<UserDto> allUsers();
    void deleteUser(Long id);
    User getUserById(Long id);
    User updateUser(User userDetails,Long id);
}
