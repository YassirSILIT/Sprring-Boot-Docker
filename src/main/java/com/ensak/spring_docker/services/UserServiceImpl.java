package com.ensak.spring_docker.services;

import com.ensak.spring_docker.Mappers.UserMapper;
import com.ensak.spring_docker.dto.UserDto;
import com.ensak.spring_docker.entities.Profile;
import com.ensak.spring_docker.entities.User;
import com.ensak.spring_docker.exceptions.ProfileNotFoundExceptions;
import com.ensak.spring_docker.exceptions.UserNotFoundException;
import com.ensak.spring_docker.repositories.ProfileRepository;
import com.ensak.spring_docker.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private ProfileRepository profileRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,
                           ProfileRepository profileRepository,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User addUser(User user, Profile profile) {
        profileRepository.findById(profile.getId()).orElse(null);
        if (profile == null){
            throw new ProfileNotFoundExceptions("Profile not found");
        }
        user.setProfile(profile);
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<UserDto> allUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto)
                .toList();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userById = userRepository.findById(id);
        if (userById.isEmpty()){
            throw new UserNotFoundException("UserId not found " + id);
        }
        else {
            return userById.get();
        }
    }

    @Override
    public User updateUser(User userDetails, Long id) {
        Optional<User> findById = userRepository.findById(id);
        if(findById.isPresent()){

            User exitingUser = findById.get();
            exitingUser.setUsername(userDetails.getUsername());
            exitingUser.setRole(userDetails.getRole());
            exitingUser.setPassword(userDetails.getPassword());
            //exitingUser.setProfile(userDetails.getProfile().getFirstName());

            User updatedUser = userRepository.save(exitingUser);
            return updatedUser;
        }
        else{
            throw new UserNotFoundException("Not found user for updating");
        }
    }
}
