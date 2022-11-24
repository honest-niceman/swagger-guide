package com.example.swaggerguide.mappers;

import com.example.swaggerguide.dtos.VisitWithPetDto;
import com.example.swaggerguide.model.Visit;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface VisitMapper {
    Visit toEntity(VisitWithPetDto visitWithPetDto);

    VisitWithPetDto toDto(Visit visit);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Visit partialUpdate(VisitWithPetDto visitWithPetDto,
                        @MappingTarget Visit visit);
}