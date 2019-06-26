package com.Aziz.example.Service;

import com.Aziz.example.Entity.Pet;
import com.Aziz.example.Repository.PersonRepository;
import com.Aziz.example.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class petService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    PersonRepository personRepository;

    @Transactional
    public Page<Pet> getAllPetsByPersonId(int personId, Pageable pageable){

        return petRepository.findByPersonId(personId, pageable);
    }


    @Transactional
    public Pet createPet( int personId, Pet pet) {
        return personRepository.findById(personId).map(person -> {
            pet.setPerson(person);
            return petRepository.save(pet);
        }).orElseThrow(() -> new ResourceNotFoundException("Person ID " + personId + " not found"));
    }

    @Transactional
    public Pet updatePet(int personId, int petId,Pet petRequest) {
        if(!personRepository.existsById(personId)) {
            throw new ResourceNotFoundException("Person ID " + personId + " not found");
        }

        return petRepository.findById(petId).map(pet -> {
            pet.setName(petRequest.getName());
            return petRepository.save(pet);
        }).orElseThrow(() -> new ResourceNotFoundException("Pet ID " + petId + "not found"));
    }

    @Transactional
    public ResponseEntity<?> deletePet(int personId, int petId) {
        return petRepository.findByIdAndPersonId(petId, personId).map(pet -> {
            petRepository.delete(pet);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Pet not found with ID " + petId + " and person ID " + personId));
    }
}
