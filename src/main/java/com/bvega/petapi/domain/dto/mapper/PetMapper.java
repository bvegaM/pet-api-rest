package com.bvega.petapi.domain.dto.mapper;

import com.bvega.petapi.domain.dto.PetDTO;
import com.bvega.petapi.domain.model.Pet;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {

    @Mappings({
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "birthDate", target = "birthDate"),
            @Mapping(source = "customer.id", target = "ownerId"),
            @Mapping(source = "notes", target = "notes")
    })
    PetDTO toPetDto(Pet pet);
    List<PetDTO> toPetDtos(List<Pet> pets);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    Pet toPet(PetDTO petDTO);
}
