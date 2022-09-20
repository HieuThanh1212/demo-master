package com.vmo.springboot.Demo.repositories;

import com.vmo.springboot.Demo.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IApartmentRepository extends JpaRepository<Apartment, Integer> {
    Apartment findByName(String name);

//    @Query(value = "select a from Apartment a " +
//            "where a.id = :id")
//    Apartment findById(int id);

    List<Apartment> findByNameContaining(String name);
}
