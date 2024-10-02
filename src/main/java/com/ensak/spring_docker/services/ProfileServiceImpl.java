package com.ensak.spring_docker.services;

import com.ensak.spring_docker.entities.Profile;
import com.ensak.spring_docker.exceptions.ProfileNotFoundExceptions;
import com.ensak.spring_docker.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{
    private ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(Profile profile, Long id) {
        Optional<Profile> profileById = profileRepository.findById(id);
        if (profileById.isPresent()) {

            Profile existedProfile = profileById.get();
            existedProfile.setFirstName(profile.getFirstName());
            existedProfile.setLastName(profile.getLastName());
            existedProfile.setEmail(profile.getEmail());
            existedProfile.setBirthDate(profile.getBirthDate());
            existedProfile.setBio(profile.getBio());

            Profile updatedProfile = profileRepository.save(existedProfile);
            return updatedProfile;
        }
        throw new ProfileNotFoundExceptions("No profile existed for update");
    }

    @Override
    public List<Profile> getAllProfiles() {
        List<Profile> allProfiles = profileRepository.findAll();
        if(allProfiles.isEmpty()){
            throw new ProfileNotFoundExceptions("No profile existed");
        }
        return allProfiles;
    }

    @Override
    public void deleteProfile(Long id) {
        Optional<Profile> findProfile = profileRepository.findById(id);
        if (findProfile.isPresent()){
            profileRepository.deleteById(id);
        }
        else {
            throw new ProfileNotFoundExceptions("Profile not found " + id);
        }
    }

    @Override
    public Profile getProfileById(Long id) {
        Optional<Profile> findProfile = profileRepository.findById(id);
        if (findProfile.isPresent()){
            return profileRepository.findById(id).get();
        }
        throw new ProfileNotFoundExceptions("Profile not found " + id);
    }
}
