package com.ensak.spring_docker.repositories;

import com.ensak.spring_docker.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
