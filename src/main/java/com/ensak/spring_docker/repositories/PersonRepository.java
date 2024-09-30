package com.ensak.spring_docker.repositories;

import com.ensak.spring_docker.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
