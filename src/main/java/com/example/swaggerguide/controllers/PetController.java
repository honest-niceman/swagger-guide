package com.example.swaggerguide.controllers;

import com.example.swaggerguide.mappers.PetMapper;
import com.example.swaggerguide.services.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.swagger.client.codegen.rest.model.PetDto;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {
    private final PetService petService;
    private final PetMapper petMapper;

    public PetController(PetService petService,
                         PetMapper petMapper) {
        this.petService = petService;
        this.petMapper = petMapper;
    }

    @GetMapping
    public PetDto syncPetById(@RequestParam("id") Long id) {
        return petMapper.toDto(petService.syncPetById(id));
    }
}