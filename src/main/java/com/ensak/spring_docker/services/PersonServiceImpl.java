package com.ensak.spring_docker.services;

import com.ensak.spring_docker.entities.Person;
import com.ensak.spring_docker.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person addPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return savedPerson;
    }

    @Override
    public Person updatePerson(long id) {
        Person person = personRepository.findById(id).get();
        person.setName(person.getName());
        person.setCity(person.getCity());
        person.setPhoneNumber(person.getPhoneNumber());
        Person updatePerson = personRepository.save(person);
        return updatePerson;
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> allPersons = personRepository.findAll();
        return allPersons;
    }

    @Override
    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person getPersonById(long id) {
        Optional<Person> findById = personRepository.findById(id);
        return findById.get();
    }
}
