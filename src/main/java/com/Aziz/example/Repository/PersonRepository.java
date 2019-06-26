package com.Aziz.example.Repository;

import com.Aziz.example.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

//   @Query(value = "select * from person where id < 2",nativeQuery = true )
//    Person f();
//
//    Person findByIdAndName(,);

}
