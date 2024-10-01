package com.ensak.spring_docker.services;

import com.ensak.spring_docker.entities.Person;

import java.util.List;

public interface PersonService {
    Person addPerson(Person person);
    Person updatePerson(long id, Person personDetails);
    List<Person> getAllPerson();
    void deletePerson(long id);
    Person getPersonById(long id);
}
