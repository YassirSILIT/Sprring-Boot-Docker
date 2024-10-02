package com.ensak.spring_docker.services;

import com.ensak.spring_docker.entities.Profile;

import java.util.List;

public interface ProfileService {
      Profile addProfile(Profile profile);
      Profile updateProfile(Profile profile, Long id);
      List<Profile> getAllProfiles();
      void deleteProfile(Long id);
      Profile getProfileById(Long id);

}
