package com.Aziz.example.Controllers;

import com.Aziz.example.Entity.Pet;
import com.Aziz.example.Service.petService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PetController {

    @Autowired
    petService PetService;

    @GetMapping("/persons/{personId}/pets")
    public Page<Pet> getAllPetsByPersonId(@PathVariable(value = "personId") int personId, Pageable pageable) {
        return PetService.getAllPetsByPersonId(personId, pageable);
    }


    @PostMapping("/persons/{personId}/pets")
    public Pet createPet(@PathVariable (value = "personId") int personId, @Valid @RequestBody Pet pet) {
        return PetService.createPet(personId, pet);
    }


    @PutMapping("/persons/{personId}/pets/{petId}")
    public Pet updatePet(@PathVariable (value = "postId") int personId, @PathVariable (value = "petId") int petId, @Valid @RequestBody Pet petRequest) {
        return PetService.updatePet(personId,petId,petRequest);
    }

    @DeleteMapping("/persons/{personId}/pets/{petId}")
    public ResponseEntity<?> deletePet(@PathVariable (value = "personId") int personId, @PathVariable (value = "commentId") int petId) {
        return PetService.deletePet(personId,petId);
    }


}
