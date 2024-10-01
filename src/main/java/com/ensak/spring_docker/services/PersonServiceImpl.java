package com.ensak.spring_docker.services;

import com.ensak.spring_docker.entities.Person;
import com.ensak.spring_docker.exceptions.PersonNotFound;
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
    public Person updatePerson(long id, Person personDetails) {

        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()){
            Person existingPerson = person.get();

            existingPerson.setName(personDetails.getName());
            existingPerson.setCity(personDetails.getCity());
            existingPerson.setPhoneNumber(personDetails.getPhoneNumber());
            Person updatedPerson = personRepository.save(existingPerson);
            return updatedPerson;
        }
        else {
             throw new PersonNotFound("Person Not Found");
        }

        //return person.orElse(throw new PersonNotFound("Person Not Found"));

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
