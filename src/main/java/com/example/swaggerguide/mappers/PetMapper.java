package com.example.swaggerguide.mappers;

import com.example.swaggerguide.model.Pet;
import com.swagger.client.codegen.rest.model.PetDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PetMapper {
    Pet toEntity(PetDto petDto);

    PetDto toDto(Pet pet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Pet partialUpdate(PetDto petDto,
                      @MappingTarget Pet pet);
}