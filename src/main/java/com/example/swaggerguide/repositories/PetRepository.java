package com.example.swaggerguide.repositories;

import com.example.swaggerguide.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}