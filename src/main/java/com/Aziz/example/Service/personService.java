package com.Aziz.example.Service;

import com.Aziz.example.Entity.Person;
import com.Aziz.example.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class personService {

    @Autowired
    PersonRepository personRepository;

    @Transactional
    public Page<Person> getAllPersons(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Transactional
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    public Person updatePerson(int personId, Person personRequest) {

        return personRepository.findById(personId).map(person -> {

            person.setName(personRequest.getName());

            return personRepository.save(person);
        }).orElseThrow(() -> new ResourceNotFoundException("PersonId " + personId + " not found"));
    }

    @Transactional
    public ResponseEntity<?> deletePerson(int personId) {
        return personRepository.findById(personId).map(person -> {
            personRepository.delete(person);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("person ID " + personId + " not found"));
    }


    @Transactional
    public Optional<Person> getPerson(int id){
        Optional<Person> p = personRepository.findById(id);
        if(p.isPresent()){
            return p;

        }else throw new RuntimeException("person with id"+id+" not founded");
    }
}
