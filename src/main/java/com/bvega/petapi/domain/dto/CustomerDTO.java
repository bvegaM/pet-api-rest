package com.bvega.petapi.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@JsonDeserialize(builder = CustomerDTO.CustomerDTOBuilder.class)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String name;
    private String phoneNumber;
    private String notes;
    private List<PetDTO> pets;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CustomerDTOBuilder{ }
}
