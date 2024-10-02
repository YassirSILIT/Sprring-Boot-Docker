package com.ensak.spring_docker.repositories;

import com.ensak.spring_docker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
