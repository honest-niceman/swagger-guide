package com.example.swaggerguide.services;

import com.example.swaggerguide.mappers.PetMapper;
import com.example.swaggerguide.model.Pet;
import com.example.swaggerguide.repositories.PetRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import com.swagger.client.codegen.rest.api.PetApi;

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

    public List<Pet> findInactivePets() {
        return petRepository.findInactivePets();
    }

    private Pet addPet(Long id) {
        Pet pet = petMapper.petDtoToPet(petApi.getPetById(id));
        return petRepository.save(pet);
    }

    private Pet updatePetById(Long id) {
        Pet pet = petRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Pet updatedPet = petMapper.partialUpdateFromPetDto(petApi.getPetById(id), pet);
        return petRepository.save(updatedPet);
    }
}
