package com.example.swaggerguide.mappers;

import com.example.swaggerguide.dtos.PetBasicDto;
import com.example.swaggerguide.model.Pet;
import com.example.swaggerguide.model.Visit;
import com.swagger.client.codegen.rest.model.PetDto;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PetMapper {
    @Mapping(source = "userId", target = "user.id")
    Pet petBasicDtoToPet(PetBasicDto petBasicDto);

    @Mapping(source = "user.id", target = "userId")
    PetBasicDto petToPetBasicDto(Pet pet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "userId", target = "user.id")
    Pet partialUpdateFromPetBasicDto(PetBasicDto petBasicDto,
                                     @MappingTarget Pet pet);

    Pet petDtoToPet(PetDto petDto);

    PetDto petToPetDto(Pet pet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Pet partialUpdateFromPetDto(PetDto petDto,
                                @MappingTarget Pet pet);

    default Set<Integer> visitsToVisitQuantities(Set<Visit> visits) {
        return visits.stream().map(Visit::getQuantity).collect(Collectors.toSet());
    }
}