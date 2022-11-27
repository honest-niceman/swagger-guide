package com.example.swaggerguide.controllers;

import com.example.swaggerguide.mappers.PetMapper;
import com.example.swaggerguide.services.PetSyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.swagger.client.codegen.rest.model.PetDto;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {
    private final PetSyncService petSyncService;
    private final PetMapper petMapper;

    public PetController(PetSyncService petSyncService,
                         PetMapper petMapper) {
        this.petSyncService = petSyncService;
        this.petMapper = petMapper;
    }

    @GetMapping
    public PetDto syncPetById(@RequestParam("id") Long id) {
        return petMapper.toDto(petSyncService.syncPetById(id));
    }
}