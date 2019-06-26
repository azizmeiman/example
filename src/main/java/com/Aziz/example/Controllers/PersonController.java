package com.Aziz.example.Controllers;

import com.Aziz.example.Entity.Person;
import com.Aziz.example.Repository.PersonRepository;
import com.Aziz.example.Service.personService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    personService PersonService;


    @GetMapping("/persons")
    public Page<Person> getAllPersons(Pageable pageable) {
        return PersonService.getAllPersons(pageable);
    }

    @PostMapping("/persons")
    public Person createPerson(@Valid @RequestBody Person person) {
        return PersonService.createPerson(person);
    }

    @PutMapping("/persons/{personId}")
    public Person updatePerson(@PathVariable int personId, @Valid @RequestBody Person personRequest) {

        return PersonService.updatePerson(personId,personRequest);
    }

    @DeleteMapping("/persons/{personId}")
    public ResponseEntity<?> deletePerson(@PathVariable int personId) {
        return PersonService.deletePerson(personId);
    }



}
