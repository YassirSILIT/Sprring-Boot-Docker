package com.ensak.spring_docker.web;

import com.ensak.spring_docker.entities.Person;
import com.ensak.spring_docker.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }
    @GetMapping("/allPersons")
    public List<Person> listOfPersons(){
        return personService.getAllPerson();
    }
    @GetMapping("/getPerson/{id}")
    public Person getPerson(@PathVariable long id){
        return personService.getPersonById(id);
    }
    @DeleteMapping("/deletePerson/{id}")
    public void deletePersonById(@PathVariable long id){
        personService.deletePerson(id);
    }
    @PutMapping("/updatePerson/{id}")
    public Person updatePerson(@PathVariable long id,@RequestBody Person personDetails){
        return personService.updatePerson(id,personDetails);
    }


}
