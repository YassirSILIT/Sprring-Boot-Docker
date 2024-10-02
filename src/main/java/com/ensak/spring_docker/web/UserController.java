package com.ensak.spring_docker.web;

import com.ensak.spring_docker.dto.UserDto;
import com.ensak.spring_docker.entities.Profile;
import com.ensak.spring_docker.entities.User;
import com.ensak.spring_docker.services.ProfileService;
import com.ensak.spring_docker.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserService userService;
    private ProfileService profileService;

    public UserController(UserService userService, ProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }

    @PostMapping("/addUser/{idProfile}")
    public User addUser(@RequestBody User user,@PathVariable Long idProfile){
        Profile profile = profileService.getProfileById(idProfile);
        return userService.addUser(user,profile);
    }
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
    @GetMapping("/allUsers")
    public List<UserDto> allUsers(){
        return userService.allUsers();
    }
    @GetMapping("/userById/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PostMapping("/updateUser/{id}")
    public User updateUser(@RequestBody User user,@PathVariable Long id){
        return userService.updateUser(user,id);
    }
}
