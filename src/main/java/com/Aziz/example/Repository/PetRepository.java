package com.Aziz.example.Repository;

import com.Aziz.example.Entity.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {

    Page<Pet> findByPersonId(int personId, Pageable pageable);
    Optional<Pet> findByIdAndPersonId(int id, int personId);
}
