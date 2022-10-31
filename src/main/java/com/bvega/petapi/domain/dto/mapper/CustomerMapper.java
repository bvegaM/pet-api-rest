package com.bvega.petapi.domain.dto.mapper;

import com.bvega.petapi.domain.dto.CustomerDTO;
import com.bvega.petapi.domain.model.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PetMapper.class})
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "phoneNumber", target = "phoneNumber"),
            @Mapping(source = "notes", target = "notes"),
            @Mapping(source = "pets", target = "pets")
    })
    CustomerDTO toCostumerDto(Customer customer);
    List<CustomerDTO> toCostumerDtos(List<Customer> customers);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Customer toCostumer(CustomerDTO customerDTO);
}
