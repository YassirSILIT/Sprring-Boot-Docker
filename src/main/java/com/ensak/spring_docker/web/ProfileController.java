package com.ensak.spring_docker.web;

import com.ensak.spring_docker.entities.Profile;
import com.ensak.spring_docker.services.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {
    private ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
    @PostMapping("/addProfile")
    public Profile addProfile(@RequestBody Profile profile){
        return profileService.addProfile(profile);
    }
    @PutMapping("/updateProfile/{id}")
    public Profile updateProfile(@RequestBody Profile profile,@PathVariable Long id){
        return profileService.updateProfile(profile,id);
    }
    @GetMapping("/allProfiles")
    public List<Profile> allProfiles(){
        return profileService.getAllProfiles();
    }
    @GetMapping("/getProfile/{id}")
    public Profile getProfile(@PathVariable Long id){
        return profileService.getProfileById(id);
    }
    @DeleteMapping("/deleteProfile/{id}")
    public void deleteProfile(@PathVariable Long id){
        profileService.deleteProfile(id);
    }
}
