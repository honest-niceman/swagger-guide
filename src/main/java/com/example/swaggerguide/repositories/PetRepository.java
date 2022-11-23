package com.example.swaggerguide.repositories;

import com.example.swaggerguide.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    @Query("select p from Pet p where p.visits is empty order by p.name")
    List<Pet> findInactivePets();
}