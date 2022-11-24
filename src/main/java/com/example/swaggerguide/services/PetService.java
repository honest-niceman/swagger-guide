package com.example.swaggerguide.services;

import com.example.swaggerguide.mappers.PetMapper;
import com.example.swaggerguide.model.Pet;
import com.example.swaggerguide.repositories.PetRepository;
import com.swagger.client.codegen.rest.api.PetApi;
import com.swagger.client.codegen.rest.model.PetDto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PetService {
    private final PetApi petApi;
    private final PetRepository petRepository;
    private final PetMapper petMapper;

    public PetService(com.swagger.client.codegen.rest.api.PetApi petApi,
                      PetRepository petRepository,
                      PetMapper petMapper) {
        this.petApi = petApi;
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }

    public Pet syncPetById(Long id) {
        return petRepository.existsById(id) ? updatePetById(id) : addPet(id);
    }

    private Pet addPet(Long id) {
        PetDto petDto = petApi.getPetById(id);
        Pet pet = petMapper.toEntity(petDto);
        return petRepository.save(pet);
    }

    private Pet updatePetById(Long id) {
        Pet pet = petRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Pet updatedPet = petMapper.partialUpdate(petApi.getPetById(id), pet);
        return petRepository.save(updatedPet);
    }
}
